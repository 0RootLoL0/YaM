package com.rootlol.yam.tools;

import android.net.Uri;

import com.rootlol.yam.App;
import com.rootlol.yam.db.TrackListCacheDB;
import com.rootlol.yam.db.UsersDB;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository {

    private List<Track> data;

    private int maxIndex;
    private int currentItemIndex = 0;
    private int kind;

    private UsersDB.UserDao userDao;
    private TrackListCacheDB.TrackCacheDao trackCacheDao;

    public MusicRepository() {
        setDB();
        this.kind = App.getInstance().getKind();
        data = new ArrayList<>();

        for (TrackListCacheDB.TrackListCacheEntity ww: trackCacheDao.getAlltag(kind) ) {
            data.add(new Track(ww.titleTrack, ww.artists_name, ww.coverImage, ww.durationMs, Uri.parse(ww.urlDownload)));
        }

        this.maxIndex = data.size()-1;
    }

    private void setDB(){
        userDao = App.getInstance().getDatabase().userDao();
        trackCacheDao = App.getInstance().getDatabase().trackCacheDao();
    }

    public Track getNext() {
        if (currentItemIndex == maxIndex)
            currentItemIndex = 0;
        else
            currentItemIndex++;
        return getCurrent();
    }

    public Track getPrevious() {
        if (currentItemIndex == 0)
            currentItemIndex = maxIndex;
        else
            currentItemIndex--;
        return getCurrent();
    }

    public Track getCurrent() {
        return data.get(currentItemIndex);
    }

    public static class Track {

        private String title;
        private String artist;
        private String bitmapRes;
        private long duration; // in ms
        private Uri uri;

        Track(String title, String artist, String bitmapRes, long duration, Uri uri) {
            this.title = title;
            this.artist = artist;
            this.bitmapRes = bitmapRes;
            this.duration = duration;
            this.uri = uri;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getBitmapResId() {
            return bitmapRes;
        }

        public Uri getUri() {
            return uri;
        }
        public long getDuration() {
            return duration;
        }
    }
}
