import core.YandexGeocodeAPI;
import core.YandexGeocodeAnswer;
import org.junit.Assert;
import org.junit.Test;

import static enums.GeocodeParam.*;

public class YandexGeocodeAPITest {

    private YandexGeocodeMatcher yandexGeocodeMatcher = new YandexGeocodeMatcher();

    @Test
    public void getPosTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location()
                                .callApi());
        Assert.assertTrue("wrong position", yandexGeocodeMatcher.matchesPos(answer, FIRST_COORDINATES.param));
//        assertThat("wrong coordinates", answer.getResponse().getGeoObjectCollection().getFeatureMember()
//                .get(0).getGeoObject().getPoint().getPos(), equalTo(FIRST_COORDINATES.param));
    }

    @Test
    public void reverseGeocodeLatLongTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(FIRST_BACK_LOCATION.param)
                                .sco(LATLONG.param)
                                .callApi());
        // Assert.assertThat(answer(Matchers.allOf(Matchers.containsString("Россия"))));
//        Assert.assertNotEquals("Россия", answer.getResponse().getGeoObjectCollection().getFeatureMember().get(0).getGeoObject()
//                .getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry().getCountryName());
        Assert.assertTrue("wrong reverse geocode", !yandexGeocodeMatcher.matchesCountry(answer, "Россия"));
    }

    @Test
    public void metroSearchTeatralnayaTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(FIRST_BACK_LOCATION.param)
                                .kind(METRO.param)
                                .callApi());

        Assert.assertTrue("wrong find metro", yandexGeocodeMatcher.matchesName(answer, TEATRALNAYA_METRO.param));
//        Assert.assertEquals(TEATRALNAYA_METRO.param, answer.getResponse().getGeoObjectCollection()
//                .getFeatureMember().get(1).getGeoObject().getName());
    }

    @Test
    public void metroSearchTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(FIRST_BACK_LOCATION.param)
                                .kind(METRO.param)
                                .callApi());
        Assert.assertTrue("wrong size of answers", yandexGeocodeMatcher.matchesSize(answer, 10));
        //Assert.assertEquals(10, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void streetSearchTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(FIRST_BACK_LOCATION.param)
                                .kind(STREET.param)
                                .callApi());
        Assert.assertTrue("wrong size of answers", yandexGeocodeMatcher.matchesSize(answer, 10));
       // Assert.assertEquals(10, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
    }

    @Test
    public void reverseGeocodeTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(FIRST_BACK_LOCATION.param)
                                .ll(LL_FIRST_PARAM.param)
                                .spn(SPN_FIRST_PARAM.param)
                                .rspn()
                                .callApi());
        Assert.assertTrue("wrong size of answers", yandexGeocodeMatcher.matchesSize(answer, 7));
       // Assert.assertEquals(7, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
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
        Assert.assertTrue("wrong size of answers",yandexGeocodeMatcher.matchesSize(answer, 7));
       // Assert.assertEquals(7, answer.getResponse().getGeoObjectCollection().getFeatureMember().size());
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
        Assert.assertTrue(yandexGeocodeMatcher.matchesAdministrativeArea(answer, MOSCOW_REGION.param));
        Assert.assertFalse(yandexGeocodeMatcher.matchesAdministrativeArea(answer, AMUR_REGION.param));
//        Assert.assertEquals(MOSCOW_REGION.param, answer.getResponse().getGeoObjectCollection().getFeatureMember()
//                .get(1).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
//                .getAdministrativeArea().getAdministrativeAreaName());
    }

    @Test
    public void ivanovkaAllTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(IVANOVKA_LOCATION.param)
                                .callApi());
        Assert.assertTrue(yandexGeocodeMatcher.matchesAdministrativeArea(answer, AMUR_REGION.param));
        Assert.assertEquals(AMUR_REGION.param, answer.getResponse().getGeoObjectCollection().getFeatureMember()
                .get(9).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                .getAdministrativeArea().getAdministrativeAreaName());
    }

    @Test
    public void wrongNameOfMoscowTest() {
        YandexGeocodeAnswer answer =
                YandexGeocodeAPI.getYandexSpellerAnswers(
                        YandexGeocodeAPI.with()
                                .location(MOSCOW_WRONG.param)
                                .callApi());
        Assert.assertTrue(yandexGeocodeMatcher.matchesCountry(answer, CANADA.param));
//        Assert.assertEquals(CANADA.param, answer.getResponse().getGeoObjectCollection().getFeatureMember()
//                .get(3).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
//                .getCountryName());
    }
}
