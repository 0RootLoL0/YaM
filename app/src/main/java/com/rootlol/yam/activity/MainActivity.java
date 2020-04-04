package com.rootlol.yam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.controller.HomeController;
import com.rootlol.yam.activity.controller.SearchController;

public class MainActivity extends AppCompatActivity {

    private ViewGroup container;
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getInstance().setAppCompatActivity(this);
        container = findViewById(R.id.controller_container);

        router = Conductor.attachRouter(this, container, savedInstanceState);
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(new HomeController()));
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
}
