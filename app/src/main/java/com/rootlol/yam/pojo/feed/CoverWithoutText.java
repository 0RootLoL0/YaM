package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class CoverWithoutText {

    @SerializedName("custom")
    private Boolean mCustom;
    @SerializedName("dir")
    private String mDir;
    @SerializedName("type")
    private String mType;
    @SerializedName("uri")
    private String mUri;
    @SerializedName("version")
    private String mVersion;

    public Boolean getCustom() {
        return mCustom;
    }

    public void setCustom(Boolean custom) {
        mCustom = custom;
    }

    public String getDir() {
        return mDir;
    }

    public void setDir(String dir) {
        mDir = dir;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
