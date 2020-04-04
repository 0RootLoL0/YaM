package com.rootlol.yam.api;

import com.rootlol.yam.pojo.downloadinfo.DownloadInfoPojo;
import com.rootlol.yam.pojo.feed.FeedPojo;
import com.rootlol.yam.pojo.likestracks.LikesTracksPojo;
import com.rootlol.yam.pojo.playlistslist.PlaylistListPojo;
import com.rootlol.yam.pojo.track.TrackPojo;
import com.rootlol.yam.pojo.usersplaylists.UsersPlaylistsPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class MusicYandexApi {
    public interface Api {
        @GET("feed")
        Call<FeedPojo> feed(@Header("Authorization") String authorization);

        @GET("users/{id}/playlists/list")
        Call<PlaylistListPojo> getPlaylists(@Path("id") int UserId, @Header("Authorization") String authorization);





        @GET("users/{id}/likes/tracks")
        Call<LikesTracksPojo> getGetLikes(@Path("id") int UserId, @Header("Authorization") String authorization);

        @FormUrlEncoded
        @POST("users/{id}/playlists")
        Call<UsersPlaylistsPojo> getTrackList(@Path("id") int UserId, @Header("Authorization") String authorization, @FieldMap Map<String, String> body);

        @GET("tracks/{id}")
        Call<TrackPojo> getTrackInfo(@Path("id") int TrackId, @Header("Authorization") String authorization);

        @GET("tracks/{id}/download-info")
        Call<DownloadInfoPojo> getDownloadInfoUrl(@Path("id") int TrackId, @Header("Authorization") String authorization);


    }
    private static String urlBase = "https://api.music.yandex.net/";
    private static Retrofit retrofit;
    private static Api api;

    public static Api getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(urlBase)
                    .build();
        }
        api = retrofit.create(Api.class);
        return api;
    }
}
