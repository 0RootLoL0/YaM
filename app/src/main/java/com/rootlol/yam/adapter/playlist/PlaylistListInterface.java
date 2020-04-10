/*
 * Copyright © 2020 Popov Vasily.
 * Licensed under the Apache License, Version 2.0
 */

package com.rootlol.yam.adapter.playlist;

import androidx.recyclerview.widget.RecyclerView;

public interface PlaylistListInterface {
    int FEED          = 0;
    int USER_PLAYLIST = 1;
    int USER_LIKE     = 2;

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          PlaylistListInterface playlist_list,
                          PlaylistAdapter.onClickListener ItemListener);


    int                   getPosition();
    PlaylistListInterface setPosition(int position);

    int getType();
}
