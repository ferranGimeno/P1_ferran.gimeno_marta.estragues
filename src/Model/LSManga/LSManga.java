package Model.LSManga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LSManga {

    @SerializedName("series")
    @Expose
    private Series[] series = null;

    public Series[] getSeries() {
        return series;
    }

    public void setSeries(Series[] series) {
        this.series = series;
    }

}
