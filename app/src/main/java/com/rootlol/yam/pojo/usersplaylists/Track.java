
package com.rootlol.yam.pojo.usersplaylists;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.rootlol.yam.App;
import com.rootlol.yam.api.MusicYandexApi;
import com.rootlol.yam.nadapter.track.TrackAdapter;
import com.rootlol.yam.nadapter.track.TrackListInterface;
import com.rootlol.yam.nadapter.track.TrackVHFactory;
import com.rootlol.yam.pojo.track.TrackPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Track implements TrackListInterface {

    @SerializedName("albumId")
    private Long mAlbumId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("timestamp")
    private String mTimestamp;

    public Long getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(Long albumId) {
        mAlbumId = albumId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, TrackListInterface playlist_list, TrackAdapter.onClickListener ItemListener) {
        TrackVHFactory.TrackViewHolder trackViewHolder = (TrackVHFactory.TrackViewHolder) viewHolder;

        MusicYandexApi.getInstance().getTrackInfo(mId.intValue(), "OAuth "+App.getInstance().getDatabase().userDao().getAll().get(0).token).enqueue(new Callback<TrackPojo>() {
            @Override
            public void onResponse(Call<TrackPojo> call, Response<TrackPojo> response) {
                trackViewHolder.trackLable.setText(response.body().getResult().get(0).getTitle());
                trackViewHolder.trackType.setText(response.body().getResult().get(0).getType());
                trackViewHolder.artistTrack.setText(response.body().getResult().get(0).getArtists().get(0).getName());
                Glide.with(App.getInstance())
                        .load("https://" +response.body().getResult().get(0).getOgImage().replace("%%", "200x200"))
                        .into(trackViewHolder.imageView5);
            }

            @Override
            public void onFailure(Call<TrackPojo> call, Throwable t) {

            }
        });
        trackViewHolder.trackLable.setText("qaz");
        trackViewHolder.trackType.setText("ghjk");
        trackViewHolder.artistTrack.setText("uihu");
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

    @Override
    public int getPosit() {
        return 0;
    }
}
