package core;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static enums.GeocodeParam.FIRST_LOCATION;
import static enums.YandexAPI.*;

public class YandexGeocodeAPI {

    private YandexGeocodeAPI() {

    }

    private HashMap<String, String> params = new HashMap<String, String>();

    public static class ApiBuilder {
        YandexGeocodeAPI yandexGeocodeAPI;

        private ApiBuilder(YandexGeocodeAPI gcApi) {
            yandexGeocodeAPI = gcApi;
        }

        public YandexGeocodeAPI.ApiBuilder location() {
            yandexGeocodeAPI.params.put(GEOCODE.key, FIRST_LOCATION.param);
            return this;
        }


        public YandexGeocodeAPI.ApiBuilder location(String location) {
            yandexGeocodeAPI.params.put(GEOCODE.key, location);
            return this;
        }

        public YandexGeocodeAPI.ApiBuilder sco(String scoValue) {
            yandexGeocodeAPI.params.put(SCO.key, scoValue);
            return this;
        }

        public YandexGeocodeAPI.ApiBuilder kind(String kindValue) {
            yandexGeocodeAPI.params.put(KIND.key, kindValue);
            return this;
        }

        public YandexGeocodeAPI.ApiBuilder ll(String llValue) {
            yandexGeocodeAPI.params.put(LL.key, llValue);
            return this;
        }

        public YandexGeocodeAPI.ApiBuilder spn(String spnValue) {
            yandexGeocodeAPI.params.put(SPN.key, spnValue);
            return this;
        }

        public YandexGeocodeAPI.ApiBuilder rspn() {
            yandexGeocodeAPI.params.put(RSPN.key, RSPN.value);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(yandexGeocodeAPI.params)
                    .log().all()
                    .get(GEOCODE_URI.value).prettyPeek();
        }

        public RequestSpecification prepareApi() {
            return RestAssured.with()
                    .queryParams(yandexGeocodeAPI.params)
                    .and()
                    .log().all();
        }
    }

    public static YandexGeocodeAPI.ApiBuilder with() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        YandexGeocodeAPI api = new YandexGeocodeAPI();
        return new ApiBuilder(api);
    }

    public static YandexGeocodeAnswer getYandexSpellerAnswers(Response response) {
        return new Gson().fromJson(response.asString().trim(), YandexGeocodeAnswer.class);
    }
}
