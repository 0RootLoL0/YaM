package com.rootlol.yam.adapter.track.data;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.TrackAdapter;
import com.rootlol.yam.adapter.track.factory.TrackVHFactory;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;
import com.rootlol.yam.tools.ImageTool;

public class TrackType implements TrackInterface {

    public String lable;
    public String trackType;
    public String artist;
    public String coverIm;


    public TrackType(String lable, String trackType, String artist, String coverIm) {
        this.lable = lable;
        this.trackType = trackType;
        this.artist = artist;
        this.coverIm = coverIm;
    }

    @Override
    public int getItemViewType() {
        return TrackInterface.TRACK_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 final int position,
                                 final TrackInterface playlist_list,
                                 final TrackAdapter.onClickListener ItemListener,
                                 Context context) {

        TrackVHFactory.TrackViewHolder trackViewHolder = (TrackVHFactory.TrackViewHolder) viewHolder;
        trackViewHolder.imageView5.setImageBitmap(ImageTool.convert(coverIm, context.getResources()));
        trackViewHolder.trackLable.setText(lable);
        trackViewHolder.trackType.setText(trackType);
        trackViewHolder.artistTrack.setText(artist);

        if(ItemListener != null){
            trackViewHolder.itemTrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onClickTrack(playlist_list, position);
                }
            });
            trackViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onSettingsClickTrack(playlist_list, position);
                }
            });
            trackViewHolder.smartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onSmartButtonClickTrack(playlist_list, position);
                }
            });
        }
    }
}

