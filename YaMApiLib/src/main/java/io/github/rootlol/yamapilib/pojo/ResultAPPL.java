
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultAPPL {

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
    @SerializedName("durationMs")
    @Expose
    private Integer durationMs;
    @SerializedName("cover")
    @Expose
    private Cover cover;
    @SerializedName("ogImage")
    @Expose
    private String ogImage;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("prerolls")
    @Expose
    private List<Object> prerolls = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("descriptionFormatted")
    @Expose
    private String descriptionFormatted;

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

}
