import core.YandexGeocodeAPI;
import core.YandexGeocodeAnswer;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YandexGeocodeAPITest {

    @Test
    public void firstTest(){
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location()
                                .callApi());
        assertThat("wrong coordinates", answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(0).getGeoObject().getPoint().getPos(), equalTo("37.587614 55.753083"));
    }
}
