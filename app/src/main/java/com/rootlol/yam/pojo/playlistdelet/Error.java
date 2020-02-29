package com.rootlol.yam.pojo.playlistdelet;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("name")
    private String mName;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
