
package com.rootlol.yam.pojo.likestracks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvocationInfo {

    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("req-id")
    @Expose
    private String reqId;
    @SerializedName("exec-duration-millis")
    @Expose
    private String execDurationMillis;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getExecDurationMillis() {
        return execDurationMillis;
    }

    public void setExecDurationMillis(String execDurationMillis) {
        this.execDurationMillis = execDurationMillis;
    }

}
