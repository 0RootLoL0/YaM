package com.rootlol.yam.adapter.track.item;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.track.TrackAdapter;
import com.rootlol.yam.adapter.track.TrackListInterface;
import com.rootlol.yam.adapter.track.TrackVHFactory;

import io.github.rootlol.yamapilib.MusicYandexApi;
import io.github.rootlol.yamapilib.pojo.ApiPojoTrack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackType implements TrackListInterface {

    private String id;
    private String albumId;
    private String timestamp;
    private ApiPojoTrack info;
    private int position;
    private TrackVHFactory.TrackViewHolder trackViewHolder;

    public TrackType(String id, String albumId, String timestamp) {
        this.id = id;
        this.albumId = albumId;
        this.timestamp = timestamp;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, TrackListInterface playlist_list, TrackAdapter.onClickListener ItemListener) {
        trackViewHolder = (TrackVHFactory.TrackViewHolder) viewHolder;

        trackViewHolder.trackLable.setText("");
        trackViewHolder.trackType.setText("");
        trackViewHolder.artistTrack.setText("");
        trackViewHolder.imageView5.setImageResource(R.drawable.playlist_no_cover);

        if (info != null){
            try {
                trackViewHolder.trackLable.setText(info.getResultAPT().get(0).getTitle());
                trackViewHolder.trackType.setText(info.getResultAPT().get(0).getType());
                if (info.getResultAPT().get(0).getArtists().size() != 0)
                    trackViewHolder.artistTrack.setText(info.getResultAPT().get(0).getArtists().get(0).getName());
                else trackViewHolder.artistTrack.setText("");

                Glide.with(App.getInstance()).load("https://" + info.getResultAPT().get(0).getOgImage().replace("%%", "200x200")).into(trackViewHolder.imageView5);

                if (ItemListener != null) {
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
            }catch (Exception e){ ExceptionActivity.viewError( e.toString());}
        }
        else MusicYandexApi.getInstance().getTrackInfo(Integer.parseInt(id)).enqueue(new Callback<ApiPojoTrack>() {
                    @Override
                    public void onResponse(Call<ApiPojoTrack> call, Response<ApiPojoTrack> response) {
                        try {
                            info = response.body();
                            trackViewHolder.trackLable.setText(info.getResultAPT().get(0).getTitle());
                            trackViewHolder.trackType.setText(info.getResultAPT().get(0).getType());
                            if (info.getResultAPT().get(0).getArtists().size() != 0)
                                trackViewHolder.artistTrack.setText(info.getResultAPT().get(0).getArtists().get(0).getName());
                            else trackViewHolder.artistTrack.setText("");

                            Glide.with(App.getInstance()).load("https://" + info.getResultAPT().get(0).getOgImage().replace("%%", "200x200")).into(trackViewHolder.imageView5);

                            if (ItemListener != null) {
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
                        }catch (Exception e){ ExceptionActivity.viewError( e.toString());}
                    }

                    @Override
                    public void onFailure(Call<ApiPojoTrack> call, Throwable t) {
                        trackViewHolder.trackLable.setText("net error");
                        trackViewHolder.trackType.setText("net error");
                        trackViewHolder.artistTrack.setText("net error");
                    }
                });
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public TrackListInterface setPosition(int position) {
        this.position = position;
        return this;
    }
}
