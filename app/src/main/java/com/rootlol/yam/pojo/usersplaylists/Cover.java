
package com.rootlol.yam.pojo.usersplaylists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cover {

    @SerializedName("custom")
    private Boolean mCustom;
    @SerializedName("itemsUri")
    private List<String> mItemsUri;
    @SerializedName("type")
    private String mType;

    public Boolean getCustom() {
        return mCustom;
    }

    public void setCustom(Boolean custom) {
        mCustom = custom;
    }

    public List<String> getItemsUri() {
        return mItemsUri;
    }

    public void setItemsUri(List<String> itemsUri) {
        mItemsUri = itemsUri;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
