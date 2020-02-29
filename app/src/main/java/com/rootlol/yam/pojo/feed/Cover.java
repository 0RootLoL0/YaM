package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class Cover {

    @SerializedName("custom")
    private Boolean mCustom;
    @SerializedName("dir")
    private String mDir;
    @SerializedName("prefix")
    private String mPrefix;
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

    public String getPrefix() {
        return mPrefix;
    }

    public void setPrefix(String prefix) {
        mPrefix = prefix;
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
