package com.rootlol.yam.nadapter.track.data;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.rootlol.yam.App;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.nadapter.track.TrackListInterface;
import com.rootlol.yam.pojo.usersplaylists.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackDataSourse extends PositionalDataSource<TrackListInterface> {
    private UsersDB.UserDao userDao;
    List<Track> results;

    public TrackDataSourse(List<Track> results) {
        userDao = App.getInstance().getDatabase().userDao();
        this.results = results;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<TrackListInterface> callback) {
        List<TrackListInterface> result = new ArrayList<>();

        for (int i = 0; i < params.requestedLoadSize && i <= results.size()-1; i++) result.add(results.get(i));

        callback.onResult(result, 0);

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<TrackListInterface> callback) {
        List<TrackListInterface> result = new ArrayList<>();
        for (int i = params.startPosition; i < params.loadSize+params.startPosition && i <= results.size()-1; i++) result.add(results.get(i));
        callback.onResult(result);
    }
}