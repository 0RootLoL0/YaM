package com.rootlol.yam.adapter.track.data;

import androidx.paging.DataSource;

import com.rootlol.yam.pojo.usersplaylists.Track;

import java.util.List;

//   TODO: разобраться нах нужен этот класс
public class TrackDataSourceFactory extends DataSource.Factory{
    List<Track> results;
    public TrackDataSourceFactory(List<Track> results) {
        this.results = results;
    }

    @Override
    public DataSource create() {

        return new TrackDataSourse(results);
    }
}