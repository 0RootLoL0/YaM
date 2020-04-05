package com.rootlol.yam.adapter.track;

import androidx.recyclerview.widget.RecyclerView;

public interface TrackListInterface {
    int TRACK_TYPE = 0;
    int TOOLBAR_TYPE = 1;

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          TrackListInterface playlist_list,
                          TrackAdapter.onClickListener ItemListener);
    int getPosit();
}