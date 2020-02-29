package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("account")
    private Account mAccount;
    @SerializedName("bar-below")
    private BarBelow mBarBelow;
    @SerializedName("defaultEmail")
    private String mDefaultEmail;
    @SerializedName("permissions")
    private Permissions mPermissions;
    @SerializedName("plus")
    private Plus mPlus;
    @SerializedName("subeditor")
    private Boolean mSubeditor;
    @SerializedName("subeditorLevel")
    private Long mSubeditorLevel;
    @SerializedName("subscription")
    private Subscription mSubscription;

    public Account getAccount() {
        return mAccount;
    }

    public void setAccount(Account account) {
        mAccount = account;
    }

    public BarBelow getBarBelow() {
        return mBarBelow;
    }

    public void setBarBelow(BarBelow barBelow) {
        mBarBelow = barBelow;
    }

    public String getDefaultEmail() {
        return mDefaultEmail;
    }

    public void setDefaultEmail(String defaultEmail) {
        mDefaultEmail = defaultEmail;
    }

    public Permissions getPermissions() {
        return mPermissions;
    }

    public void setPermissions(Permissions permissions) {
        mPermissions = permissions;
    }

    public Plus getPlus() {
        return mPlus;
    }

    public void setPlus(Plus plus) {
        mPlus = plus;
    }

    public Boolean getSubeditor() {
        return mSubeditor;
    }

    public void setSubeditor(Boolean subeditor) {
        mSubeditor = subeditor;
    }

    public Long getSubeditorLevel() {
        return mSubeditorLevel;
    }

    public void setSubeditorLevel(Long subeditorLevel) {
        mSubeditorLevel = subeditorLevel;
    }

    public Subscription getSubscription() {
        return mSubscription;
    }

    public void setSubscription(Subscription subscription) {
        mSubscription = subscription;
    }

}
