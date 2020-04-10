
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdParams {

    @SerializedName("partnerId")
    @Expose
    private String partnerId;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("pageRef")
    @Expose
    private String pageRef;
    @SerializedName("targetRef")
    @Expose
    private String targetRef;
    @SerializedName("otherParams")
    @Expose
    private String otherParams;
    @SerializedName("adVolume")
    @Expose
    private Integer adVolume;
    @SerializedName("genreId")
    @Expose
    private Integer genreId;
    @SerializedName("genreName")
    @Expose
    private String genreName;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPageRef() {
        return pageRef;
    }

    public void setPageRef(String pageRef) {
        this.pageRef = pageRef;
    }

    public String getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(String targetRef) {
        this.targetRef = targetRef;
    }

    public String getOtherParams() {
        return otherParams;
    }

    public void setOtherParams(String otherParams) {
        this.otherParams = otherParams;
    }

    public Integer getAdVolume() {
        return adVolume;
    }

    public void setAdVolume(Integer adVolume) {
        this.adVolume = adVolume;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

}
