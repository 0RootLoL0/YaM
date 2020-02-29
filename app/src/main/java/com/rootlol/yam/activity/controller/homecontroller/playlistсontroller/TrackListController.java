package com.rootlol.yam.activity.controller.homecontroller.playlistсontroller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.adapter.TrackAdapter;
import com.rootlol.yam.adapter.playlist.data.PlaylistType;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;
import com.rootlol.yam.adapter.track.data.TrackType;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;
import com.rootlol.yam.api.updataCacheTrack;
import com.rootlol.yam.db.ApplicationDB;
import com.rootlol.yam.db.PlaylistCacheDB;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.tools.RecyclerViewTool;

import java.util.ArrayList;
import java.util.List;

public class TrackListController extends Controller implements SwipeRefreshLayout.OnRefreshListener, TrackAdapter.onClickListener{

    private SwipeRefreshLayout SRL;
    private RecyclerView TRV;
    private GridLayoutManager recyclerViewLayoutManager;

    private TrackAdapter Tadapter;

    //db
    private ApplicationDB.ApplicationDao applicationDao;
    private UsersDB.UserDao userDao;
    private PlaylistCacheDB.PlaylistCacheDao playlistCacheDao;
    private TrackListCacheDB.TrackCacheDao trackCacheDao;

    //temp
    private int LIMIT;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_playlist, container, false);
        //bind view
        bind(view);

        setDB();
        LIMIT = applicationDao.getItem().LimitItem;

        setTrackAdapter();
        return view;
    }

    private void bind(View view){
        SRL = view.findViewById(R.id.refresh);
        SRL.setOnRefreshListener(this);
        TRV = view.findViewById(R.id.list);
    }
    private void setDB(){
        applicationDao = App.getInstance().getDatabase().applicationDao();
        userDao = App.getInstance().getDatabase().userDao();
        playlistCacheDao = App.getInstance().getDatabase().playlistCacheDao();
        trackCacheDao = App.getInstance().getDatabase().trackCacheDao();
    }
    private void setTrackAdapter(){
        recyclerViewLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerViewLayoutManager.supportsPredictiveItemAnimations();
        TRV.setLayoutManager(recyclerViewLayoutManager);
        TRV.setSaveEnabled(true);

        Tadapter = new TrackAdapter(getApplicationContext());
        Tadapter.setListener(this);
        TRV.setAdapter(Tadapter);
        TRV.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (RecyclerViewTool.getLastVisibleItemPosition(recyclerView) == Tadapter.getItemCount()-1) addItem();
            }
        });
        addItem();
    }
    public void addItem() {
        List<TrackInterface> TrackList = new ArrayList<>();

        if (trackCacheDao.getAlltag(applicationDao.getItem().kindPlailist).size() == 0 ) {
            updataCacheTrack();
            return;
        }
        for (TrackListCacheDB.TrackListCacheEntity trackListCacheEntity : trackCacheDao.getItemLimit(applicationDao.getItem().kindPlailist, trackCacheDao.getAlltag(applicationDao.getItem().kindPlailist).size() - Tadapter.getItemCount(), LIMIT)) {
            TrackList.add(new TrackType(trackListCacheEntity.titleTrack, trackListCacheEntity.versionTrack, trackListCacheEntity.artists_name, trackListCacheEntity.coverImage));
        }
        Tadapter.addNewItems(TrackList);
        Tadapter.notifyItemInserted(Tadapter.getItemCount() - TrackList.size());
    }
    private void updataCacheTrack() {
        new updataCacheTrack(){

            @Override
            protected void onPostExecute(List<TrackListCacheDB.TrackListCacheEntity> trackListCacheEntities) {
                super.onPostExecute(trackListCacheEntities);
                if (trackListCacheEntities.size() != 0) {
                    trackCacheDao.deleteAlltag(applicationDao.getItem().kindPlailist);
                    for (TrackListCacheDB.TrackListCacheEntity w : trackListCacheEntities) {
                        trackCacheDao.insert(w);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.error_get_data, Toast.LENGTH_LONG).show();
                }

                Tadapter.delItem();
                recyclerViewLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                recyclerViewLayoutManager.supportsPredictiveItemAnimations();
                TRV.setLayoutManager(recyclerViewLayoutManager);
                addItem();
                SRL.setRefreshing(false);
                TRV.setVisibility(View.VISIBLE);
            }
        }.execute(userDao.getById(0).token, userDao.getById(0).user_id+"", ""+applicationDao.getItem().kindPlailist);
        SRL.setRefreshing(true);
        TRV.setVisibility(View.INVISIBLE);
    }

    //IMPLEMENTS
    @Override
    public void onRefresh() {
        updataCacheTrack();
    }
    @Override
    public void onClickTrack(TrackInterface model, int position) {

    }
    @Override
    public void onSettingsClickTrack(TrackInterface model, int position) {

    }
    @Override
    public void onSmartButtonClickTrack(TrackInterface model, int position) {

    }
    @Override
    public boolean handleBack() {
        getRouter().setRoot(RouterTransaction.with(new PlaylistController()));
        return true;
    }
}
