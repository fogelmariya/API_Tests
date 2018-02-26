import core.GoogleMapsTimezoneAPI;
import core.GoogleMapsTimezoneAnswer;
import enums.GoogleAPI;
import enums.TimezoneParam;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import static enums.GoogleAPI.KEY;
import static enums.GoogleAPI.TIMEZONE_URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GoogleTimezoneAPITest {

    @Test
    public void simpleAPITest() {
        RestAssured
                .given()
                .queryParam(GoogleAPI.LOCATION.type, TimezoneParam.FIRST_LOCATION.param)
                .and().auth().basic(KEY.type, KEY.value)
                .accept(ContentType.JSON)
                .log().everything()
                .when()
                .get(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().contentType(ContentType.JSON)
                .assertThat().statusCode(HttpStatus.SC_OK)
                .assertThat().body(Matchers.containsString("timeZoneId"));
    }

    @Test
    public void useBasicCallApi() {
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .callApi()
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void useBasicRequests() {
        //get
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .get(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);

        //post
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .post(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);

        //delete
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .delete(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);

        //head
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .head(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);

        //options
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .options(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);

        //put
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .put(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);

        //patch
        GoogleMapsTimezoneAPI
                .with()
                .location()
                .timestamp()
                .prepareApi()
                .patch(TIMEZONE_URI.value)
                .prettyPeek()
                .then()
                .assertThat().statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    @Test
    public void firstTest(){
        GoogleMapsTimezoneAnswer answer =
                GoogleMapsTimezoneAPI.getYandexSpellerAnswers(
                        GoogleMapsTimezoneAPI.with()
                                .location()
                                .timestamp()
                                .callApi());
        assertThat("wrong Timezone", answer.timeZoneId, equalTo("America/New_York"));
    }

    @Test
    public void secondTest(){
        GoogleMapsTimezoneAnswer answer =
                GoogleMapsTimezoneAPI.getYandexSpellerAnswers(
                        GoogleMapsTimezoneAPI.with()
                                .location(TimezoneParam.SECOND_LOCATION.param)
                                .timestamp(TimezoneParam.SECOND_TIMESTAMP.param)
                                .callApi());
        assertThat("wrong Timezone", answer.timeZoneId, equalTo("America/Los_Angeles"));
    }
}
