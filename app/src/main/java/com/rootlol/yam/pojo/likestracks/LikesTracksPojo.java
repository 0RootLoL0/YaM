
package com.rootlol.yam.pojo.likestracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LikesTracksPojo {

    @SerializedName("invocationInfo")
    @Expose
    private InvocationInfo invocationInfo;
    @SerializedName("result")
    @Expose
    private Result result;

    public InvocationInfo getInvocationInfo() {
        return invocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        this.invocationInfo = invocationInfo;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
