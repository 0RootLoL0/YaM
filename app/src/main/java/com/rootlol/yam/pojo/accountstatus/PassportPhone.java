
package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class PassportPhone {

    @SerializedName("phone")
    private String mPhone;

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

}
