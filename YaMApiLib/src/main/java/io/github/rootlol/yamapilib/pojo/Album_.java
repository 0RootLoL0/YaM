
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("contentWarning")
    @Expose
    private String contentWarning;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("coverUri")
    @Expose
    private String coverUri;
    @SerializedName("ogImage")
    @Expose
    private String ogImage;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("buy")
    @Expose
    private List<Object> buy = null;
    @SerializedName("trackCount")
    @Expose
    private Integer trackCount;
    @SerializedName("recent")
    @Expose
    private Boolean recent;
    @SerializedName("veryImportant")
    @Expose
    private Boolean veryImportant;
    @SerializedName("artists")
    @Expose
    private List<Artist_> artists = null;
    @SerializedName("labels")
    @Expose
    private List<Label> labels = null;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("availableForPremiumUsers")
    @Expose
    private Boolean availableForPremiumUsers;
    @SerializedName("availableForMobile")
    @Expose
    private Boolean availableForMobile;
    @SerializedName("availablePartially")
    @Expose
    private Boolean availablePartially;
    @SerializedName("bests")
    @Expose
    private List<Integer> bests = null;
    @SerializedName("trackPosition")
    @Expose
    private TrackPosition trackPosition;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentWarning() {
        return contentWarning;
    }

    public void setContentWarning(String contentWarning) {
        this.contentWarning = contentWarning;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverUri() {
        return coverUri;
    }

    public void setCoverUri(String coverUri) {
        this.coverUri = coverUri;
    }

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Object> getBuy() {
        return buy;
    }

    public void setBuy(List<Object> buy) {
        this.buy = buy;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Boolean getRecent() {
        return recent;
    }

    public void setRecent(Boolean recent) {
        this.recent = recent;
    }

    public Boolean getVeryImportant() {
        return veryImportant;
    }

    public void setVeryImportant(Boolean veryImportant) {
        this.veryImportant = veryImportant;
    }

    public List<Artist_> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist_> artists) {
        this.artists = artists;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailableForPremiumUsers() {
        return availableForPremiumUsers;
    }

    public void setAvailableForPremiumUsers(Boolean availableForPremiumUsers) {
        this.availableForPremiumUsers = availableForPremiumUsers;
    }

    public Boolean getAvailableForMobile() {
        return availableForMobile;
    }

    public void setAvailableForMobile(Boolean availableForMobile) {
        this.availableForMobile = availableForMobile;
    }

    public Boolean getAvailablePartially() {
        return availablePartially;
    }

    public void setAvailablePartially(Boolean availablePartially) {
        this.availablePartially = availablePartially;
    }

    public List<Integer> getBests() {
        return bests;
    }

    public void setBests(List<Integer> bests) {
        this.bests = bests;
    }

    public TrackPosition getTrackPosition() {
        return trackPosition;
    }

    public void setTrackPosition(TrackPosition trackPosition) {
        this.trackPosition = trackPosition;
    }

}
