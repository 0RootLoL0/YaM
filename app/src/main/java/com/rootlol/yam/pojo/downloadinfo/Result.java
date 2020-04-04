
package com.rootlol.yam.pojo.downloadinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("codec")
    @Expose
    private String codec;
    @SerializedName("bitrateInKbps")
    @Expose
    private Integer bitrateInKbps;
    @SerializedName("gain")
    @Expose
    private Boolean gain;
    @SerializedName("preview")
    @Expose
    private Boolean preview;
    @SerializedName("downloadInfoUrl")
    @Expose
    private String downloadInfoUrl;
    @SerializedName("direct")
    @Expose
    private Boolean direct;

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getBitrateInKbps() {
        return bitrateInKbps;
    }

    public void setBitrateInKbps(Integer bitrateInKbps) {
        this.bitrateInKbps = bitrateInKbps;
    }

    public Boolean getGain() {
        return gain;
    }

    public void setGain(Boolean gain) {
        this.gain = gain;
    }

    public Boolean getPreview() {
        return preview;
    }

    public void setPreview(Boolean preview) {
        this.preview = preview;
    }

    public String getDownloadInfoUrl() {
        return downloadInfoUrl;
    }

    public void setDownloadInfoUrl(String downloadInfoUrl) {
        this.downloadInfoUrl = downloadInfoUrl;
    }

    public Boolean getDirect() {
        return direct;
    }

    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

}
