/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: JokeTellTest.java
 * -Step 5:  Added code to test that the Async task (TellJokeAsyncTask.java) successfully retrieves a non-empty string.
 *              -Checks if returned string is NOT null.
 *              -Checks if returned string has a length greater than 0.  (not blank/empty)
 *
 */


package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeTellTest  {

    private static final String TAG = JokeTellTest.class.getSimpleName();

    @Test
    public void testVerifyJokeResponse() {

        TellJokeAsyncTask tellJokeAsyncTask = new TellJokeAsyncTask();
        tellJokeAsyncTask.execute();

        try {
            String joke = tellJokeAsyncTask.get();
            Log.d(TAG, "Joke: " + joke);
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }


}
