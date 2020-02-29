
package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class Subscription {

    @SerializedName("canStartTrial")
    private Boolean mCanStartTrial;
    @SerializedName("mcdonalds")
    private Boolean mMcdonalds;

    public Boolean getCanStartTrial() {
        return mCanStartTrial;
    }

    public void setCanStartTrial(Boolean canStartTrial) {
        mCanStartTrial = canStartTrial;
    }

    public Boolean getMcdonalds() {
        return mMcdonalds;
    }

    public void setMcdonalds(Boolean mcdonalds) {
        mMcdonalds = mcdonalds;
    }

}
