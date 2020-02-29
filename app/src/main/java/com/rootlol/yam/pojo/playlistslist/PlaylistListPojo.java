
package com.rootlol.yam.pojo.playlistslist;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PlaylistListPojo {

    @SerializedName("invocationInfo")
    private InvocationInfo mInvocationInfo;
    @SerializedName("result")
    private List<Result> mResult;

    public InvocationInfo getInvocationInfo() {
        return mInvocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        mInvocationInfo = invocationInfo;
    }

    public List<Result> getResult() {
        return mResult;
    }

    public void setResult(List<Result> result) {
        mResult = result;
    }

}
