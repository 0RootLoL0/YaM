/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.playlist.item;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rootlol.yam.App;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.playlist.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.PlaylistVHFactory;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;

import io.github.rootlol.yamapilib.pojo.ResultAPPL;

public class PlaylistType implements PlaylistListInterface {

    private int position;
    private ResultAPPL info;
    public PlaylistType(ResultAPPL info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position,
                                 PlaylistListInterface playlist_list,
                                 PlaylistAdapter.onClickListener ItemListener) {
        try {
            PlaylistVHFactory.PlaylistViewHolder playlistViewHolder = (PlaylistVHFactory.PlaylistViewHolder) viewHolder;

            Glide.with(App.getInstance()).load("https://"+info.getOgImage().replace("%%", "200x200")).into(playlistViewHolder.coverImage);
            playlistViewHolder.lable.setText(info.getTitle());
            playlistViewHolder.colTime.setText(info.getCreated());


            if(ItemListener != null){
                playlistViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onItemClick(playlist_list, position);
                    }
                });
                playlistViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onSettingsItemClick(playlist_list, position);
                    }
                });
            }
        } catch (Exception e){
            ExceptionActivity.viewError(e.toString());
        }
    }

    public int getKind() {
        return info.getKind();
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public PlaylistListInterface setPosition(int position) {
        this.position = position;
        return this;
    }

    @Override
    public int getType() {
        return PlaylistListInterface.USER_PLAYLIST;
    }
}

