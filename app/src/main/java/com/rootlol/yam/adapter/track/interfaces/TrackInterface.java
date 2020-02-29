package com.rootlol.yam.adapter.track.interfaces;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.TrackAdapter;


public interface TrackInterface {
    int TRACK_TYPE = 1;
    int TOOLBAR_TYPE = 2;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          TrackInterface playlist_list,
                          TrackAdapter.onClickListener ItemListener,
                          Context context);
}
