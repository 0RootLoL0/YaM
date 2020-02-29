
package com.rootlol.yam.pojo.usersplaylists;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("albumId")
    private Long mAlbumId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("timestamp")
    private String mTimestamp;

    public Long getAlbumId() {
        return mAlbumId;
    }

    public void setAlbumId(Long albumId) {
        mAlbumId = albumId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

}
