/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: MainActivity.java
 *  I implemented the following required features:
 *      -Step 1:  Created a new Gradle Java project (javajokes) to provide jokes via toast (code commented out).
 *      -Step 2:  Get joke from java library and pass it in an intent extra to the Android Library (jokelibrary) activity (JokeActivity) to display
 *      -Step 3:  Created async task (TellJokeAsyncTask) to retrieve jokes using GCE development server and
 *                pass the joke via an intent extra to the Android Library activity (JokeActivity) to display
 */

package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.jokelibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        //Step1 - Joke provided by java library
        //Toast.makeText(this, myJoker.getJoke(), Toast.LENGTH_SHORT).show();

        //Step2 - Get joke from java library and pass it in an intent extra to the Android Library activity (JokeActivity) to display joke
        /*
        Intent intent = new Intent(this, JokeActivity.class);
        Joker myJoker = new Joker();
        String joke = myJoker.getJoke();
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
        */

        //Step3 - Async task to retrieve jokes using GCE development server
        new TellJokeIntentTask(this).execute();
    }

    public static class TellJokeIntentTask extends TellJokeAsyncTask {

        private Context mContext;

        public TellJokeIntentTask(Context context) {
            mContext = context;
        }

        @Override
        protected void onPostExecute(String resultJoke) {

            if (resultJoke == null) {
                Toast.makeText(mContext, "Joke not found", Toast.LENGTH_SHORT).show();
                return;
            }

            //Step3 - Get joke from GCE development server and pass it in an intent extra to the Android Library activity
            //(JokeActivity) to display
            Intent intent = new Intent(mContext, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE_KEY, resultJoke);
            mContext.startActivity(intent);
        }
    }


}
