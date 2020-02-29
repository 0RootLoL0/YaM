package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class AccountStatusPojo {

    @SerializedName("invocationInfo")
    private InvocationInfo mInvocationInfo;
    @SerializedName("result")
    private Result mResult;

    public InvocationInfo getInvocationInfo() {
        return mInvocationInfo;
    }

    public void setInvocationInfo(InvocationInfo invocationInfo) {
        mInvocationInfo = invocationInfo;
    }

    public Result getResult() {
        return mResult;
    }

    public void setResult(Result result) {
        mResult = result;
    }

}
