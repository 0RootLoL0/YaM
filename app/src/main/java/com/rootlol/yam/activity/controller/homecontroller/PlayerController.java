package com.rootlol.yam.activity.controller.homecontroller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.rootlol.yam.R;

public class PlayerController extends Controller {

    public PlayerController() {
    }


    @NonNull
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home_player, container, false);
        onViewBound(view);
        return view;
    }

    private void onViewBound(@NonNull View view) {

    }
}
