package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class CaseForms {

    @SerializedName("accusative")
    private String mAccusative;
    @SerializedName("dative")
    private String mDative;
    @SerializedName("genitive")
    private String mGenitive;
    @SerializedName("instrumental")
    private String mInstrumental;
    @SerializedName("nominative")
    private String mNominative;
    @SerializedName("prepositional")
    private String mPrepositional;

    public String getAccusative() {
        return mAccusative;
    }

    public void setAccusative(String accusative) {
        mAccusative = accusative;
    }

    public String getDative() {
        return mDative;
    }

    public void setDative(String dative) {
        mDative = dative;
    }

    public String getGenitive() {
        return mGenitive;
    }

    public void setGenitive(String genitive) {
        mGenitive = genitive;
    }

    public String getInstrumental() {
        return mInstrumental;
    }

    public void setInstrumental(String instrumental) {
        mInstrumental = instrumental;
    }

    public String getNominative() {
        return mNominative;
    }

    public void setNominative(String nominative) {
        mNominative = nominative;
    }

    public String getPrepositional() {
        return mPrepositional;
    }

    public void setPrepositional(String prepositional) {
        mPrepositional = prepositional;
    }

}
