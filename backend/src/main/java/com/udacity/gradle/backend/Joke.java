/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: RecipeData.java
 * -The object model for the joke data we are sending through endpoints
 *      +jokeText
 *
 *
 */


package com.udacity.gradle.backend;

public class Joke {

    private String jokeText;

    public Joke(String text) {
        this.jokeText = text;
    }

    public String getData() {

        return jokeText;
    }

    public void setData(String data) {

        jokeText = data;
    }
}