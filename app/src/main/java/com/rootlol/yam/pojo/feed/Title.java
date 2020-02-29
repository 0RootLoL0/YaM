package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("text")
    private String mText;
    @SerializedName("type")
    private String mType;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
