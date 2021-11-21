package Model.LSManga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Series {

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("popularity")
    @Expose
    private Integer popularity;
    @SerializedName("averageScore")
    @Expose
    private Integer averageScore;
    @SerializedName("favourites")
    @Expose
    private Integer favourites;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("startDate")
    @Expose
    private StartDate startDate;
    private double priorityComb;

    public Series() {
    }

    public Series(Title title, Integer popularity, Integer averageScore, Integer favourites, String type, List<String> genres, StartDate startDate) {
        super();
        this.title = title;
        this.popularity = popularity;
        this.averageScore = averageScore;
        this.favourites = favourites;
        this.type = type;
        this.genres = genres;
        this.startDate = startDate;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getFavourites() {
        return favourites;
    }

    public void setFavourites(Integer favourites) {
        this.favourites = favourites;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    public double getPriorityComb() {
        return priorityComb;
    }

    public void setPriorityComb(double priorityComb) {
        this.priorityComb = priorityComb;
    }
}
