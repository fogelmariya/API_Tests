import core.YandexGeocodeAPI;
import core.YandexGeocodeAnswer;
import enums.GeocodeParam;
import enums.YandexAPI;
import org.junit.Assert;
import org.junit.Test;

import static enums.GeocodeParam.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YandexGeocodeAPITest {

    @Test
    public void getPosTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location()
                                .callApi());
        assertThat("wrong coordinates", answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(0).getGeoObject().getPoint().getPos(), equalTo("37.587614 55.753083"));
    }

    @Test
    public void reverseGeocodeLatLongTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(YandexAPI.FIRST_BACK_LOCATION.value)
                                .sco(LATLONG.param)
                                .callApi());
        Assert.assertNotEquals(answer.getResponse().getGeoObjectCollection().getFeatureMember().get(0).getGeoObject()
                .getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry().getCountryName(), "Россия");
    }

    @Test
    public void metroSearchTeatralnayaTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(YandexAPI.FIRST_BACK_LOCATION.value)
                                .kind(METRO.param)
                                .callApi());
        Assert.assertEquals(TEATRALNAYA_METRO.param, answer.getResponse().getGeoObjectCollection()
                .getFeatureMember().get(1).getGeoObject().getName());
    }

    @Test
    public void metroSearchTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(YandexAPI.FIRST_BACK_LOCATION.value)
                                .kind(METRO.param)
                                .callApi());
        Assert.assertEquals(10, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void streetSearchTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(YandexAPI.FIRST_BACK_LOCATION.value)
                                .kind(STREET.param)
                                .callApi());
        Assert.assertEquals(10, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void reverseGeocodeTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(YandexAPI.FIRST_BACK_LOCATION.value)
                                .ll(LL_FIRST_PARAM.param)
                                .spn(SPN_FIRST_PARAM.param)
                                .rspn()
                                .callApi());
        Assert.assertEquals(7, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void ivanovkallspnAnswerSizeTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(IVANOVKA_LOCATION.param)
                                .ll(LL_FIRST_PARAM.param)
                                .spn(SPN_FIRST_PARAM.param)
                                .rspn()
                                .callApi());
        Assert.assertEquals(7, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void ivanovkallspnTest2() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(IVANOVKA_LOCATION.param)
                                .ll(LL_FIRST_PARAM.param)
                                .spn(SPN_FIRST_PARAM.param)
                                .rspn()
                                .callApi());
        Assert.assertEquals(MOSCOW_REGION.param, answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(1).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                .getAdministrativeArea().getAdministrativeAreaName());
    }

    @Test
    public void ivanovkaAllTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location("Ивановка")
                                .callApi());
        Assert.assertEquals("Амурская область", answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(9).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                .getAdministrativeArea().getAdministrativeAreaName());
    }

    @Test
    public void wrongNameOfMoscowTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location("Масква")
                                .callApi());
        Assert.assertEquals("Канада", answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(3).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                .getCountryName());
    }

    @Test
    public void tenthTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location("Масква")
                                .callApi());
        Assert.assertEquals("Канада", answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(3).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                .getCountryName());
    }
}
