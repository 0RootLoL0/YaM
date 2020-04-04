package com.rootlol.yam.nadapter.playlist.item;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rootlol.yam.App;
import com.rootlol.yam.nadapter.playlist.PlaylistAdapter;
import com.rootlol.yam.nadapter.playlist.PlaylistVHFactory;
import com.rootlol.yam.nadapter.playlist.PlaylistListInterface;

public class PlaylistType implements PlaylistListInterface {

    public int id;
    public String lable;
    public String colTime;
    public String coverIm;


    public PlaylistType(String lable, String colTime, String coverIm, int id) {
        this.lable = lable;
        this.colTime = colTime;
        this.coverIm = coverIm;
        this.id = id;
    }

    @Override
    public int getPosit() {
        return id;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position,
                                 PlaylistListInterface playlist_list,
                                 PlaylistAdapter.onClickListener ItemListener) {
        PlaylistVHFactory.PlaylistViewHolder playlistViewHolder = (PlaylistVHFactory.PlaylistViewHolder) viewHolder;
        playlistViewHolder.lable.setText(lable);
        playlistViewHolder.colTime.setText(colTime);
        Glide.with(App.getInstance())
                .load(coverIm)
                .into(playlistViewHolder.coverImage);

        if(ItemListener != null){
            playlistViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onItemClick(playlist_list, position);
                }
            });
            playlistViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onSettingsItemClick(playlist_list, position);
                }
            });
        }
    }
}

