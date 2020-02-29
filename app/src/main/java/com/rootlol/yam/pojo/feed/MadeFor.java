package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class MadeFor {

    @SerializedName("caseForms")
    private CaseForms mCaseForms;
    @SerializedName("userInfo")
    private UserInfo mUserInfo;

    public CaseForms getCaseForms() {
        return mCaseForms;
    }

    public void setCaseForms(CaseForms caseForms) {
        mCaseForms = caseForms;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

}
