
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("typeForFrom")
    @Expose
    private String typeForFrom;
    @SerializedName("title")
    @Expose
    private List<Title> title = null;
    @SerializedName("artist")
    @Expose
    private Artist artist;
    @SerializedName("tracks")
    @Expose
    private List<Track_> tracks = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeForFrom() {
        return typeForFrom;
    }

    public void setTypeForFrom(String typeForFrom) {
        this.typeForFrom = typeForFrom;
    }

    public List<Title> getTitle() {
        return title;
    }

    public void setTitle(List<Title> title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track_> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track_> tracks) {
        this.tracks = tracks;
    }

}
