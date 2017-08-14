package com.github.abdurahmanovart.itunesfinder.net;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author Abdurakhmanov on 13.08.17
 */

public class ApiClient {
    public static final String BASE_URL = "https://itunes.apple.com/";
    private static Retrofit sRetrofit = null;

    private ApiClient() {
        throw new IllegalStateException("can't create object");
    }

    public static Retrofit getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
