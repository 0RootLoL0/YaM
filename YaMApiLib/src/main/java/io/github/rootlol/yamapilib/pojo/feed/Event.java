
package io.github.rootlol.yamapilib.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Event {

    @SerializedName("albums")
    private List<Album> mAlbums;
    @SerializedName("artist")
    private Artist mArtist;
    @SerializedName("id")
    private String mId;
    @SerializedName("title")
    private List<Title> mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("typeForFrom")
    private String mTypeForFrom;

    public List<Album> getAlbums() {
        return mAlbums;
    }

    public void setAlbums(List<Album> albums) {
        mAlbums = albums;
    }

    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist artist) {
        mArtist = artist;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Title> getTitle() {
        return mTitle;
    }

    public void setTitle(List<Title> title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTypeForFrom() {
        return mTypeForFrom;
    }

    public void setTypeForFrom(String typeForFrom) {
        mTypeForFrom = typeForFrom;
    }

}
