package answer_structure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locality {

    @SerializedName("LocalityName")
    @Expose
    private String localityName;
    @SerializedName("Thoroughfare")
    @Expose
    private Thoroughfare thoroughfare;

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }

    public void setThoroughfare(Thoroughfare thoroughfare) {
        this.thoroughfare = thoroughfare;
    }

//    @SerializedName("LocalityName")
//    public String localityName;
//
//    @SerializedName("Thoroughfare")
//    public Thoroughfare thoroughfare = new Thoroughfare();
}
