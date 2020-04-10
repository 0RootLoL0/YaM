package com.rootlol.yam.adapter.track;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


public class TrackAdapter extends PagedListAdapter<TrackListInterface, RecyclerView.ViewHolder> {

    private onClickListener ItemListener = null;
    public TrackAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return TrackVHFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder, position, getItem(position), ItemListener);
    }

    public void setListener(onClickListener ItemListener){
        this.ItemListener = ItemListener;
    }
    private static DiffUtil.ItemCallback<TrackListInterface> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TrackListInterface>() {
                @Override
                public boolean areItemsTheSame(TrackListInterface oldItem, TrackListInterface newItem) {
                    return oldItem.getPosition() == newItem.getPosition();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(TrackListInterface oldItem, TrackListInterface newItem) {
                    return oldItem.equals(newItem);
                }
            };


    public interface onClickListener{
        void onClickTrack(TrackListInterface model, int position);
        void onSettingsClickTrack(TrackListInterface model, int position);
        void onSmartButtonClickTrack(TrackListInterface model, int position);
    }
}