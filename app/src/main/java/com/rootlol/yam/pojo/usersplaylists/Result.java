
package com.rootlol.yam.pojo.usersplaylists;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.rootlol.yam.App;
import com.rootlol.yam.adapter.track.factory.TrackVHFactory;
import com.rootlol.yam.adapter.track.interfaces.TrackInterface;
import com.rootlol.yam.nadapter.track.TrackAdapter;
import com.rootlol.yam.nadapter.track.TrackListInterface;
import com.rootlol.yam.tools.ImageTool;

import java.util.List;

public class Result {

    @SerializedName("available")
    private Boolean mAvailable;
    @SerializedName("collective")
    private Boolean mCollective;
    @SerializedName("cover")
    private Cover mCover;
    @SerializedName("created")
    private String mCreated;
    @SerializedName("durationMs")
    private Long mDurationMs;
    @SerializedName("isBanner")
    private Boolean mIsBanner;
    @SerializedName("isPremiere")
    private Boolean mIsPremiere;
    @SerializedName("kind")
    private Long mKind;
    @SerializedName("modified")
    private String mModified;
    @SerializedName("ogImage")
    private String mOgImage;
    @SerializedName("owner")
    private Owner mOwner;
    @SerializedName("prerolls")
    private List<Object> mPrerolls;
    @SerializedName("revision")
    private Long mRevision;
    @SerializedName("snapshot")
    private Long mSnapshot;
    @SerializedName("tags")
    private List<Object> mTags;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("trackCount")
    private Long mTrackCount;
    @SerializedName("tracks")
    private List<Track> mTracks;
    @SerializedName("uid")
    private Long mUid;
    @SerializedName("visibility")
    private String mVisibility;

    public Boolean getAvailable() {
        return mAvailable;
    }

    public void setAvailable(Boolean available) {
        mAvailable = available;
    }

    public Boolean getCollective() {
        return mCollective;
    }

    public void setCollective(Boolean collective) {
        mCollective = collective;
    }

    public Cover getCover() {
        return mCover;
    }

    public void setCover(Cover cover) {
        mCover = cover;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        mCreated = created;
    }

    public Long getDurationMs() {
        return mDurationMs;
    }

    public void setDurationMs(Long durationMs) {
        mDurationMs = durationMs;
    }

    public Boolean getIsBanner() {
        return mIsBanner;
    }

    public void setIsBanner(Boolean isBanner) {
        mIsBanner = isBanner;
    }

    public Boolean getIsPremiere() {
        return mIsPremiere;
    }

    public void setIsPremiere(Boolean isPremiere) {
        mIsPremiere = isPremiere;
    }

    public Long getKind() {
        return mKind;
    }

    public void setKind(Long kind) {
        mKind = kind;
    }

    public String getModified() {
        return mModified;
    }

    public void setModified(String modified) {
        mModified = modified;
    }

    public String getOgImage() {
        return mOgImage;
    }

    public void setOgImage(String ogImage) {
        mOgImage = ogImage;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public List<Object> getPrerolls() {
        return mPrerolls;
    }

    public void setPrerolls(List<Object> prerolls) {
        mPrerolls = prerolls;
    }

    public Long getRevision() {
        return mRevision;
    }

    public void setRevision(Long revision) {
        mRevision = revision;
    }

    public Long getSnapshot() {
        return mSnapshot;
    }

    public void setSnapshot(Long snapshot) {
        mSnapshot = snapshot;
    }

    public List<Object> getTags() {
        return mTags;
    }

    public void setTags(List<Object> tags) {
        mTags = tags;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getTrackCount() {
        return mTrackCount;
    }

    public void setTrackCount(Long trackCount) {
        mTrackCount = trackCount;
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

    public String getVisibility() {
        return mVisibility;
    }

    public void setVisibility(String visibility) {
        mVisibility = visibility;
    }

}
