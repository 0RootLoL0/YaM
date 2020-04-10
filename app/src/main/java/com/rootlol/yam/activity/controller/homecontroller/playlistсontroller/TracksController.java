package com.rootlol.yam.activity.controller.homecontroller.playlistсontroller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.data.PlaylistDataSourse;
import com.rootlol.yam.adapter.track.data.TrackDataSourceFactory;
import com.rootlol.yam.adapter.track.data.TrackDataSourse;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.adapter.track.TrackAdapter;
import com.rootlol.yam.adapter.track.TrackListInterface;

import static android.content.Context.MODE_PRIVATE;

public class TracksController extends Controller implements TrackAdapter.onClickListener{

    private RecyclerView TRV;

    private UsersDB.UserDao userDao;
    SharedPreferences sPref;
    PagedList.Config config;
    private TrackAdapter adapter;
    Bundle arguments;

    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);

        //bind view
        bind(view);
        setDB();
        config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(sPref.getInt("LIMIT", App.defultItemView))
                .build();

        arguments = getActivity().getIntent().getExtras();

        updataDatalist(arguments);

        return view;
    }
    private void bind(View view){
        TRV = view.findViewById(R.id.list);
        TRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TRV.setHasFixedSize(true);
    }
    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        sPref = getActivity().getPreferences(MODE_PRIVATE);
    }

    private void updataDatalist(Bundle arguments){
        //SRL.setRefreshing(true);
        adapter = new TrackAdapter();
        adapter.setListener(this);

        TrackDataSourse.getNewInstance();
        PlaylistDataSourse.getNewInstance();

        TrackDataSourceFactory trackDataSourceFactory;
        Log.i("TAG", "updataDatalist: "+arguments.getInt("type"));
             if (arguments.getInt("type") == PlaylistListInterface.FEED)
            trackDataSourceFactory = new TrackDataSourceFactory(arguments.getString("playlist"));
        else if (arguments.getInt("type") == PlaylistListInterface.USER_PLAYLIST)
            trackDataSourceFactory = new TrackDataSourceFactory(arguments.getInt("kind"));
        else //                                                         USER_LIKE
            trackDataSourceFactory = new TrackDataSourceFactory();
        LiveData<PagedList<TrackListInterface>> pagedListLiveData = new LivePagedListBuilder<>(trackDataSourceFactory, config).build();
        pagedListLiveData.observe((AppCompatActivity) getActivity(), new Observer<PagedList<TrackListInterface>>() {
            @Override
            public void onChanged(@Nullable PagedList<TrackListInterface> trackListInterface) {
                adapter.submitList(trackListInterface);
            }
        });

        TRV.setAdapter(adapter);
    }


    //IMPLEMENTS
    @Override
    public void onClickTrack(TrackListInterface model, int position) {
    }
    @Override
    public void onSettingsClickTrack(TrackListInterface model, int position) {
    }
    @Override
    public void onSmartButtonClickTrack(TrackListInterface model, int position) {
    }
    @Override
    public boolean handleBack() {
        getRouter().setRoot(RouterTransaction.with(new PlaylistController()));
        return true;
    }
}