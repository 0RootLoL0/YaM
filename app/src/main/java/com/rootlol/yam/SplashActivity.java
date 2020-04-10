/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.activity.LoginActivity;
import com.rootlol.yam.activity.MainActivity;
import com.rootlol.yam.db.UsersDB;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
try {
    UsersDB.UserDao userDao = App.getInstance().getDatabase().userDao();
    if (userDao.getAll().size() == 0) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    } else {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    finish();
}catch (Exception e){
    ExceptionActivity.viewError("Error in SplashActivity.onCreate:\n\n"+e.toString()+"\n\n please delete cash of this app");
    finish();
}
    }
}
