package com.rootlol.yam.adapter.playlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.R;

public class PlaylistVHFactory {

    public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

        public ImageView coverImage;
        public TextView lable;
        public TextView colTime;
        public ImageButton buttonSettings;
        public CardView cardView;

        public PlaylistViewHolder(View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.coverImage);
            lable = itemView.findViewById(R.id.lable);
            colTime = itemView.findViewById(R.id.colTime);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            cardView = itemView.findViewById(R.id.cv);
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        View playlistTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);

        return new PlaylistVHFactory.PlaylistViewHolder(playlistTypeView);
    }
}
