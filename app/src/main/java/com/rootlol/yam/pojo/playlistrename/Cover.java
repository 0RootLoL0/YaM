package com.rootlol.yam.pojo.playlistrename;

import com.google.gson.annotations.SerializedName;

public class Cover {

    @SerializedName("error")
    private String mError;

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

}
