
package io.github.rootlol.yamapilib.pojo.rotor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station_ {

    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("mtsIcon")
    @Expose
    private MtsIcon mtsIcon;
    @SerializedName("fullImageUrl")
    @Expose
    private String fullImageUrl;
    @SerializedName("geocellIcon")
    @Expose
    private GeocellIcon geocellIcon;
    @SerializedName("idForFrom")
    @Expose
    private String idForFrom;
    @SerializedName("restrictions")
    @Expose
    private Restrictions restrictions;
    @SerializedName("restrictions2")
    @Expose
    private Restrictions2 restrictions2;
    @SerializedName("mtsFullImageUrl")
    @Expose
    private String mtsFullImageUrl;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public MtsIcon getMtsIcon() {
        return mtsIcon;
    }

    public void setMtsIcon(MtsIcon mtsIcon) {
        this.mtsIcon = mtsIcon;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

    public GeocellIcon getGeocellIcon() {
        return geocellIcon;
    }

    public void setGeocellIcon(GeocellIcon geocellIcon) {
        this.geocellIcon = geocellIcon;
    }

    public String getIdForFrom() {
        return idForFrom;
    }

    public void setIdForFrom(String idForFrom) {
        this.idForFrom = idForFrom;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public Restrictions2 getRestrictions2() {
        return restrictions2;
    }

    public void setRestrictions2(Restrictions2 restrictions2) {
        this.restrictions2 = restrictions2;
    }

    public String getMtsFullImageUrl() {
        return mtsFullImageUrl;
    }

    public void setMtsFullImageUrl(String mtsFullImageUrl) {
        this.mtsFullImageUrl = mtsFullImageUrl;
    }

}
