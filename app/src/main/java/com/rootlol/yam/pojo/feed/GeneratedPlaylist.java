package com.rootlol.yam.pojo.feed;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.rootlol.yam.App;
import com.rootlol.yam.nadapter.playlist.PlaylistAdapter;
import com.rootlol.yam.nadapter.playlist.PlaylistListInterface;
import com.rootlol.yam.nadapter.playlist.PlaylistVHFactory;

public class GeneratedPlaylist implements PlaylistListInterface {

    public int posit;

    @SerializedName("data")
    private Data mData;
    @SerializedName("notify")
    private Boolean mNotify;
    @SerializedName("ready")
    private Boolean mReady;
    @SerializedName("type")
    private String mType;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public Boolean getNotify() {
        return mNotify;
    }

    public void setNotify(Boolean notify) {
        mNotify = notify;
    }

    public Boolean getReady() {
        return mReady;
    }

    public void setReady(Boolean ready) {
        mReady = ready;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public GeneratedPlaylist(int posit) {
        this.posit = posit;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position,
                                 PlaylistListInterface playlist_list,
                                 PlaylistAdapter.onClickListener ItemListener) {
        PlaylistVHFactory.PlaylistViewHolder playlistViewHolder = (PlaylistVHFactory.PlaylistViewHolder) viewHolder;
        playlistViewHolder.lable.setText(mData.getTitle());
        playlistViewHolder.colTime.setText(mData.getCreated());
        Glide.with(App.getInstance())
                .load("https://" +mData.getOgImage().replace("%%", "200x200"))
                .into(playlistViewHolder.coverImage);

        if(ItemListener != null){
            playlistViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onItemClick(playlist_list, position);
                }
            });
            playlistViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemListener.onSettingsItemClick(playlist_list, position);
                }
            });
        }
    }

    @Override
    public int getPosit() {
        return posit;
    }
}
