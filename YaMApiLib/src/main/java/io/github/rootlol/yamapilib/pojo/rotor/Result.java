
package io.github.rootlol.yamapilib.pojo.rotor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("dashboardId")
    @Expose
    private String dashboardId;
    @SerializedName("stations")
    @Expose
    private List<Station> stations = null;
    @SerializedName("pumpkin")
    @Expose
    private Boolean pumpkin;

    public String getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Boolean getPumpkin() {
        return pumpkin;
    }

    public void setPumpkin(Boolean pumpkin) {
        this.pumpkin = pumpkin;
    }

}
