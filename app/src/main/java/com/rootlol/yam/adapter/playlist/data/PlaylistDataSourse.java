package com.rootlol.yam.adapter.playlist.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.rootlol.yam.App;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.item.LikeTrackType;
import com.rootlol.yam.service.PlayerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PlaylistDataSourse extends PositionalDataSource<PlaylistListInterface> {

    private boolean downloadFeed         = false;
    private boolean downloadUserPlaylist = false;

    private int paramsStartPosition;

    private List<PlaylistListInterface> Playlist = new ArrayList<>();
    public static PlaylistDataSourse playlistDataSourse;
    public static PlaylistDataSourse getInstance() {
        if(playlistDataSourse == null) {
            playlistDataSourse = new PlaylistDataSourse();
        }
        return playlistDataSourse;
    }
    public static PlaylistDataSourse getNewInstance() {
        playlistDataSourse = new PlaylistDataSourse();
        return playlistDataSourse;
    }

    public void setDate( List<PlaylistListInterface> Ptmp, int type){
             if (type == PlaylistListInterface.FEED && Playlist.size() == 0)          Playlist.addAll(Ptmp);
        else if (type == PlaylistListInterface.USER_PLAYLIST && Playlist.size() == 0) Playlist.addAll(Ptmp);
        else if (type == PlaylistListInterface.FEED && Playlist.size() != 0){
            Ptmp.addAll(Playlist);
            Playlist = Ptmp;
        }
        else if (type == PlaylistListInterface.USER_PLAYLIST && Playlist.size() != 0) Playlist.addAll(Ptmp);


        if (type == PlaylistListInterface.FEED) downloadFeed = true;
        else if (type == PlaylistListInterface.USER_PLAYLIST) downloadUserPlaylist = true;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<PlaylistListInterface> callback) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (downloadFeed&downloadUserPlaylist){
                    List<PlaylistListInterface> tempList = new ArrayList<>();
                    for (int i = 0; i < params.pageSize && i < Playlist.size(); i++) {
                        tempList.add(Playlist.get(i).setPosition(i));
                    }
                    paramsStartPosition = tempList.size();
                    callback.onResult(tempList, 0);
                    timer.cancel();
                }
            }
        }, 0, 10);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<PlaylistListInterface> callback) {
        if (downloadFeed && downloadUserPlaylist){
            List<PlaylistListInterface> tempList = new ArrayList<>();

            for (int i = params.startPosition; i < params.loadSize+params.startPosition && i < Playlist.size(); i++) {
                tempList.add(Playlist.get(i).setPosition(i));
            }
            paramsStartPosition = paramsStartPosition+tempList.size();
            callback.onResult(tempList);
        }
    }
}