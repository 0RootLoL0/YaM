package com.rootlol.yam.pojo.feed;

import com.google.gson.annotations.SerializedName;

public class Normalization {

    @SerializedName("gain")
    private Double mGain;
    @SerializedName("peak")
    private Long mPeak;

    public Double getGain() {
        return mGain;
    }

    public void setGain(Double gain) {
        mGain = gain;
    }

    public Long getPeak() {
        return mPeak;
    }

    public void setPeak(Long peak) {
        mPeak = peak;
    }

}
