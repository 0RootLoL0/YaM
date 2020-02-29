package com.rootlol.yam.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.track.factory.TrackVHFactory;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;

import java.util.ArrayList;
import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter {

    private List<TrackInterface> track_list = new ArrayList<>();
    private Context context;
    private boolean allItemsLoaded;
    private onClickListener ItemListener;

    public interface onClickListener{
        void onClickTrack(TrackInterface model, int position);
        void onSettingsClickTrack(TrackInterface model, int position);
        void onSmartButtonClickTrack(TrackInterface model, int position);
    }

    public void delItem() {
        track_list = new ArrayList<>();
    }


    public TrackAdapter(Context context) {
        this.context = context;
    }
    public void addNewItems(List<TrackInterface> items) {
        if (items.size() == 0) {
            allItemsLoaded = true;
            return;
        }
        track_list.addAll(items);
    }

    public boolean isAllItemsLoaded() {
        return allItemsLoaded;
    }

    @Override
    public int getItemViewType(int position) {
        return track_list.get(position).getItemViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TrackVHFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        track_list.get(position).onBindViewHolder(holder, position, track_list.get(position), ItemListener, context);
    }

    public void setListener(onClickListener ItemListener){
        this.ItemListener = ItemListener;
    }

    @Override
    public int getItemCount() {
        return track_list.size();
    }

}
