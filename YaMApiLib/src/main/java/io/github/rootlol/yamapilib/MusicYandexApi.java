/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package io.github.rootlol.yamapilib;

import java.util.Map;

import io.github.rootlol.yamapilib.pojo.ApiPojoDownloadInfo;
import io.github.rootlol.yamapilib.pojo.ApiPojoLikesTracks;
import io.github.rootlol.yamapilib.pojo.ApiPojoPlaylistList;
import io.github.rootlol.yamapilib.pojo.ApiPojoTrack;
import io.github.rootlol.yamapilib.pojo.ApiPojoTracksList;
import io.github.rootlol.yamapilib.pojo.feed.ApiPojoFeed;
import io.github.rootlol.yamapilib.pojo.rotor.ApiPojoRotorStationsDashboard;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public class MusicYandexApi {
    public interface Api {
        @GET("feed")
        Call<ApiPojoFeed> feed(@Header("Authorization") String authorization);

        @GET("users/{id}/playlists/list")
        Call<ApiPojoPlaylistList> getPlaylists(@Path("id") int UserId, @Header("Authorization") String authorization);


        @GET("users/{id}/likes/tracks")
        Call<ApiPojoLikesTracks> getGetLikes(@Path("id") int UserId, @Header("Authorization") String authorization);

        @FormUrlEncoded
        @POST("users/{id}/playlists")
        Call<ApiPojoTracksList> getTrackList(@Path("id") int UserId, @Header("Authorization") String authorization, @FieldMap Map<String, String> body);

        @GET("tracks/{id}")
        Call<ApiPojoTrack> getTrackInfo(@Path("id") int TrackId);

        @GET("tracks/{id}/download-info")
        Call<ApiPojoDownloadInfo> getDownloadInfoUrl(@Path("id") int TrackId, @Header("Authorization") String authorization);

        @GET("rotor/stations/dashboard")
        Call<ApiPojoRotorStationsDashboard> getRotorStationsDashboard(@Header("Authorization") String authorization);

        @GET
        Call<String> downloadUrl(@Url String url);

        @GET
        @Streaming
        Call<ResponseBody> getCover(@Url String filepath);


    }
    private static String urlBase = "https://api.music.yandex.net/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
