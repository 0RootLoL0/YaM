
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPojoTrack {

    @SerializedName("invocationInfo")
    @Expose
    private InvocationInfo invocationInfo;
    @SerializedName("result")
    @Expose
    private List<ResultAPT> result = null;

    public InvocationInfo getInvocationInfo() {
        return invocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        this.invocationInfo = invocationInfo;
    }

    public List<ResultAPT> getResultAPT() {
        return result;
    }

    public void setResultAPT(List<ResultAPT> result) {
        this.result = result;
    }

}
