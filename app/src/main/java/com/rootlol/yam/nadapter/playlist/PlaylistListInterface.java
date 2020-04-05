package com.rootlol.yam.nadapter.playlist;

import androidx.recyclerview.widget.RecyclerView;

public interface PlaylistListInterface {
    int FEED = 0;
    int USER_PLAYLIST =1;

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                          int position,
                          PlaylistListInterface playlist_list,
                          PlaylistAdapter.onClickListener ItemListener);
    int getPosit();
    int getTypeP();
}
