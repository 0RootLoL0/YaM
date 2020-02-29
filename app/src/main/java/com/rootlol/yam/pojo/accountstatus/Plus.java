package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class Plus {

    @SerializedName("hasPlus")
    private Boolean mHasPlus;
    @SerializedName("isTutorialCompleted")
    private Boolean mIsTutorialCompleted;

    public Boolean getHasPlus() {
        return mHasPlus;
    }

    public void setHasPlus(Boolean hasPlus) {
        mHasPlus = hasPlus;
    }

    public Boolean getIsTutorialCompleted() {
        return mIsTutorialCompleted;
    }

    public void setIsTutorialCompleted(Boolean isTutorialCompleted) {
        mIsTutorialCompleted = isTutorialCompleted;
    }

}
