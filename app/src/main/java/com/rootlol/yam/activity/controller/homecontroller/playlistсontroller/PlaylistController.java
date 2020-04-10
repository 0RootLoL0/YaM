/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.activity.controller.homecontroller.playlistсontroller;

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
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.android.material.snackbar.Snackbar;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.playlist.data.PlaylistDataSourse;
import com.rootlol.yam.adapter.playlist.item.FeedType;
import com.rootlol.yam.adapter.playlist.item.PlaylistType;
import com.rootlol.yam.adapter.track.data.TrackDataSourse;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.adapter.playlist.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.data.PlaylistDataSourceFactory;

import static android.content.Context.MODE_PRIVATE;

public class PlaylistController extends Controller implements SwipeRefreshLayout.OnRefreshListener, PlaylistAdapter.onClickListener {

    private SwipeRefreshLayout SRL;
    private RecyclerView PRV;
    private Snackbar SBNN;

    private UsersDB.UserDao userDao;
    private SharedPreferences sPref;
    private String TAG = "PlaylistController";
    private PagedList.Config config;
    private PlaylistAdapter adapter;


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);

        try {

            //bind view
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
        SRL = view.findViewById(R.id.refresh);
        SRL.setOnRefreshListener(this);
        PRV = view.findViewById(R.id.list);
        PRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PRV.setHasFixedSize(true);
        SBNN = Snackbar.make(getActivity().findViewById(R.id.controller_container), R.string.not_net, Snackbar.LENGTH_LONG);
    }
    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        sPref = getActivity().getPreferences(MODE_PRIVATE);
    }

    private void updataDatalist(){
        SRL.setRefreshing(true);

        adapter = new PlaylistAdapter();
        adapter.setListener(this);

        TrackDataSourse.getNewInstance();
        PlaylistDataSourse.getNewInstance();

        LiveData<PagedList<PlaylistListInterface>> pagedListLiveData = new LivePagedListBuilder<>(new PlaylistDataSourceFactory(userDao.getAll().get(0).user_id, userDao.getAll().get(0).token, SBNN, SRL), config).build();
        pagedListLiveData.observe((AppCompatActivity) getActivity(), new Observer<PagedList<PlaylistListInterface>>() {
            @Override
            public void onChanged(@Nullable PagedList<PlaylistListInterface> playlistListInterfaces) {
                adapter.submitList(playlistListInterfaces);
            }
        });
        PRV.setAdapter(adapter);
    }

    //IMPLEMENTS
    @Override
    public void onRefresh() {
        updataDatalist();
    }
    @Override
    public void onItemClick(PlaylistListInterface model, int position) {
        getActivity().getIntent().putExtra("type", model.getType());

        if (model.getType() == PlaylistListInterface.USER_PLAYLIST) {
            getActivity().getIntent().putExtra("kind", ((PlaylistType) model).getKind());
        }else if (model.getType() == PlaylistListInterface.FEED){
            getActivity().getIntent().putExtra("playlist", ((FeedType)model).getInfoType());
        }

        getRouter().setRoot(RouterTransaction.with(new TracksController()));
    }
    @Override
    public void onSettingsItemClick(PlaylistListInterface model, int position) {

    }
}