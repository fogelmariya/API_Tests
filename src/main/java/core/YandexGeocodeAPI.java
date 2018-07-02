package core;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static enums.YandexAPI.FIRST_LOCATION;
import static enums.YandexAPI.GEOCODE_URI;

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
            yandexGeocodeAPI.params.put(FIRST_LOCATION.key, FIRST_LOCATION.value);
            return this;
        }


        public YandexGeocodeAPI.ApiBuilder location(String location) {
            yandexGeocodeAPI.params.put(FIRST_LOCATION.key, location);
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
