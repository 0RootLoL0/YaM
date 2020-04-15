
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings2 {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("moodEnergy")
    @Expose
    private String moodEnergy;
    @SerializedName("diversity")
    @Expose
    private String diversity;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMoodEnergy() {
        return moodEnergy;
    }

    public void setMoodEnergy(String moodEnergy) {
        this.moodEnergy = moodEnergy;
    }

    public String getDiversity() {
        return diversity;
    }

    public void setDiversity(String diversity) {
        this.diversity = diversity;
    }

}
