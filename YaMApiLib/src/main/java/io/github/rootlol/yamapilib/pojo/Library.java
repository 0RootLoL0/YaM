
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Library {

    @SerializedName("uid")
    @Expose
    private Integer uid;
    @SerializedName("revision")
    @Expose
    private Integer revision;
    @SerializedName("tracks")
    @Expose
    private List<TrackAPLT> tracks = null;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public List<TrackAPLT> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackAPLT> tracks) {
        this.tracks = tracks;
    }

}
