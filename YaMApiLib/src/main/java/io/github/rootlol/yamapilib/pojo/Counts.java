
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("tracks")
    @Expose
    private Integer tracks;
    @SerializedName("directAlbums")
    @Expose
    private Integer directAlbums;
    @SerializedName("alsoAlbums")
    @Expose
    private Integer alsoAlbums;
    @SerializedName("alsoTracks")
    @Expose
    private Integer alsoTracks;

    public Integer getTracks() {
        return tracks;
    }

    public void setTracks(Integer tracks) {
        this.tracks = tracks;
    }

    public Integer getDirectAlbums() {
        return directAlbums;
    }

    public void setDirectAlbums(Integer directAlbums) {
        this.directAlbums = directAlbums;
    }

    public Integer getAlsoAlbums() {
        return alsoAlbums;
    }

    public void setAlsoAlbums(Integer alsoAlbums) {
        this.alsoAlbums = alsoAlbums;
    }

    public Integer getAlsoTracks() {
        return alsoTracks;
    }

    public void setAlsoTracks(Integer alsoTracks) {
        this.alsoTracks = alsoTracks;
    }

}
