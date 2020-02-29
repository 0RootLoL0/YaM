package com.rootlol.yam.adapter.track.factory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.R;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;

public class TrackVHFactory {

    public static class ToolbarViewHolder extends RecyclerView.ViewHolder {

        public TextView lable;

        public ToolbarViewHolder(View itemView) {
            super(itemView);
            lable = itemView.findViewById(R.id.textView11);
        }
    }

    public static class TrackViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView5;
        public TextView trackLable;
        public TextView trackType;
        public TextView artistTrack;
        public ImageButton smartButton;
        public ImageButton buttonSettings;
        public CardView itemTrack;

        public TrackViewHolder(View itemView) {
            super(itemView);
            imageView5 = itemView.findViewById(R.id.imageView5);
            trackLable = itemView.findViewById(R.id.trackLable);
            trackType = itemView.findViewById(R.id.trackType);
            artistTrack = itemView.findViewById(R.id.artistTrack);
            smartButton = itemView.findViewById(R.id.smartButton);
            buttonSettings = itemView.findViewById(R.id.buttonSettings);
            itemTrack = itemView.findViewById(R.id.itemTrack);
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TrackInterface.TRACK_TYPE:
                View toolbarTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
                return new TrackVHFactory.TrackViewHolder(toolbarTypeView);
            case TrackInterface.TOOLBAR_TYPE:
                View trackToolbarTypeView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track_toolbar, parent, false);
                return new TrackVHFactory.ToolbarViewHolder(trackToolbarTypeView);

            default:
                return null;
        }
    }
}
