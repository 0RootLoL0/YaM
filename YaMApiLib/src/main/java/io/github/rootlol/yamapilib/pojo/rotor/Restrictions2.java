
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restrictions2 {

    @SerializedName("moodEnergy")
    @Expose
    private MoodEnergy moodEnergy;
    @SerializedName("diversity")
    @Expose
    private Diversity_ diversity;
    @SerializedName("language")
    @Expose
    private Language_ language;

    public MoodEnergy getMoodEnergy() {
        return moodEnergy;
    }

    public void setMoodEnergy(MoodEnergy moodEnergy) {
        this.moodEnergy = moodEnergy;
    }

    public Diversity_ getDiversity() {
        return diversity;
    }

    public void setDiversity(Diversity_ diversity) {
        this.diversity = diversity;
    }

    public Language_ getLanguage() {
        return language;
    }

    public void setLanguage(Language_ language) {
        this.language = language;
    }

}
