
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TracksToPlay {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("realId")
    @Expose
    private String realId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("major")
    @Expose
    private Major major;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("availableForPremiumUsers")
    @Expose
    private Boolean availableForPremiumUsers;
    @SerializedName("availableFullWithoutPermission")
    @Expose
    private Boolean availableFullWithoutPermission;
    @SerializedName("durationMs")
    @Expose
    private Integer durationMs;
    @SerializedName("storageDir")
    @Expose
    private String storageDir;
    @SerializedName("fileSize")
    @Expose
    private Integer fileSize;
    @SerializedName("normalization")
    @Expose
    private Normalization normalization;
    @SerializedName("previewDurationMs")
    @Expose
    private Integer previewDurationMs;
    @SerializedName("artists")
    @Expose
    private List<Artist_> artists = null;
    @SerializedName("albums")
    @Expose
    private List<Album_> albums = null;
    @SerializedName("coverUri")
    @Expose
    private String coverUri;
    @SerializedName("ogImage")
    @Expose
    private String ogImage;
    @SerializedName("lyricsAvailable")
    @Expose
    private Boolean lyricsAvailable;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("rememberPosition")
    @Expose
    private Boolean rememberPosition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
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

    public Boolean getAvailableFullWithoutPermission() {
        return availableFullWithoutPermission;
    }

    public void setAvailableFullWithoutPermission(Boolean availableFullWithoutPermission) {
        this.availableFullWithoutPermission = availableFullWithoutPermission;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public String getStorageDir() {
        return storageDir;
    }

    public void setStorageDir(String storageDir) {
        this.storageDir = storageDir;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Normalization getNormalization() {
        return normalization;
    }

    public void setNormalization(Normalization normalization) {
        this.normalization = normalization;
    }

    public Integer getPreviewDurationMs() {
        return previewDurationMs;
    }

    public void setPreviewDurationMs(Integer previewDurationMs) {
        this.previewDurationMs = previewDurationMs;
    }

    public List<Artist_> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist_> artists) {
        this.artists = artists;
    }

    public List<Album_> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album_> albums) {
        this.albums = albums;
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

    public Boolean getLyricsAvailable() {
        return lyricsAvailable;
    }

    public void setLyricsAvailable(Boolean lyricsAvailable) {
        this.lyricsAvailable = lyricsAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRememberPosition() {
        return rememberPosition;
    }

    public void setRememberPosition(Boolean rememberPosition) {
        this.rememberPosition = rememberPosition;
    }

}
