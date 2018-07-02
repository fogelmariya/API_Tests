package core;

import answer_structure.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class YandexGeocodeAnswer {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
