package com.rootlol.yam.adapter.playlist.data;

import android.view.View;

import androidx.paging.DataSource;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.rootlol.yam.App;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.item.FeedType;
import com.rootlol.yam.adapter.playlist.item.LikeTrackType;
import com.rootlol.yam.adapter.playlist.item.PlaylistType;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yamapilib.MusicYandexApi;
import io.github.rootlol.yamapilib.pojo.ApiPojoFeed;
import io.github.rootlol.yamapilib.pojo.ApiPojoPlaylistList;
import io.github.rootlol.yamapilib.pojo.GeneratedPlaylist;
import io.github.rootlol.yamapilib.pojo.ResultAPPL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistDataSourceFactory extends DataSource.Factory{


    private void downloadData(int UserID, String token, Snackbar snackbar, SwipeRefreshLayout SRL){
        MusicYandexApi.getInstance().feed("OAuth "+token).enqueue(new Callback<ApiPojoFeed>() {
            @Override
            public void onResponse(Call<ApiPojoFeed> call, Response<ApiPojoFeed> response) {
                App.getInstance().setApiPojoFeed(response.body());
                List<PlaylistListInterface> listPlaylist = new ArrayList<>();

                for (GeneratedPlaylist w: response.body().getResult().getGeneratedPlaylists()) {
                    listPlaylist.add(new FeedType(w));
                }

                PlaylistDataSourse.getInstance().setDate(listPlaylist, PlaylistListInterface.FEED);
                SRL.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ApiPojoFeed> call, Throwable t) {
                snackbar.setAction("Reload", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //downloadData(UserID, token, snackbar);
                    }
                }).show();
                SRL.setRefreshing(false);
            }
        });
        MusicYandexApi.getInstance().getPlaylists(UserID, "OAuth "+token).enqueue(new Callback<ApiPojoPlaylistList>() {
            @Override
            public void onResponse(Call<ApiPojoPlaylistList> call, Response<ApiPojoPlaylistList> response) {
                App.getInstance().setApiPojoPlaylistList(response.body());
                List<PlaylistListInterface> listPlaylist = new ArrayList<>();

                listPlaylist.add(new LikeTrackType());
                for (ResultAPPL w: response.body().getResult()) {
                    listPlaylist.add(new PlaylistType(w));
                }

                PlaylistDataSourse.getInstance().setDate(listPlaylist, PlaylistListInterface.USER_PLAYLIST);
                SRL.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ApiPojoPlaylistList> call, Throwable t) {
                snackbar.setAction("Reload", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //downloadData(UserID, token, snackbar);
                    }
                }).show();
                SRL.setRefreshing(false);
            }
        });
    }
    public PlaylistDataSourceFactory(int UserID, String token, Snackbar snackbar, SwipeRefreshLayout SRL) {
        downloadData(UserID, token, snackbar, SRL);
    }

    @Override
    public DataSource create() {
        return PlaylistDataSourse.getInstance();
    }
}