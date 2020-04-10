package com.rootlol.yam.adapter.playlist.item;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rootlol.yam.App;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.ExceptionActivity;
import com.rootlol.yam.adapter.playlist.PlaylistAdapter;
import com.rootlol.yam.adapter.playlist.PlaylistListInterface;
import com.rootlol.yam.adapter.playlist.PlaylistVHFactory;

public class LikeTrackType implements PlaylistListInterface {

    private int position;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position, PlaylistListInterface playlist_list, PlaylistAdapter.onClickListener ItemListener) {
        try {
            PlaylistVHFactory.LikeTrackViewHolder likeTrackViewHolder = (PlaylistVHFactory.LikeTrackViewHolder) viewHolder;

            Glide.with(App.getInstance()).load("https://music.yandex.ru/blocks/playlist-cover/playlist-cover_like.png").into(likeTrackViewHolder.coverImage);
            likeTrackViewHolder.lable.setText(R.string.playlist_like_track);
            likeTrackViewHolder.colTime.setText("");

            if (ItemListener != null) {
                likeTrackViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onItemClick(playlist_list, position);
                    }
                });
                likeTrackViewHolder.buttonSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ItemListener.onSettingsItemClick(playlist_list, position);
                    }
                });
            }
        } catch (Exception e){
            ExceptionActivity.viewError(e.toString());
        }
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public PlaylistListInterface setPosition(int position) {
        this.position = position;
        return this;
    }

    @Override
    public int getType() {
        return PlaylistListInterface.USER_LIKE;
    }
}