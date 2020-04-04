package com.rootlol.yam.activity.controller.homecontroller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.LoginActivity;
import com.rootlol.yam.db.PlaylistCacheDB;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.db.UsersDB;

public class SettingsController extends Controller {

    private Button logout_button;
    private TextView login;

    //db
    private UsersDB.UserDao userDao;
    private PlaylistCacheDB.PlaylistCacheDao playlistCacheDao;
    private TrackListCacheDB.TrackCacheDao trackCacheDao;



    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_settings, container, false);
        setDB();
        onViewBound(view);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao.delete(userDao.getById(0));
                playlistCacheDao.deleteAll();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        login.setText(userDao.getById(0).login);
        return view;
    }

    private void onViewBound(@NonNull View view) {
        logout_button = view.findViewById(R.id.logout_button);
        login = view.findViewById(R.id.login);
    }

    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        playlistCacheDao = App.getInstance().getDatabase().playlistCacheDao();
        trackCacheDao = App.getInstance().getDatabase().trackCacheDao();
    }
}
