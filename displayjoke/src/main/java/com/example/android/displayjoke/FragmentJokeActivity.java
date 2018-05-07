package com.example.android.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentJokeActivity extends Fragment {

    public FragmentJokeActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke_activity, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(Activity_Joke.JOKE_KEY);
        //Toast.makeText(getActivity(), joke, Toast.LENGTH_SHORT).show();
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_textview);

        if (!TextUtils.isEmpty(joke)) {
            jokeTextView.setText(joke);
        }

        return root;
    }
}
