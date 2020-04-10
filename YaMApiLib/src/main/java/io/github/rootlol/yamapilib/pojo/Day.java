
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("tracksToPlay")
    @Expose
    private List<TracksToPlay> tracksToPlay = null;
    @SerializedName("tracksToPlayWithAds")
    @Expose
    private List<TracksToPlayWithAd> tracksToPlayWithAds = null;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<TracksToPlay> getTracksToPlay() {
        return tracksToPlay;
    }

    public void setTracksToPlay(List<TracksToPlay> tracksToPlay) {
        this.tracksToPlay = tracksToPlay;
    }

    public List<TracksToPlayWithAd> getTracksToPlayWithAds() {
        return tracksToPlayWithAds;
    }

    public void setTracksToPlayWithAds(List<TracksToPlayWithAd> tracksToPlayWithAds) {
        this.tracksToPlayWithAds = tracksToPlayWithAds;
    }

}
