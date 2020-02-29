package com.rootlol.yam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.rootlol.yam.activity.LoginActivity;
import com.rootlol.yam.activity.MainActivity;
import com.rootlol.yam.db.UsersDB;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UsersDB.UserDao userDao = App.getInstance().getDatabase().userDao();

        if (userDao.getAll().size() == 0) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }else{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        finish();
    }
}
