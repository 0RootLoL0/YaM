
package io.github.rootlol.yamapilib.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("ogImage")
    @Expose
    private String ogImage;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("counts")
    @Expose
    private Counts counts;
    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("ratings")
    @Expose
    private Ratings ratings;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("ticketsAvailable")
    @Expose
    private Boolean ticketsAvailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Boolean getTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTicketsAvailable(Boolean ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

}
