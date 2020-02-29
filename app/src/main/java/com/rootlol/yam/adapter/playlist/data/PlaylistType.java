package com.rootlol.yam.adapter.playlist.data;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.factory.PlaylistVHFactory;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;
import com.rootlol.yam.tools.ImageTool;

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
    public int getId() {
        return id;
    }

    @Override
    public int getItemViewType() {
        return PlaylistListInterface.PLAYLIST_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 final int position,
                                 final PlaylistListInterface playlist_list,
                                 final PlaylistAdapter.onClickListener ItemListener,
                                 Context context) {
        PlaylistVHFactory.PlaylistViewHolder playlistViewHolder = (PlaylistVHFactory.PlaylistViewHolder) viewHolder;
        playlistViewHolder.lable.setText(lable);
        playlistViewHolder.colTime.setText(colTime);
        playlistViewHolder.coverImage.setImageBitmap(ImageTool.convert(coverIm, context.getResources()));

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

