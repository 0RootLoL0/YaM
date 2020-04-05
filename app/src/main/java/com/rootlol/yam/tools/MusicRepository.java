package com.rootlol.yam.tools;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository {

    private List<Track> data;

    private int maxIndex;
    private int currentItemIndex = 0;
    private static MusicRepository instance;

    public MusicRepository() {
        data = new ArrayList<>();
        instance = this;
    }
    public static MusicRepository getInstance() {
        return instance;
    }
    public void setData(Track data) {
        this.data.add(data);
        maxIndex = this.data.size();
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
        private Bitmap bitmapRes;
        private long duration; // in ms
        private Uri uri;

        public Track(String title, String artist, Bitmap bitmapRes, long duration, Uri uri) {
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

        public Bitmap getBitmapResId() {
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
