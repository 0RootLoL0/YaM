
package com.rootlol.yam.pojo.playlistslist;

import com.google.gson.annotations.SerializedName;

public class InvocationInfo {

    @SerializedName("exec-duration-millis")
    private String mExecDurationMillis;
    @SerializedName("hostname")
    private String mHostname;
    @SerializedName("req-id")
    private String mReqId;

    public String getExecDurationMillis() {
        return mExecDurationMillis;
    }

    public void setExecDurationMillis(String execDurationMillis) {
        mExecDurationMillis = execDurationMillis;
    }

    public String getHostname() {
        return mHostname;
    }

    public void setHostname(String hostname) {
        mHostname = hostname;
    }

    public String getReqId() {
        return mReqId;
    }

    public void setReqId(String reqId) {
        mReqId = reqId;
    }

}
