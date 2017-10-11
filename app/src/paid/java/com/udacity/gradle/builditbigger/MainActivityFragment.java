/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: MainActivityFragment.java (paid)
 * -Step 0:  Display Ad Banner using starter code (code commented out).
 * -Fragment used by the MainActivity for the paid app flavor.
 * -Displays a loading indicator (spinner) that is shown while the joke is being retrieved and disappears when the joke
 *  is ready.
 * -Implements joke button click handling.
 *
 *
 */

package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivityFragment extends Fragment {

    private ProgressBar spinner;
    private TextView gettingJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        //Step0
        /*
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        */

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        gettingJoke = (TextView) root.findViewById(R.id.getting_text_view);

        Button jokeButton = (Button) root.findViewById(R.id.joke_button);

        spinner.setVisibility(View.GONE);
        gettingJoke.setVisibility(View.GONE);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                gettingJoke.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).tellJoke(root);
            }
        });

        return root;
    }

    @Override
    public void onPause(){
        super.onPause();
        spinner.setVisibility(View.INVISIBLE);  //hide spinner & text when user returns to fragment view after joke is displayed
        gettingJoke.setVisibility(View.INVISIBLE);
    }
}
