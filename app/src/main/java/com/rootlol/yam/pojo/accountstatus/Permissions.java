package com.rootlol.yam.pojo.accountstatus;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Permissions {

    @SerializedName("default")
    private List<String> mDefault;
    @SerializedName("until")
    private String mUntil;
    @SerializedName("values")
    private List<String> mValues;

    public List<String> getDefault() {
        return mDefault;
    }

    public void setDefault(List<String> sdefault) {
        mDefault = sdefault;
    }

    public String getUntil() {
        return mUntil;
    }

    public void setUntil(String until) {
        mUntil = until;
    }

    public List<String> getValues() {
        return mValues;
    }

    public void setValues(List<String> values) {
        mValues = values;
    }

}
