
package io.github.rootlol.yamapilib.pojo.rotor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("possibleValues")
    @Expose
    private List<PossibleValue> possibleValues = null;

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

    public List<PossibleValue> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<PossibleValue> possibleValues) {
        this.possibleValues = possibleValues;
    }

}
