package com.rootlol.yam.adapter.track.data;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.rootlol.yam.adapter.TrackAdapter;
import com.rootlol.yam.adapter.track.factory.TrackVHFactory;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;

public class ToolbarType implements TrackInterface  {

    public String lable;

    public ToolbarType(String lable) {
        this.lable = lable;
    }

    @Override
    public int getItemViewType() {
        return TrackInterface.TOOLBAR_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position,
                                 TrackInterface playlist_list,
                                 TrackAdapter.onClickListener ItemListener,
                                 Context context) {

        TrackVHFactory.ToolbarViewHolder trackViewHolder = (TrackVHFactory.ToolbarViewHolder) viewHolder;
        trackViewHolder.lable.setText(lable);
//        trackViewHolder.colTime.setText(colTime);
//        trackViewHolder.coverImage.setImageBitmap(ImageTool.convert(coverIm, context.getResources()));
//
//        if(ItemListener != null){
//            trackViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ItemListener.onItemClick(playlist_list, position);
//                }
//            });
//            trackViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ItemListener.onSettingsItemClick(playlist_list, position);
//                }
//            });
//            trackViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ItemListener.onSmartButtonItemClick(playlist_list, position);
//                }
//            });
//        }
    }
}

