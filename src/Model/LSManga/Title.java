package Model.LSManga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("romaji")
    @Expose
    private String romaji;
    @SerializedName("english")
    @Expose
    private String english;
    @SerializedName("native")
    @Expose
    private String _native;

    public Title() {
    }

    public Title(String romaji, String english, String _native) {
        super();
        this.romaji = romaji;
        this.english = english;
        this._native = _native;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getNative() {
        return _native;
    }

    public void setNative(String _native) {
        this._native = _native;
    }

}
