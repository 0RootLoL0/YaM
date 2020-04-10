/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.activity.controller.homecontroller;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.google.android.material.snackbar.Snackbar;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.rotor.RotorAdapter;
import com.rootlol.yam.adapter.rotor.RotorInterface;
import com.rootlol.yam.adapter.rotor.data.RotorDataSourceFactory;
import com.rootlol.yam.db.UsersDB;

import static android.content.Context.MODE_PRIVATE;

public class RadioController extends Controller implements SwipeRefreshLayout.OnRefreshListener, RotorAdapter.onClickListener{

    private SwipeRefreshLayout SRL;
    private RecyclerView RRV;
    private Snackbar SBNN;

    private UsersDB.UserDao userDao;
    private SharedPreferences sPref;

    private PagedList.Config config;



    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_rotor, container, false);
       try{
            bind(view);
            setDB();
            config = new PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(sPref.getInt("LIMIT", App.defultItemView))
                    .build();
            updataDatalist();
        }catch (Exception e) {
            ExceptionActivity.viewError(e.toString());}
        return view;
    }
    private void bind(View view){
        SRL = view.findViewById(R.id.rotorRefresh);
        SRL.setOnRefreshListener(this);
        RRV = view.findViewById(R.id.rotorList);
        RRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RRV.setHasFixedSize(true);
        SBNN = Snackbar.make(getActivity().findViewById(R.id.controller_container), R.string.not_net, Snackbar.LENGTH_LONG);
    }
    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        sPref = getActivity().getPreferences(MODE_PRIVATE);
    }

    private void updataDatalist(){
        SRL.setRefreshing(true);

        RotorAdapter adapter = new RotorAdapter();
        adapter.setListener(this);


        LiveData<PagedList<RotorInterface>> pagedListLiveData = new LivePagedListBuilder<>(new RotorDataSourceFactory(SBNN, SRL), config).build();

        pagedListLiveData.observe((AppCompatActivity) getActivity(), new Observer<PagedList<RotorInterface>>() {
            @Override
            public void onChanged(@Nullable PagedList<RotorInterface> playlistListInterfaces) {
                adapter.submitList(playlistListInterfaces);
            }
        });

        RRV.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        updataDatalist();
    }
    @Override
    public void onItemClick(RotorInterface model, int position) {

    }
    @Override
    public void onSettingsItemClick(RotorInterface model, int position) {

    }
}
