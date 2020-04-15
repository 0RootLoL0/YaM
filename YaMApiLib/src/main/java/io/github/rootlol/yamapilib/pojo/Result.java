
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.rootlol.yamapilib.pojo.feed.GeneratedPlaylist;

public class Result {

    @SerializedName("nextRevision")
    @Expose
    private String nextRevision;
    @SerializedName("canGetMoreEvents")
    @Expose
    private Boolean canGetMoreEvents;
    @SerializedName("pumpkin")
    @Expose
    private Boolean pumpkin;
    @SerializedName("isWizardPassed")
    @Expose
    private Boolean isWizardPassed;
    @SerializedName("generatedPlaylists")
    @Expose
    private List<GeneratedPlaylist> generatedPlaylists = null;
    @SerializedName("headlines")
    @Expose
    private List<Headline> headlines = null;
    @SerializedName("today")
    @Expose
    private String today;
    @SerializedName("days")
    @Expose
    private List<Day> days = null;

    public String getNextRevision() {
        return nextRevision;
    }

    public void setNextRevision(String nextRevision) {
        this.nextRevision = nextRevision;
    }

    public Boolean getCanGetMoreEvents() {
        return canGetMoreEvents;
    }

    public void setCanGetMoreEvents(Boolean canGetMoreEvents) {
        this.canGetMoreEvents = canGetMoreEvents;
    }

    public Boolean getPumpkin() {
        return pumpkin;
    }

    public void setPumpkin(Boolean pumpkin) {
        this.pumpkin = pumpkin;
    }

    public Boolean getIsWizardPassed() {
        return isWizardPassed;
    }

    public void setIsWizardPassed(Boolean isWizardPassed) {
        this.isWizardPassed = isWizardPassed;
    }

    public List<GeneratedPlaylist> getGeneratedPlaylists() {
        return generatedPlaylists;
    }

    public void setGeneratedPlaylists(List<GeneratedPlaylist> generatedPlaylists) {
        this.generatedPlaylists = generatedPlaylists;
    }

    public List<Headline> getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List<Headline> headlines) {
        this.headlines = headlines;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

}
