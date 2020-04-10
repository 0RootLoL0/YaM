
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TracksToPlayWithAd {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("track")
    @Expose
    private Track_ track;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Track_ getTrack() {
        return track;
    }

    public void setTrack(Track_ track) {
        this.track = track;
    }

}
