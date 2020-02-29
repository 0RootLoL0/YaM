
package com.rootlol.yam.pojo.usersplaylists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersPlaylistsPojo {

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
