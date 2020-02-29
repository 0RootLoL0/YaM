package com.rootlol.yam.activity.controller.homecontroller.playlistсontroller;

import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.adapter.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.data.PlaylistType;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;
import com.rootlol.yam.api.settingsPlaylist;
import com.rootlol.yam.api.updataCachePlaylist;
import com.rootlol.yam.db.ApplicationDB;
import com.rootlol.yam.db.PlaylistCacheDB;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.db.UsersDB;
import com.rootlol.yam.tools.DialogScreenTool;
import com.rootlol.yam.tools.RecyclerViewTool;

import java.util.ArrayList;
import java.util.List;

public class PlaylistController extends Controller implements SwipeRefreshLayout.OnRefreshListener, PlaylistAdapter.onClickListener {

    private SwipeRefreshLayout SRL;
    private RecyclerView PRV;
    private GridLayoutManager recyclerViewLayoutManager;

    private PlaylistAdapter Padapter;

    //db
    private ApplicationDB.ApplicationDao applicationDao;
    private UsersDB.UserDao userDao;
    private PlaylistCacheDB.PlaylistCacheDao playlistCacheDao;
    private TrackListCacheDB.TrackCacheDao trackCacheDao;

    //temp
    private int LIMIT;
    private boolean isPublic ;


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_playlist, container, false);

        //bind view
        bind(view);
        setDB();
        LIMIT = applicationDao.getItem().LimitItem;

        setPlaylistAdapter();

        return view;
    }

    private void bind(View view){
        SRL = view.findViewById(R.id.refresh);
        SRL.setOnRefreshListener(this);
        PRV = view.findViewById(R.id.list);
    }
    private void setDB(){
        applicationDao = App.getInstance().getDatabase().applicationDao();
        userDao = App.getInstance().getDatabase().userDao();
        playlistCacheDao = App.getInstance().getDatabase().playlistCacheDao();
        trackCacheDao = App.getInstance().getDatabase().trackCacheDao();
    }

    private void setPlaylistAdapter(){
        recyclerViewLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerViewLayoutManager.supportsPredictiveItemAnimations();
        PRV.setLayoutManager(recyclerViewLayoutManager);
        PRV.setSaveEnabled(true);

        Padapter = new PlaylistAdapter(getApplicationContext(), 5);
        Padapter.setListener(this);
        PRV.setAdapter(Padapter);

        PRV.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i("qwe", RecyclerViewTool.getLastVisibleItemPosition(recyclerView)+" "+(Padapter.getItemCount()-1));
                if (RecyclerViewTool.getLastVisibleItemPosition(recyclerView) == Padapter.getItemCount()-1)
                    addItem();
            }
        });
        addItem();
    }
    private void updataCachePlaylist() {
        new updataCachePlaylist(){
            @Override
            protected void onPostExecute(List<PlaylistCacheDB.PlaylistCacheEntity> s) {
                super.onPostExecute(s);
                if (s.size() != 0) {
                    playlistCacheDao.deleteAll();
                    for (PlaylistCacheDB.PlaylistCacheEntity w : s) {
                        playlistCacheDao.insert(w);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.error_get_data, Toast.LENGTH_LONG).show();
                }
                Padapter.delItem();
                recyclerViewLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                recyclerViewLayoutManager.supportsPredictiveItemAnimations();
                PRV.setLayoutManager(recyclerViewLayoutManager);
                addItem();
                SRL.setRefreshing(false);
                PRV.setVisibility(View.VISIBLE);
            }
        }.execute(userDao.getById(0));
        SRL.setRefreshing(true);
        PRV.setVisibility(View.INVISIBLE);
    }
    public void addItem() {
        List<PlaylistListInterface> PlaylistList = new ArrayList<>();
        if (playlistCacheDao.getAll().size() == 0 ) {
            updataCachePlaylist();
            return;
        }
        for (PlaylistCacheDB.PlaylistCacheEntity playlistCacheEntity : playlistCacheDao.getItemLimit(playlistCacheDao.getAll().size() - Padapter.getItemCount(), LIMIT)) {
            PlaylistList.add(new PlaylistType(playlistCacheEntity.lable, playlistCacheEntity.colTime, playlistCacheEntity.coverImage, playlistCacheEntity.id));
        }
        Padapter.addNewItems(PlaylistList);
        Padapter.notifyItemInserted(Padapter.getItemCount() - PlaylistList.size()+1);
    }


    //IMPLEMENTS
    @Override
    public void onRefresh() {
        updataCachePlaylist();
    }
    @Override
    public void onItemClick(PlaylistListInterface model, int position) {
        final List<PlaylistCacheDB.PlaylistCacheEntity> cache = playlistCacheDao.getAll();
        ApplicationDB.ApplicationEntity q = applicationDao.getItem();
        q.kindPlailist = cache.get(position).kind;
        applicationDao.update(q);
        getRouter().setRoot(RouterTransaction.with(new TrackListController()));
    }
    @Override
    public void onSettingsItemClick(PlaylistListInterface model, final int position) {
        final AlertDialog dialog = DialogScreenTool.getDialog(getActivity(), DialogScreenTool.IDD_SETTINGS);
        dialog.show();

        //bind
        final EditText lablePlaylist = dialog.findViewById(R.id.lablePlaylist);
        final Switch switchVisibility = dialog.findViewById(R.id.switchVisibility);

        //settings
        final List<PlaylistCacheDB.PlaylistCacheEntity> cache = playlistCacheDao.getAll();
        // TODO: незабыть исправить на -1
        if (cache.get(position).typeP == PlaylistCacheDB.YANDEX_GEN)
            lablePlaylist.setText(cache.get(position).lable);
        else lablePlaylist.setText(cache.get(position).lable);
        if (cache.get(position).typeP == PlaylistCacheDB.YANDEX_GEN)
            isPublic = (cache.get(position).visibility.equals("public")) ? true : false;
        else isPublic = (cache.get(position).visibility.equals("public")) ? true : false;

        switchVisibility.setChecked(isPublic);

        //SWITCH
        switchVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isPublic = isChecked;
            }
        });

        // поделиться
        ((ConstraintLayout) dialog.findViewById(R.id.shareButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0 && cache.get(position).typeP == PlaylistCacheDB.USER_CREATE) {
                    final Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String textToSend = "https://music.yandex.ru/users/" + userDao.getById(0).login + "/playlists/" + cache.get(position).kind;
                    intent.putExtra(Intent.EXTRA_TEXT, textToSend);
                    try {
                        startActivity(Intent.createChooser(intent, getResources().getString(R.string.intend_share)));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(getApplicationContext(), "Some error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // удалить
        ((ConstraintLayout) dialog.findViewById(R.id.deletButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0 && cache.get(position).typeP == PlaylistCacheDB.USER_CREATE) {
                    new settingsPlaylist() {
                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                            updataCachePlaylist();
                        }
                    }.execute("delete", userDao.getById(0).token, "" + userDao.getById(0).user_id, "" + cache.get(position).kind);
                    dialog.dismiss();
                }
            }
        });

        // ok
        (dialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0 && cache.get(position).typeP == PlaylistCacheDB.USER_CREATE && !lablePlaylist.getText().toString().equals(cache.get(position).lable)) {
                    new settingsPlaylist() {
                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                        }
                    }.execute("rename",
                            userDao.getById(0).token,
                            "" + userDao.getById(0).user_id,
                            "" + cache.get(position).kind,
                            lablePlaylist.getText().toString());
                }
                if ((cache.get(position).visibility.equals("public")) ? true : false != isPublic){
                    new settingsPlaylist() {
                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }.execute("visibility", userDao.getById(0).token, "" + userDao.getById(0).user_id, "" + cache.get(position).kind, (isPublic) ? "public" : "private");
                }
                updataCachePlaylist();
                dialog.dismiss();
            }

        });
    }
}