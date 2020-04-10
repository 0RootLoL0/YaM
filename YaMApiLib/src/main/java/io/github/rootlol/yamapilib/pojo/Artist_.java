
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("various")
    @Expose
    private Boolean various;
    @SerializedName("composer")
    @Expose
    private Boolean composer;
    @SerializedName("cover")
    @Expose
    private Cover_ cover;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVarious() {
        return various;
    }

    public void setVarious(Boolean various) {
        this.various = various;
    }

    public Boolean getComposer() {
        return composer;
    }

    public void setComposer(Boolean composer) {
        this.composer = composer;
    }

    public Cover_ getCover() {
        return cover;
    }

    public void setCover(Cover_ cover) {
        this.cover = cover;
    }

    public List<Object> getGenres() {
        return genres;
    }

    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

}
