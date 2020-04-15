/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.rotor.item;

import android.graphics.Color;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rootlol.yam.App;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.rotor.RotorAdapter;
import com.rootlol.yam.adapter.rotor.RotorInterface;
import com.rootlol.yam.adapter.rotor.RotorVHFactory;

import io.github.rootlol.yamapilib.pojo.rotor.Mood;
import io.github.rootlol.yamapilib.pojo.rotor.PossibleValue;
import io.github.rootlol.yamapilib.pojo.rotor.PossibleValue_;
import io.github.rootlol.yamapilib.pojo.rotor.Station;

public class StationType implements RotorInterface {

    private Station info;
    private int position;

    public StationType(Station info) {
        this.info = info;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, RotorInterface rotorInterface, RotorAdapter.onClickListener ItemListener) {
        try {
            RotorVHFactory.StationsViewHolder stationsViewHolder = (RotorVHFactory.StationsViewHolder) viewHolder;

            Glide.with(App.getInstance()).load("https://" +info.getStation().getIcon().getImageUrl().replace("%%", "100x100")).into(stationsViewHolder.StationImage);

            stationsViewHolder.rotorTitle.setText(info.getStation().getName());

            for (PossibleValue nn :info.getStation().getRestrictions().getLanguage().getPossibleValues())
                if (nn.getValue().equals(info.getSettings().getLanguage())) stationsViewHolder.rotorLang.setText(nn.getName());


            stationsViewHolder.rotorMood.setText(info.getSettings().getMood()+"/4");
            stationsViewHolder.rotorEnergy.setText(info.getSettings().getEnergy()+"/4");

            for(PossibleValue_ qq:info.getStation().getRestrictions().getDiversity().getPossibleValues())
                if (qq.getValue().equals(info.getSettings().getDiversity()))stationsViewHolder.rotorDiversity.setText(qq.getName());

            stationsViewHolder.BGStationImage.setBackgroundColor(Color.parseColor(info.getStation().getIcon().getBackgroundColor()));



            if (ItemListener != null) {
                stationsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onItemClick(rotorInterface, position);
                    }
                });
            }
        } catch (Exception e){
            ExceptionActivity.viewError("Error in StationType.onBindViewHolder:\n\n"+e.toString());
        }
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public RotorInterface setPosition(int position) {
        this.position = position;
        return this;
    }

    @Override
    public int getType() {
        return RotorInterface.STATIONS;
    }
}
