package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class GeneratedPlaylist {

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

}
