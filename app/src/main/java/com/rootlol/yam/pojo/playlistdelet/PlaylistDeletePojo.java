package com.rootlol.yam.pojo.playlistdelet;

import com.google.gson.annotations.SerializedName;

public class PlaylistDeletePojo {

    @SerializedName("error")
    private Error mError;
    @SerializedName("invocationInfo")
    private InvocationInfo mInvocationInfo;
    @SerializedName("result")
    private String mResult;

    public Error getError() {
        return mError;
    }

    public void setError(Error error) {
        mError = error;
    }

    public InvocationInfo getInvocationInfo() {
        return mInvocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        mInvocationInfo = invocationInfo;
    }

    public String getResult() {
        return mResult;
    }

    public void setResult(String result) {
        mResult = result;
    }

}
