
package io.github.rootlol.yamapilib.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Artist {

    @SerializedName("available")
    private Boolean mAvailable;
    @SerializedName("composer")
    private Boolean mComposer;
    @SerializedName("counts")
    private Counts mCounts;
    @SerializedName("cover")
    private Cover mCover;
    @SerializedName("genres")
    private List<String> mGenres;
    @SerializedName("id")
    private String mId;
    @SerializedName("links")
    private List<Object> mLinks;
    @SerializedName("name")
    private String mName;
    @SerializedName("ogImage")
    private String mOgImage;
    @SerializedName("ratings")
    private Ratings mRatings;
    @SerializedName("ticketsAvailable")
    private Boolean mTicketsAvailable;
    @SerializedName("various")
    private Boolean mVarious;

    public Boolean getAvailable() {
        return mAvailable;
    }

    public void setAvailable(Boolean available) {
        mAvailable = available;
    }

    public Boolean getComposer() {
        return mComposer;
    }

    public void setComposer(Boolean composer) {
        mComposer = composer;
    }

    public Counts getCounts() {
        return mCounts;
    }

    public void setCounts(Counts counts) {
        mCounts = counts;
    }

    public Cover getCover() {
        return mCover;
    }

    public void setCover(Cover cover) {
        mCover = cover;
    }

    public List<String> getGenres() {
        return mGenres;
    }

    public void setGenres(List<String> genres) {
        mGenres = genres;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Object> getLinks() {
        return mLinks;
    }

    public void setLinks(List<Object> links) {
        mLinks = links;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOgImage() {
        return mOgImage;
    }

    public void setOgImage(String ogImage) {
        mOgImage = ogImage;
    }

    public Ratings getRatings() {
        return mRatings;
    }

    public void setRatings(Ratings ratings) {
        mRatings = ratings;
    }

    public Boolean getTicketsAvailable() {
        return mTicketsAvailable;
    }

    public void setTicketsAvailable(Boolean ticketsAvailable) {
        mTicketsAvailable = ticketsAvailable;
    }

    public Boolean getVarious() {
        return mVarious;
    }

    public void setVarious(Boolean various) {
        mVarious = various;
    }

}
