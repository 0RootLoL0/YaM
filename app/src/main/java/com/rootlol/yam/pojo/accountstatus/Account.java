package com.rootlol.yam.pojo.accountstatus;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("displayName")
    private String mDisplayName;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("fullName")
    private String mFullName;
    @SerializedName("hostedUser")
    private Boolean mHostedUser;
    @SerializedName("login")
    private String mLogin;
    @SerializedName("now")
    private String mNow;
    @SerializedName("passport-phones")
    private List<PassportPhone> mPassportPhones;
    @SerializedName("region")
    private Long mRegion;
    @SerializedName("registeredAt")
    private String mRegisteredAt;
    @SerializedName("secondName")
    private String mSecondName;
    @SerializedName("serviceAvailable")
    private Boolean mServiceAvailable;
    @SerializedName("uid")
    private Long mUid;

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Boolean getHostedUser() {
        return mHostedUser;
    }

    public void setHostedUser(Boolean hostedUser) {
        mHostedUser = hostedUser;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getNow() {
        return mNow;
    }

    public void setNow(String now) {
        mNow = now;
    }

    public List<PassportPhone> getPassportPhones() {
        return mPassportPhones;
    }

    public void setPassportPhones(List<PassportPhone> passportPhones) {
        mPassportPhones = passportPhones;
    }

    public Long getRegion() {
        return mRegion;
    }

    public void setRegion(Long region) {
        mRegion = region;
    }

    public String getRegisteredAt() {
        return mRegisteredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        mRegisteredAt = registeredAt;
    }

    public String getSecondName() {
        return mSecondName;
    }

    public void setSecondName(String secondName) {
        mSecondName = secondName;
    }

    public Boolean getServiceAvailable() {
        return mServiceAvailable;
    }

    public void setServiceAvailable(Boolean serviceAvailable) {
        mServiceAvailable = serviceAvailable;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

}
