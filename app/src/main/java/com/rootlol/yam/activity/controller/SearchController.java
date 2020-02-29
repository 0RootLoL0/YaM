package com.rootlol.yam.activity.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.rootlol.yam.R;

public class SearchController extends Controller {

    public SearchController() {
    }

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_search, container, false);
        return view;
    }
}
