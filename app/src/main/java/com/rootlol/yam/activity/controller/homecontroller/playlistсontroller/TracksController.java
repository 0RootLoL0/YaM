package com.rootlol.yam.activity.controller.homecontroller.playlistсontroller;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.api.MusicYandexApi;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.nadapter.playlist.PlaylistAdapter;
import com.rootlol.yam.nadapter.playlist.PlaylistListInterface;
import com.rootlol.yam.nadapter.playlist.data.PlaylistDataSourceFactory;
import com.rootlol.yam.nadapter.track.TrackAdapter;
import com.rootlol.yam.nadapter.track.TrackListInterface;
import com.rootlol.yam.nadapter.track.data.TrackDataSourceFactory;
import com.rootlol.yam.pojo.feed.FeedPojo;
import com.rootlol.yam.pojo.usersplaylists.UsersPlaylistsPojo;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class TracksController extends Controller implements TrackAdapter.onClickListener{

    private RecyclerView TRV;

    private UsersDB.UserDao userDao;
    SharedPreferences sPref;
    PagedList.Config config;
    private TrackAdapter adapter;


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.activity_track, container, false);

        //bind view
        bind(view);
        setDB();
        config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(sPref.getInt("LIMIT", 10))
                .build();

        updataDatalist();

        return view;
    }
    private void bind(View view){
        TRV = view.findViewById(R.id.tlist);
        TRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        TRV.setHasFixedSize(true);
    }
    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        sPref = getActivity().getPreferences(MODE_PRIVATE);
    }

    private void updataDatalist(){
        //SRL.setRefreshing(true);

        adapter = new TrackAdapter();
        adapter.setListener(this);

        Map<String, String> TrackPostBody = new HashMap<>();
        TrackPostBody.put("kinds", "1022");

        MusicYandexApi.getInstance().getTrackList(
                userDao.getAll().get(0).user_id,
                "OAuth "+userDao.getAll().get(0).token,
                TrackPostBody).enqueue(new Callback<UsersPlaylistsPojo>() {
            @Override
            public void onResponse(Call<UsersPlaylistsPojo> call, Response<UsersPlaylistsPojo> response) {

                LiveData<PagedList<TrackListInterface>> pagedListLiveData = new LivePagedListBuilder<>(new TrackDataSourceFactory(response.body().getResult().get(0).getTracks()), config).build();
                //лол грязный хак         ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇    TODO: исправить
                pagedListLiveData.observe(App.getInstance().getAppCompatActivity(), new Observer<PagedList<TrackListInterface>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<TrackListInterface> trackListInterface) {

                        adapter.submitList(trackListInterface);
                    }
                });


                TRV.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UsersPlaylistsPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.not_net, Toast.LENGTH_LONG).show();
            }
        });
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