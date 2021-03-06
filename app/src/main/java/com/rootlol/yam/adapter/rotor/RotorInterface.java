/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.rotor;

import androidx.recyclerview.widget.RecyclerView;

public interface RotorInterface {

    int STATIONS = 0;

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          RotorInterface rotorInterface,
                          RotorAdapter.onClickListener ItemListener);

    int            getPosition();
    RotorInterface setPosition(int position);

    int getType();
}
