package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.displayjoke.Activity_Joke;
import com.example.android.jokeslibrary.Joker;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by HaZa on 04-May-18.
 */

//class Task_RetrieveJokes extends AsyncTask<Pair<Context, String>, Void, String> {
class Task_RetrieveJokes extends AsyncTask<Context, Void, String> {

    private static MyApi myApiService = null;
    private Context context;

    private GetJokeTaskListener  mListener = null;

    private ProgressBar spinner;

    public Task_RetrieveJokes( ProgressBar spinner){
        this.spinner=spinner;
    }

    @Override
    //protected String doInBackground(Pair<Context, String>... params) {
    protected String doInBackground(Context... params) {

        //spinner.setVisibility(View.VISIBLE);

        if(myApiService == null) {  // Only do this once


            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();

        }

        context = params[0];

        try {
            return myApiService.getJokeFromLibrary().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        spinner.setVisibility(View.GONE);

        if (this.mListener != null)
            this.mListener.onComplete(result);

        Intent intent = new Intent(context, Activity_Joke.class);
        intent.putExtra(Activity_Joke.JOKE_KEY, result);
        context.startActivity(intent);
    }

    public interface GetJokeTaskListener {
        public void onComplete(String result);
    }

    public void setListener(GetJokeTaskListener  listener) {
        this.mListener = listener;
    }
}
