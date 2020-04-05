package com.rootlol.yam.adapter.playlist.data;

import androidx.paging.DataSource;

import com.rootlol.yam.pojo.feed.GeneratedPlaylist;

import java.util.List;

// TODO: разобраться нах нужен этот класс
public class PlaylistDataSourceFactory extends DataSource.Factory{
    List<GeneratedPlaylist> generatedPlaylists;
    public PlaylistDataSourceFactory(List<GeneratedPlaylist> generatedPlaylists) {
        this.generatedPlaylists = generatedPlaylists;
    }

    @Override
    public DataSource create() {
        return new PlaylistDataSourse(generatedPlaylists);
    }
}