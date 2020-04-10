
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Normalization {

    @SerializedName("gain")
    @Expose
    private Double gain;
    @SerializedName("peak")
    @Expose
    private Integer peak;

    public Double getGain() {
        return gain;
    }

    public void setGain(Double gain) {
        this.gain = gain;
    }

    public Integer getPeak() {
        return peak;
    }

    public void setPeak(Integer peak) {
        this.peak = peak;
    }

}
