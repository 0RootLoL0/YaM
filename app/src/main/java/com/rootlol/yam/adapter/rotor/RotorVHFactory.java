/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.rotor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;

public class RotorVHFactory {
    public static class StationsViewHolder extends RecyclerView.ViewHolder {

        public ImageView StationImage;
        public TextView rotorTitle;

        public TextView rotorLang;
        public TextView rotorMood;
        public TextView rotorEnergy;
        public TextView rotorDiversity;

        public CardView cardView;
        public CardView BGStationImage;

        public StationsViewHolder(View itemView) {
            super(itemView);
            StationImage = itemView.findViewById(R.id.StationImage);
            rotorTitle = itemView.findViewById(R.id.rotorTitle);

            rotorLang = itemView.findViewById(R.id.rotorLang);
            rotorMood= itemView.findViewById(R.id.rotorMood);
            rotorEnergy = itemView.findViewById(R.id.rotorEnergy);
            rotorDiversity = itemView.findViewById(R.id.rotorDiversity);

            cardView = itemView.findViewById(R.id.cv);
            BGStationImage= itemView.findViewById(R.id.BGStationImage);
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {

        switch (viewType){
            case RotorInterface.STATIONS:
                View SinflateTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stations, parent, false);
                return new RotorVHFactory.StationsViewHolder(SinflateTypeView);

            default:
                ExceptionActivity.viewError("Error in PlaylistVHFactory.create.switch viewType="+viewType);
                return null;
        }
    }
}
