/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.track.data;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.track.TrackListInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrackDataSourse extends PositionalDataSource<TrackListInterface> {

    List<TrackListInterface> data;
    int type;

    private static TrackDataSourse istance;
    public static TrackDataSourse getInstance() {
        if (istance == null) {
            istance = new TrackDataSourse();
        }
        return istance;
    }
    public static TrackDataSourse getNewInstance() {
        istance = new TrackDataSourse();
        return istance;
    }
    public void setData(List<TrackListInterface> data, int type){
        this.data = data;
        this.type = type;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<TrackListInterface> callback) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (data != null && data.size() != 0) {
                    List<TrackListInterface> tempList = new ArrayList<>();

                    for (int i = 0; i < params.pageSize && i < data.size(); i++) {
                        tempList.add(data.get(i).setPosition(i));
                    }

                    callback.onResult(tempList, 0);
                    timer.cancel();
                }
            }
        }, 0, 10);

    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<TrackListInterface> callback) {
        List<TrackListInterface> tempList = new ArrayList<>();

            for (int i = params.startPosition; i <= params.loadSize+params.startPosition && i <= data.size()-1; i++) {
                tempList.add(data.get(i).setPosition(i));
            }



        callback.onResult(tempList);
    }
}