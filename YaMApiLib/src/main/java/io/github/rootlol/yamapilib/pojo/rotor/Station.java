
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("station")
    @Expose
    private Station_ station;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    @SerializedName("settings2")
    @Expose
    private Settings2 settings2;
    @SerializedName("adParams")
    @Expose
    private AdParams adParams;
    @SerializedName("explanation")
    @Expose
    private String explanation;

    public Station_ getStation() {
        return station;
    }

    public void setStation(Station_ station) {
        this.station = station;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Settings2 getSettings2() {
        return settings2;
    }

    public void setSettings2(Settings2 settings2) {
        this.settings2 = settings2;
    }

    public AdParams getAdParams() {
        return adParams;
    }

    public void setAdParams(AdParams adParams) {
        this.adParams = adParams;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
