package com.rootlol.yam.nadapter.playlist.data;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.api.MusicYandexApi;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.nadapter.playlist.PlaylistListInterface;
import com.rootlol.yam.nadapter.playlist.item.PlaylistType;
import com.rootlol.yam.pojo.feed.GeneratedPlaylist;
import com.rootlol.yam.pojo.playlistslist.PlaylistListPojo;
import com.rootlol.yam.pojo.playlistslist.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistDataSourse extends PositionalDataSource<PlaylistListInterface> {
    List<GeneratedPlaylist> generatedPlaylists;
    List<Result> playlistLists;
    private UsersDB.UserDao userDao;


    public PlaylistDataSourse(List<GeneratedPlaylist> generatedPlaylists) {
        this.generatedPlaylists = generatedPlaylists;
        userDao = App.getInstance().getDatabase().userDao();

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<PlaylistListInterface> callback) {
        List<PlaylistListInterface> result = new ArrayList<>();
        for (int i = 0; i < params.requestedLoadSize && i <= generatedPlaylists.size()-1; i++) result.add(generatedPlaylists.get(i));
        if (result.size() == generatedPlaylists.size()) MusicYandexApi.getInstance().getPlaylists(userDao.getAll().get(0).user_id, "OAuth " +userDao.getAll().get(0).token).enqueue(new Callback<PlaylistListPojo>() {
            @Override
            public void onResponse(Call<PlaylistListPojo> call, Response<PlaylistListPojo> response) {
                playlistLists = response.body().getResult();
            }

            @Override
            public void onFailure(Call<PlaylistListPojo> call, Throwable t) {
                Toast.makeText(App.getInstance().getAppCompatActivity(), R.string.not_net, Toast.LENGTH_LONG).show();
            }
        });
        callback.onResult(result, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<PlaylistListInterface> callback) {
        List<PlaylistListInterface> result = new ArrayList<>();
        for (int i = params.startPosition; i < params.startPosition+params.loadSize && i <= generatedPlaylists.size()-1; i++) result.add(generatedPlaylists.get(i));
        if (params.startPosition == generatedPlaylists.size())result.add(new PlaylistType("Мне нравится",
                "",
                "https://music.yandex.ru/blocks/playlist-cover/playlist-cover_like.png", result.size()));
        if (result.size() == 0) MusicYandexApi.getInstance().getPlaylists(userDao.getAll().get(0).user_id, "OAuth " +userDao.getAll().get(0).token).enqueue(new Callback<PlaylistListPojo>() {
            @Override
            public void onResponse(Call<PlaylistListPojo> call, Response<PlaylistListPojo> response) {
                playlistLists = response.body().getResult();
            }

            @Override
            public void onFailure(Call<PlaylistListPojo> call, Throwable t) {
                Toast.makeText(App.getInstance().getAppCompatActivity(), R.string.not_net, Toast.LENGTH_LONG).show();
            }
        });

        if (playlistLists != null) for (int i = params.startPosition+result.size(); i <  params.startPosition+params.loadSize && i < playlistLists.size()+generatedPlaylists.size()+1; i++) {
            result.add(playlistLists.get(i-(generatedPlaylists.size()+1)));
        }

        callback.onResult(result);
    }
}