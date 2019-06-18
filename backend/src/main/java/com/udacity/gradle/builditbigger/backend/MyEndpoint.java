package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.Jokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that returns a bad joke */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        Jokes jokes = new Jokes();
        String joke = jokes.getJoke();

        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }

}
