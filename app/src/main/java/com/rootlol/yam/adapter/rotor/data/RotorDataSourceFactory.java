/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.rotor.data;

import android.view.View;

import androidx.paging.DataSource;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.rootlol.yam.App;
import com.rootlol.yam.adapter.rotor.RotorInterface;
import com.rootlol.yam.adapter.rotor.item.StationType;

import java.util.ArrayList;
import java.util.List;

import io.github.rootlol.yamapilib.MusicYandexApi;
import io.github.rootlol.yamapilib.pojo.rotor.ApiPojoRotorStationsDashboard;
import io.github.rootlol.yamapilib.pojo.rotor.Station;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RotorDataSourceFactory extends DataSource.Factory{


    private void downloadData(Snackbar snackbar, SwipeRefreshLayout SRL){
        MusicYandexApi.getInstance().getRotorStationsDashboard("OAuth "+App.getInstance().getDatabase().userDao().getAll().get(0).token).enqueue(new Callback<ApiPojoRotorStationsDashboard>() {
            @Override
            public void onResponse(Call<ApiPojoRotorStationsDashboard> call, Response<ApiPojoRotorStationsDashboard> response) {
                List<RotorInterface> temp = new ArrayList<>();

                for (Station w: response.body().getResult().getStations()) {
                    temp.add(new StationType(w));
                }

                RotorDataSourse.getInstance().setDate(temp);
                SRL.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ApiPojoRotorStationsDashboard> call, Throwable t) {
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
    public RotorDataSourceFactory(Snackbar snackbar, SwipeRefreshLayout SRL) {
        downloadData(snackbar, SRL);
    }

    @Override
    public DataSource create() {
        return RotorDataSourse.getInstance();
    }
}