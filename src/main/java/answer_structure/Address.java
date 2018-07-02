package answer_structure;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Address {
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("formatted")
    @Expose
    private String formatted;
    @SerializedName("Components")
    @Expose
    private List<Component> components = null;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
