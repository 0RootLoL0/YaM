/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.rotor.data;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.rootlol.yam.adapter.rotor.RotorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RotorDataSourse extends PositionalDataSource<RotorInterface> {

    List<RotorInterface> data;

    private static RotorDataSourse istance;
    public static RotorDataSourse getInstance() {
        if (istance == null) {
            istance = new RotorDataSourse();
        }
        return istance;
    }
    public static RotorDataSourse getNewInstance() {
        istance = new RotorDataSourse();
        return istance;
    }

    public void setDate(List<RotorInterface> temp) {
        this.data = temp;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<RotorInterface> callback) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (data != null && data.size() != 0) {
                    List<RotorInterface> tempList = new ArrayList<>();

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
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<RotorInterface> callback) {
        List<RotorInterface> tempList = new ArrayList<>();

        for (int i = params.startPosition; i <= params.loadSize + params.startPosition && i <= data.size() - 1; i++) {
            tempList.add(data.get(i).setPosition(i));
        }


        callback.onResult(tempList);
    }

}