package com.rootlol.yam.adapter.playlist.interfaces;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.PlaylistAdapter;

public interface PlaylistListInterface {
    int PLAYLIST_TYPE = 0;
    int TITLE_TYPE = 1;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          PlaylistListInterface playlist_list,
                          PlaylistAdapter.onClickListener ItemListener,
                          Context context);
    int getId();
}
