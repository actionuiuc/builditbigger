/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: Joker.java
 *  I implemented the following required features:
 *      -Step 1:  Created a new Gradle Java project (javajokes) to provide jokes.
 *      -Jokes are hard-coded into a string array.
 *      -Used a pseudorandom number to select joke from the JOKES array.
 */

package com.udacity.gradle.jokes;

import java.util.Random;

public class Joker{

    private static final String[] JOKES = {
            "This is joke 1.",
            "This is joke 2.",
            "This is joke 3.",
            "This is joke 4."
    };

    public String getJoke() {
        int randomNum = new Random().nextInt(JOKES.length);
        return JOKES[randomNum];
    }

}
