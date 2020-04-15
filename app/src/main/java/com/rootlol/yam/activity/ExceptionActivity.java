/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rootlol.yam.App;
import com.rootlol.yam.R;
/***********************************************************************
<<<<<<< HEAD

 $$$$$$$$\                                                         $$\
 $$  _____|                                                        \__|
 $$ |       $$$$$$\   $$$$$$\   $$$$$$\   $$$$$$\        $$\   $$\ $$\
 $$$$$\    $$  __$$\ $$  __$$\ $$  __$$\ $$  __$$\       $$ |  $$ |$$ |
 $$  __|   $$ |  \__|$$ |  \__|$$ /  $$ |$$ |  \__|      $$ |  $$ |$$ |
 $$ |      $$ |      $$ |      $$ |  $$ |$$ |            $$ |  $$ |$$ |
 $$$$$$$$\ $$ |      $$ |      \$$$$$$  |$$ |            \$$$$$$  |$$ |
 \________|\__|      \__|       \______/ \__|             \______/ \__|


=======

 $$$$$$$$\                                                         $$\
 $$  _____|                                                        \__|
 $$ |       $$$$$$\   $$$$$$\   $$$$$$\   $$$$$$\        $$\   $$\ $$\
 $$$$$\    $$  __$$\ $$  __$$\ $$  __$$\ $$  __$$\       $$ |  $$ |$$ |
 $$  __|   $$ |  \__|$$ |  \__|$$ /  $$ |$$ |  \__|      $$ |  $$ |$$ |
 $$ |      $$ |      $$ |      $$ |  $$ |$$ |            $$ |  $$ |$$ |
 $$$$$$$$\ $$ |      $$ |      \$$$$$$  |$$ |            \$$$$$$  |$$ |
 \________|\__|      \__|       \______/ \__|             \______/ \__|


>>>>>>> origin/addRetrofit
 Эта активити для отображения ошибок в приложении

 **********************************************************************/
public class ExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        String errorInfo = getIntent().getExtras().get("errorInfo").toString();
        TextView textViewError = findViewById(R.id.textViewError);
        textViewError.setText(errorInfo);
    }

    public static void viewError(String error){
        Intent intent= new Intent(App.getInstance(), ExceptionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("errorInfo", error);
        App.getInstance().startActivity(intent);
    }
}
