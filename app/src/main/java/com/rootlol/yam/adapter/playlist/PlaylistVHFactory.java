/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.playlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;

public class PlaylistVHFactory {

    public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

        public ImageView coverImage;
        public TextView lable;
        public TextView colTime;
        public ImageButton buttonSettings;
        public CardView cardView;

        public PlaylistViewHolder(View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.StationImage);
            lable = itemView.findViewById(R.id.lable);
            colTime = itemView.findViewById(R.id.colTime);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            cardView = itemView.findViewById(R.id.cv);
        }
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {

        public ImageView coverImage;
        public TextView lable;
        public TextView colTime;
        public ImageButton buttonSettings;
        public CardView cardView;

        public FeedViewHolder(View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.StationImage);
            lable = itemView.findViewById(R.id.lable);
            colTime = itemView.findViewById(R.id.colTime);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            cardView = itemView.findViewById(R.id.cv);
        }
    }

    public static class LikeTrackViewHolder extends RecyclerView.ViewHolder {

        public ImageView coverImage;
        public TextView lable;
        public TextView colTime;
        public ImageButton buttonSettings;
        public CardView cardView;

        public LikeTrackViewHolder(View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.StationImage);
            lable = itemView.findViewById(R.id.lable);
            colTime = itemView.findViewById(R.id.colTime);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            cardView = itemView.findViewById(R.id.cv);
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {

        switch (viewType){
            case PlaylistListInterface.FEED:
                View FinflateTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
                return new PlaylistVHFactory.FeedViewHolder(FinflateTypeView);

            case PlaylistListInterface.USER_PLAYLIST:
                View PinflateTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
                return new PlaylistVHFactory.PlaylistViewHolder(PinflateTypeView);

            case PlaylistListInterface.USER_LIKE:
                View LinflateTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
                return new PlaylistVHFactory.LikeTrackViewHolder(LinflateTypeView);

            default:
                ExceptionActivity.viewError("Error in PlaylistVHFactory.create.switch viewType="+viewType);
                return null;
        }
    }
}
