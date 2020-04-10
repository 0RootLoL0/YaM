package com.rootlol.yam.adapter.rotor;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RotorAdapter extends PagedListAdapter<RotorInterface, RecyclerView.ViewHolder> {

    private onClickListener ItemListener;
    private static DiffUtil.ItemCallback<RotorInterface> DIFF_CALLBACK = new DiffUtil.ItemCallback<RotorInterface>() {
        @Override
        public boolean areItemsTheSame(RotorInterface oldItem, RotorInterface newItem) {
            return oldItem.getPosition() == newItem.getPosition();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(RotorInterface oldItem, RotorInterface newItem) {
            return oldItem.equals(newItem);
        }
    };
    public RotorAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RotorVHFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder, position, getItem(position), ItemListener);
    }

    @Nullable
    @Override
    protected RotorInterface getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public interface onClickListener{
        void onItemClick(RotorInterface model, int position);
        void onSettingsItemClick(RotorInterface model, int position);
    }
    public void setListener(onClickListener ItemListener){
        this.ItemListener = ItemListener;
    }
}
