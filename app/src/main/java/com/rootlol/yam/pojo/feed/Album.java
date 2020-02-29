package com.rootlol.yam.pojo.feed;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("artists")
    private List<Artist> mArtists;
    @SerializedName("available")
    private Boolean mAvailable;
    @SerializedName("availableForMobile")
    private Boolean mAvailableForMobile;
    @SerializedName("availableForPremiumUsers")
    private Boolean mAvailableForPremiumUsers;
    @SerializedName("availablePartially")
    private Boolean mAvailablePartially;
    @SerializedName("bests")
    private List<Long> mBests;
    @SerializedName("buy")
    private List<Object> mBuy;
    @SerializedName("coverUri")
    private String mCoverUri;
    @SerializedName("genre")
    private String mGenre;
    @SerializedName("id")
    private Long mId;
    @SerializedName("labels")
    private List<Label> mLabels;
    @SerializedName("ogImage")
    private String mOgImage;
    @SerializedName("recent")
    private Boolean mRecent;
    @SerializedName("releaseDate")
    private String mReleaseDate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("trackCount")
    private Long mTrackCount;
    @SerializedName("trackPosition")
    private TrackPosition mTrackPosition;
    @SerializedName("veryImportant")
    private Boolean mVeryImportant;
    @SerializedName("year")
    private Long mYear;

    public List<Artist> getArtists() {
        return mArtists;
    }

    public void setArtists(List<Artist> artists) {
        mArtists = artists;
    }

    public Boolean getAvailable() {
        return mAvailable;
    }

    public void setAvailable(Boolean available) {
        mAvailable = available;
    }

    public Boolean getAvailableForMobile() {
        return mAvailableForMobile;
    }

    public void setAvailableForMobile(Boolean availableForMobile) {
        mAvailableForMobile = availableForMobile;
    }

    public Boolean getAvailableForPremiumUsers() {
        return mAvailableForPremiumUsers;
    }

    public void setAvailableForPremiumUsers(Boolean availableForPremiumUsers) {
        mAvailableForPremiumUsers = availableForPremiumUsers;
    }

    public Boolean getAvailablePartially() {
        return mAvailablePartially;
    }

    public void setAvailablePartially(Boolean availablePartially) {
        mAvailablePartially = availablePartially;
    }

    public List<Long> getBests() {
        return mBests;
    }

    public void setBests(List<Long> bests) {
        mBests = bests;
    }

    public List<Object> getBuy() {
        return mBuy;
    }

    public void setBuy(List<Object> buy) {
        mBuy = buy;
    }

    public String getCoverUri() {
        return mCoverUri;
    }

    public void setCoverUri(String coverUri) {
        mCoverUri = coverUri;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Label> getLabels() {
        return mLabels;
    }

    public void setLabels(List<Label> labels) {
        mLabels = labels;
    }

    public String getOgImage() {
        return mOgImage;
    }

    public void setOgImage(String ogImage) {
        mOgImage = ogImage;
    }

    public Boolean getRecent() {
        return mRecent;
    }

    public void setRecent(Boolean recent) {
        mRecent = recent;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
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

    public TrackPosition getTrackPosition() {
        return mTrackPosition;
    }

    public void setTrackPosition(TrackPosition trackPosition) {
        mTrackPosition = trackPosition;
    }

    public Boolean getVeryImportant() {
        return mVeryImportant;
    }

    public void setVeryImportant(Boolean veryImportant) {
        mVeryImportant = veryImportant;
    }

    public Long getYear() {
        return mYear;
    }

    public void setYear(Long year) {
        mYear = year;
    }

}