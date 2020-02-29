package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class TracksToPlayWithAd {

    @SerializedName("track")
    private Track mTrack;
    @SerializedName("type")
    private String mType;

    public Track getTrack() {
        return mTrack;
    }

    public void setTrack(Track track) {
        mTrack = track;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
