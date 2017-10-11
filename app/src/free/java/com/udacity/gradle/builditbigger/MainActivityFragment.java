/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: MainActivityFragment.java (free)
 * -Fragment used by the MainActivity for the free app flavor.
 * -Displays Interstitial Ad after the user hits the 'Tell Joke' button and before the joke is shown.
 * -Displays a loading indicator (spinner) that is shown while the joke is being retrieved and disappears when the joke
 *  is ready.
 * -Implements joke button click handling.
 *
 *
 */

package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivityFragment extends Fragment {

    private InterstitialAd mInterstitialAd;
    private ProgressBar spinner;
    private TextView gettingJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        mInterstitialAd = new InterstitialAd(getContext());
        //mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        Button jokeButton = (Button) root.findViewById(R.id.joke_button);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        gettingJoke = (TextView) root.findViewById(R.id.getting_text_view);

        spinner.setVisibility(View.GONE);
        gettingJoke.setVisibility(View.GONE);

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                spinner.setVisibility(View.VISIBLE);
                gettingJoke.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).tellJoke(root);

            }
        });

        //Ad banner code
/*        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);*/

        return root;
    }

    @Override
    public void onPause(){
        super.onPause();
        spinner.setVisibility(View.INVISIBLE);  //hide spinner & text when user returns to fragment view after joke is displayed
        gettingJoke.setVisibility(View.INVISIBLE);
    }

}
