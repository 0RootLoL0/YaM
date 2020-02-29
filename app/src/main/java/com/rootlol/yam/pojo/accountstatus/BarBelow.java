package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class BarBelow {

    @SerializedName("alertId")
    private String mAlertId;
    @SerializedName("alertType")
    private String mAlertType;
    @SerializedName("bgColor")
    private String mBgColor;
    @SerializedName("button")
    private Button mButton;
    @SerializedName("closeButton")
    private Boolean mCloseButton;
    @SerializedName("text")
    private String mText;
    @SerializedName("textColor")
    private String mTextColor;

    public String getAlertId() {
        return mAlertId;
    }

    public void setAlertId(String alertId) {
        mAlertId = alertId;
    }

    public String getAlertType() {
        return mAlertType;
    }

    public void setAlertType(String alertType) {
        mAlertType = alertType;
    }

    public String getBgColor() {
        return mBgColor;
    }

    public void setBgColor(String bgColor) {
        mBgColor = bgColor;
    }

    public Button getButton() {
        return mButton;
    }

    public void setButton(Button button) {
        mButton = button;
    }

    public Boolean getCloseButton() {
        return mCloseButton;
    }

    public void setCloseButton(Boolean closeButton) {
        mCloseButton = closeButton;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getTextColor() {
        return mTextColor;
    }

    public void setTextColor(String textColor) {
        mTextColor = textColor;
    }

}
