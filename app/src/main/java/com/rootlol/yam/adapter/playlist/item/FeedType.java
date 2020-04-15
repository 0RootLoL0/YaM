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
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.PlaylistVHFactory;

import io.github.rootlol.yamapilib.pojo.feed.GeneratedPlaylist;

public class FeedType implements PlaylistListInterface {

    private int position;
    private GeneratedPlaylist info;
    public FeedType(GeneratedPlaylist info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, PlaylistListInterface playlist_list, PlaylistAdapter.onClickListener ItemListener) {
        try {
            PlaylistVHFactory.FeedViewHolder feedViewHolder = (PlaylistVHFactory.FeedViewHolder) viewHolder;

            Glide.with(App.getInstance()).load("https://" +info.getData().getOgImage().replace("%%", "200x200")).into(feedViewHolder.coverImage);
            feedViewHolder.lable.setText(info.getData().getTitle());
            feedViewHolder.colTime.setText(info.getData().getCreated());

            if (ItemListener != null) {
                feedViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onItemClick(playlist_list, position);
                    }
                });
                feedViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
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

    public String getInfoType(){
        return info.getType();
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
        return PlaylistListInterface.FEED;
    }
}
