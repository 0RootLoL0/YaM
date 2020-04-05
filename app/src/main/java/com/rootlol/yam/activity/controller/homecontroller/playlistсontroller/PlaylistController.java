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
import com.rootlol.yam.pojo.feed.FeedPojo;
import com.rootlol.yam.pojo.playlistslist.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class PlaylistController extends Controller implements SwipeRefreshLayout.OnRefreshListener, PlaylistAdapter.onClickListener {

    private SwipeRefreshLayout SRL;
    private RecyclerView PRV;

    private UsersDB.UserDao userDao;
    private SharedPreferences sPref;
    private String TAG = "PlaylistController";
    private PagedList.Config config;
    private PlaylistAdapter adapter;


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_playlist, container, false);

        //bind view
        bind(view);
        setDB();
        config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(sPref.getInt("LIMIT", 10))
                .build();

        if (App.getInstance().getPlaylistAdapter() == null) updataDatalist();
        else {
            PRV.setAdapter(App.getInstance().getPlaylistAdapter());
            SRL.setRefreshing(false);
        }

        return view;
    }
    private void bind(View view){
        SRL = view.findViewById(R.id.refresh);
        SRL.setOnRefreshListener(this);
        PRV = view.findViewById(R.id.list);
        PRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PRV.setHasFixedSize(true);
    }
    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        sPref = getActivity().getPreferences(MODE_PRIVATE);
    }

    private void updataDatalist(){
        SRL.setRefreshing(true);

        adapter = new PlaylistAdapter();
        adapter.setListener(this);
        MusicYandexApi.getInstance().feed("OAuth "+userDao.getAll().get(0).token).enqueue(new Callback<FeedPojo>() {
            @Override
            public void onResponse(Call<FeedPojo> call, Response<FeedPojo> response) {

                LiveData<PagedList<PlaylistListInterface>> pagedListLiveData = new LivePagedListBuilder<>(new PlaylistDataSourceFactory(response.body().getResult().getGeneratedPlaylists()), config).build();
                //лол грязный хак         ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇    TODO: исправить
                pagedListLiveData.observe(App.getInstance().getAppCompatActivity(), new Observer<PagedList<PlaylistListInterface>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<PlaylistListInterface> playlistListInterfaces) {

                        adapter.submitList(playlistListInterfaces);
                    }
                });
                PRV.setAdapter(adapter);
                SRL.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<FeedPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.not_net, Toast.LENGTH_LONG).show();
                SRL.setRefreshing(false);
            }
        });
    }

    //IMPLEMENTS
    @Override
    public void onRefresh() {
        updataDatalist();
    }
    @Override
    public void onItemClick(PlaylistListInterface model, int position) {
        if (model.getTypeP() == PlaylistListInterface.USER_PLAYLIST)
            App.getInstance().setKind( ((Result) model).getKind().intValue() );
        getRouter().setRoot(RouterTransaction.with(new TracksController()));
    }
    @Override
    public void onSettingsItemClick(PlaylistListInterface model, int position) {

    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        App.getInstance().setPlaylistAdapter(adapter);
    }
}