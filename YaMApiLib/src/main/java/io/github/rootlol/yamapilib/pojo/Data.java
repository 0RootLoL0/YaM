
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("uid")
    @Expose
    private Integer uid;
    @SerializedName("kind")
    @Expose
    private Integer kind;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("descriptionFormatted")
    @Expose
    private String descriptionFormatted;
    @SerializedName("revision")
    @Expose
    private Integer revision;
    @SerializedName("snapshot")
    @Expose
    private Integer snapshot;
    @SerializedName("trackCount")
    @Expose
    private Integer trackCount;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("collective")
    @Expose
    private Boolean collective;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("isBanner")
    @Expose
    private Boolean isBanner;
    @SerializedName("isPremiere")
    @Expose
    private Boolean isPremiere;
    @SerializedName("idForFrom")
    @Expose
    private String idForFrom;
    @SerializedName("everPlayed")
    @Expose
    private Boolean everPlayed;
    @SerializedName("coverWithoutText")
    @Expose
    private CoverWithoutText coverWithoutText;
    @SerializedName("urlPart")
    @Expose
    private String urlPart;
    @SerializedName("durationMs")
    @Expose
    private Integer durationMs;
    @SerializedName("cover")
    @Expose
    private Cover cover;
    @SerializedName("ogImage")
    @Expose
    private String ogImage;
    @SerializedName("ogTitle")
    @Expose
    private String ogTitle;
    @SerializedName("ogDescription")
    @Expose
    private String ogDescription;
    @SerializedName("tracks")
    @Expose
    private List<Track> tracks = null;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("prerolls")
    @Expose
    private List<Object> prerolls = null;
    @SerializedName("madeFor")
    @Expose
    private MadeFor madeFor;
    @SerializedName("generatedPlaylistType")
    @Expose
    private String generatedPlaylistType;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionFormatted() {
        return descriptionFormatted;
    }

    public void setDescriptionFormatted(String descriptionFormatted) {
        this.descriptionFormatted = descriptionFormatted;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Integer getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Integer snapshot) {
        this.snapshot = snapshot;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getCollective() {
        return collective;
    }

    public void setCollective(Boolean collective) {
        this.collective = collective;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Boolean getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(Boolean isBanner) {
        this.isBanner = isBanner;
    }

    public Boolean getIsPremiere() {
        return isPremiere;
    }

    public void setIsPremiere(Boolean isPremiere) {
        this.isPremiere = isPremiere;
    }

    public String getIdForFrom() {
        return idForFrom;
    }

    public void setIdForFrom(String idForFrom) {
        this.idForFrom = idForFrom;
    }

    public Boolean getEverPlayed() {
        return everPlayed;
    }

    public void setEverPlayed(Boolean everPlayed) {
        this.everPlayed = everPlayed;
    }

    public CoverWithoutText getCoverWithoutText() {
        return coverWithoutText;
    }

    public void setCoverWithoutText(CoverWithoutText coverWithoutText) {
        this.coverWithoutText = coverWithoutText;
    }

    public String getUrlPart() {
        return urlPart;
    }

    public void setUrlPart(String urlPart) {
        this.urlPart = urlPart;
    }

    public Integer getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<Object> getPrerolls() {
        return prerolls;
    }

    public void setPrerolls(List<Object> prerolls) {
        this.prerolls = prerolls;
    }

    public MadeFor getMadeFor() {
        return madeFor;
    }

    public void setMadeFor(MadeFor madeFor) {
        this.madeFor = madeFor;
    }

    public String getGeneratedPlaylistType() {
        return generatedPlaylistType;
    }

    public void setGeneratedPlaylistType(String generatedPlaylistType) {
        this.generatedPlaylistType = generatedPlaylistType;
    }

}
