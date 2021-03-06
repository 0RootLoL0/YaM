/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package io.github.rootlol.yamapilib;

import java.util.Map;

import io.github.rootlol.yamapilib.pojo.oauth.ApiPojoToken;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class OauthYandexApi {

    public interface Api {
        @FormUrlEncoded
        @POST("token")
        Call<ApiPojoToken> login(@FieldMap Map<String, String> body);
    }

    private static String urlBase = "https://oauth.yandex.ru/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
