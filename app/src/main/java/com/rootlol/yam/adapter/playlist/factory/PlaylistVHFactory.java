package com.rootlol.yam.adapter.playlist.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.R;
import com.rootlol.yam.adapter.playlist.interfaces.PlaylistListInterface;

public class PlaylistVHFactory {
    public static class TitleViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public TitleViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.titlePlaylis);
        }

    }

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

        switch (viewType) {
            case PlaylistListInterface.TITLE_TYPE:
                View playlistTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist_title, parent, false);
                return new PlaylistVHFactory.TitleViewHolder(playlistTypeView);

            case PlaylistListInterface.PLAYLIST_TYPE:
                View titleTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
                return new PlaylistVHFactory.PlaylistViewHolder(titleTypeView);

            default:
                return null;
        }
    }
}
