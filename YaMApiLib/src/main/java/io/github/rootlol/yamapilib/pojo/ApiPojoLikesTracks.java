
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPojoLikesTracks {

    @SerializedName("invocationInfo")
    @Expose
    private InvocationInfo invocationInfo;
    @SerializedName("result")
    @Expose
    private ResultAPLT result;

    public InvocationInfo getInvocationInfo() {
        return invocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        this.invocationInfo = invocationInfo;
    }

    public ResultAPLT getResult() {
        return result;
    }

    public void setResult(ResultAPLT result) {
        this.result = result;
    }

}
