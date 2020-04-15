
package io.github.rootlol.yamapilib.pojo.rotor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diversity_ {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("possibleValues")
    @Expose
    private List<PossibleValue___> possibleValues = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PossibleValue___> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<PossibleValue___> possibleValues) {
        this.possibleValues = possibleValues;
    }

}
