
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Energy {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("min")
    @Expose
    private Min_ min;
    @SerializedName("max")
    @Expose
    private Max_ max;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Min_ getMin() {
        return min;
    }

    public void setMin(Min_ min) {
        this.min = min;
    }

    public Max_ getMax() {
        return max;
    }

    public void setMax(Max_ max) {
        this.max = max;
    }

}
