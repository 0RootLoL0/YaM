
package io.github.rootlol.yamapilib.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CaseForms {

    @SerializedName("nominative")
    @Expose
    private String nominative;
    @SerializedName("genitive")
    @Expose
    private String genitive;
    @SerializedName("dative")
    @Expose
    private String dative;
    @SerializedName("accusative")
    @Expose
    private String accusative;
    @SerializedName("instrumental")
    @Expose
    private String instrumental;
    @SerializedName("prepositional")
    @Expose
    private String prepositional;

    public String getNominative() {
        return nominative;
    }

    public void setNominative(String nominative) {
        this.nominative = nominative;
    }

    public String getGenitive() {
        return genitive;
    }

    public void setGenitive(String genitive) {
        this.genitive = genitive;
    }

    public String getDative() {
        return dative;
    }

    public void setDative(String dative) {
        this.dative = dative;
    }

    public String getAccusative() {
        return accusative;
    }

    public void setAccusative(String accusative) {
        this.accusative = accusative;
    }

    public String getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(String instrumental) {
        this.instrumental = instrumental;
    }

    public String getPrepositional() {
        return prepositional;
    }

    public void setPrepositional(String prepositional) {
        this.prepositional = prepositional;
    }

}
