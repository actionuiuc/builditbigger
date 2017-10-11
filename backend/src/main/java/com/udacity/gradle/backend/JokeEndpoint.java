/*
 * Brian Jackson
 * bj1412@att.com
 * 10/9/2017
 * Android Developer Nanodegree
 * Project 4: Build it Bigger
 *
 * Filename: JokeEndpoint.java
 * -Joke endpoint class we are exposing.
 *
 * For step-by-step instructions on connecting your Android application to this backend module,
 * see "App Engine Java Endpoints Module" template documentation at
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 *
 *
 */

package com.udacity.gradle.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.udacity.gradle.jokes.Joker;


@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.gradle.udacity.com",
                ownerName = "backend.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    //An endpoint method that pulls jokes from the java library
    @ApiMethod(name = "tellJoke")
    public Joke tellJoke() {

        Joker myJoker = new Joker();
        Joke joke = new Joke(myJoker.getJoke());

        return joke;
    }


}
