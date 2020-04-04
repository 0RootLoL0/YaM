
package com.rootlol.yam.pojo.downloadinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadInfoPojo {

    @SerializedName("invocationInfo")
    @Expose
    private InvocationInfo invocationInfo;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public InvocationInfo getInvocationInfo() {
        return invocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        this.invocationInfo = invocationInfo;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}
