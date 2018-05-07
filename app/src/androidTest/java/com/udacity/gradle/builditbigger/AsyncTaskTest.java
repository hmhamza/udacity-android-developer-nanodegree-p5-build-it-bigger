package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityTestCase;
import android.text.TextUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskTest  extends ActivityTestCase {

    String result = null;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAAlbumGetTask() throws InterruptedException {

        final CountDownLatch signal = new CountDownLatch(1);

        Task_RetrieveJokes task = new Task_RetrieveJokes();
        task.setListener(new Task_RetrieveJokes.GetJokeTaskListener() {
            @Override
            public void onComplete(String res) {
                result = res;
                signal.countDown();
            }
        });
        task.execute(mActivityRule.getActivity());

        signal.await(30, TimeUnit.SECONDS);

        assertFalse(TextUtils.isEmpty(result));
        assertTrue(result.equals("Joke from Java Library!"));
    }
}
