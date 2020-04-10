
package io.github.rootlol.yamapilib.pojo.rotor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language_ {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("possibleValues")
    @Expose
    private List<PossibleValue____> possibleValues = null;

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

    public List<PossibleValue____> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<PossibleValue____> possibleValues) {
        this.possibleValues = possibleValues;
    }

}
