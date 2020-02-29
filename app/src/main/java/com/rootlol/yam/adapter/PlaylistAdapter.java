package com.rootlol.yam.adapter;


import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.playlist.factory.PlaylistVHFactory;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter {

    private List<PlaylistListInterface> playlist_list = new ArrayList<>();
    private Context context;
    private int LIMIT;

    public void delItem() {
        playlist_list = new ArrayList<>();
    }

    public interface onClickListener{
        void onItemClick(PlaylistListInterface model, int position);
        void onSettingsItemClick(PlaylistListInterface model, int position);
    }

    private onClickListener ItemListener;

    public PlaylistAdapter(Context context, int LIMIT) {
        this.context = context;
        this.LIMIT = LIMIT;
    }

    public void addNewItems(List<PlaylistListInterface> items) {
        playlist_list.addAll(items);
    }

    @Override
    public int getItemViewType(int position) {
        return playlist_list.get(position).getItemViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PlaylistVHFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        playlist_list.get(position).onBindViewHolder(holder, position, playlist_list.get(position), ItemListener, context);
    }

    public void setListener(onClickListener ItemListener){
        this.ItemListener = ItemListener;
    }

    @Override
    public int getItemCount() {
        return playlist_list.size();
    }


}
