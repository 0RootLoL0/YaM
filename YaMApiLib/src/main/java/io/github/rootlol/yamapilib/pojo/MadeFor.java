
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MadeFor {

    @SerializedName("userInfo")
    @Expose
    private UserInfo userInfo;
    @SerializedName("caseForms")
    @Expose
    private CaseForms caseForms;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public CaseForms getCaseForms() {
        return caseForms;
    }

    public void setCaseForms(CaseForms caseForms) {
        this.caseForms = caseForms;
    }

}
