package com.rootlol.yam.adapter.playlist.data;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.factory.PlaylistVHFactory;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;

public class TitleType implements PlaylistListInterface {
    private int id;
    private int title;

    public TitleType(int title, int id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getItemViewType() {
        return PlaylistListInterface.TITLE_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position,
                                 PlaylistListInterface playlist_list,
                                 PlaylistAdapter.onClickListener ItemListener,
                                 Context context) {
        PlaylistVHFactory.TitleViewHolder titleViewHolder = (PlaylistVHFactory.TitleViewHolder) viewHolder;
        titleViewHolder.title.setText(title);
    }
}
