package com.rootlol.yam.nadapter.playlist;

import androidx.recyclerview.widget.RecyclerView;

public interface PlaylistListInterface {
    int PLAYLIST_TYPE = 0;
    int TITLE_TYPE = 1;

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          PlaylistListInterface playlist_list,
                          PlaylistAdapter.onClickListener ItemListener);
    int getPosit();
}
