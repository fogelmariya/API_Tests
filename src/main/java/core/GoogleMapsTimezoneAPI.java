package core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import enums.GoogleAPI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Random;

import static enums.GoogleAPI.*;
import static enums.TimezoneParam.FIRST_LOCATION;
import static enums.TimezoneParam.FIRST_TIMESTAMP;
import static org.hamcrest.Matchers.lessThan;


public class GoogleMapsTimezoneAPI {

    private GoogleMapsTimezoneAPI(){

    }

    private HashMap<String, String> params = new HashMap<String, String>();

    public static class ApiBuilder {
        GoogleMapsTimezoneAPI timezoneApi;

        private ApiBuilder(GoogleMapsTimezoneAPI gcApi) {
            timezoneApi = gcApi;
        }

        public  ApiBuilder location(){
            timezoneApi.params.put(LOCATION.type, FIRST_LOCATION.param);
            return this;
        }

        public  ApiBuilder timestamp(){
            timezoneApi.params.put(TIMESTAMP.type, FIRST_TIMESTAMP.param);
            return this;
        }

        public  ApiBuilder location(String location){
            timezoneApi.params.put(LOCATION.type, location);
            return this;
        }

        public  ApiBuilder timestamp(String timestamp){
            timezoneApi.params.put(TIMESTAMP.type, timestamp);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(timezoneApi.params)
                    .log().all()
                    .get(TIMEZONE_URI.value).prettyPeek();
        }

        public RequestSpecification prepareApi() {
            return RestAssured.with()
                    .queryParams(timezoneApi.params)
                    .and().auth().basic(KEY.type, KEY.value)
                    .log().all();
        }
    }

    public static ApiBuilder with() {
        GoogleMapsTimezoneAPI api = new GoogleMapsTimezoneAPI();
        return new ApiBuilder(api);
    }

    public static GoogleMapsTimezoneAnswer getYandexSpellerAnswers(Response response){
        return new Gson().fromJson( response.asString().trim(), new TypeToken<GoogleMapsTimezoneAnswer>() {}.getType());
    }


    //set base request and response specifications tu use in tests
    public static ResponseSpecification successResponse(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration(){
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .addHeader("custom header2", "header2.value")
                .addQueryParam("requestID", new Random().nextLong())
                .setBaseUri(TIMEZONE_URI.value)
                .build();
    }
}
