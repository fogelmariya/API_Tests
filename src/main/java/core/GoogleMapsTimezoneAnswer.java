package core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class GoogleMapsTimezoneAnswer {

    @SerializedName("dstOffset")
    @Expose
    public Integer dstOffset;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("rawOffset")
    @Expose
    public Integer rawOffset;
    @SerializedName("timeZoneId")
    @Expose
    public String timeZoneId;
    @SerializedName("timeZoneName")
    @Expose
    public String timeZoneName;
    @SerializedName("error message")
    @Expose
    public String errorMessage;

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GoogleMapsTimezoneAnswer) == false) {
            return false;
        }
        GoogleMapsTimezoneAnswer rhs = ((GoogleMapsTimezoneAnswer) other);
        return new EqualsBuilder().append(dstOffset, rhs.dstOffset).append(rawOffset, rhs.rawOffset)
                .append(errorMessage, rhs.errorMessage).append(timeZoneId, rhs.timeZoneId).
                        append(timeZoneName, rhs.timeZoneName).append(status, rhs.status).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dstOffset).append(rawOffset).append(errorMessage).append(timeZoneId)
                .append(timeZoneId).append(status).toHashCode();

    }
}
