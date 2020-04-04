package com.rootlol.yam.nadapter.playlist;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


public class PlaylistAdapter extends PagedListAdapter<PlaylistListInterface, RecyclerView.ViewHolder> {

    private onClickListener ItemListener;
    public PlaylistAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PlaylistVHFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder, position, getItem(position), ItemListener);
    }

    public void setListener(onClickListener ItemListener){
        this.ItemListener = ItemListener;
    }
    private static DiffUtil.ItemCallback<PlaylistListInterface> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<PlaylistListInterface>() {
                @Override
                public boolean areItemsTheSame(PlaylistListInterface oldItem, PlaylistListInterface newItem) {
                    return oldItem.getPosit() == newItem.getPosit();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(PlaylistListInterface oldItem, PlaylistListInterface newItem) {
                    return oldItem.equals(newItem);
                }
            };


    public interface onClickListener{
        void onItemClick(PlaylistListInterface model, int position);
        void onSettingsItemClick(PlaylistListInterface model, int position);
    }
}