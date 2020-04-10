
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("mood")
    @Expose
    private Integer mood;
    @SerializedName("energy")
    @Expose
    private Integer energy;
    @SerializedName("diversity")
    @Expose
    private String diversity;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public String getDiversity() {
        return diversity;
    }

    public void setDiversity(String diversity) {
        this.diversity = diversity;
    }

}
