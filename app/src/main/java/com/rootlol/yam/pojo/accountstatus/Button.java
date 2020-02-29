
package com.rootlol.yam.pojo.accountstatus;

import com.google.gson.annotations.SerializedName;

public class Button {

    @SerializedName("bgColor")
    private String mBgColor;
    @SerializedName("text")
    private String mText;
    @SerializedName("textColor")
    private String mTextColor;
    @SerializedName("uri")
    private String mUri;

    public String getBgColor() {
        return mBgColor;
    }

    public void setBgColor(String bgColor) {
        mBgColor = bgColor;
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

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

}
