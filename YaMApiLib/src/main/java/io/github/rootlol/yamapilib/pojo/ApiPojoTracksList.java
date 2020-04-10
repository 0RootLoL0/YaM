
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPojoTracksList {

    @SerializedName("invocationInfo")
    @Expose
    private InvocationInfo invocationInfo;
    @SerializedName("result")
    @Expose
    private List<ResultAPTL> result = null;

    public InvocationInfo getInvocationInfo() {
        return invocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        this.invocationInfo = invocationInfo;
    }

    public List<ResultAPTL> getResultAPTL() {
        return result;
    }

    public void setResultAPTL(List<ResultAPTL> result) {
        this.result = result;
    }

}
