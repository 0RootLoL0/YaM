package com.rootlol.yam.nadapter.playlist.item;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.nadapter.playlist.PlaylistAdapter;
import com.rootlol.yam.nadapter.playlist.PlaylistListInterface;
import com.rootlol.yam.nadapter.playlist.PlaylistVHFactory;


public class TitleType implements PlaylistListInterface {
    private int id;
    private int title;

    public TitleType(int title, int id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public int getPosit() {
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, PlaylistListInterface playlist_list, PlaylistAdapter.onClickListener ItemListener) {
        PlaylistVHFactory.TitleViewHolder titleViewHolder = (PlaylistVHFactory.TitleViewHolder) viewHolder;
        titleViewHolder.title.setText(title);
    }
}
