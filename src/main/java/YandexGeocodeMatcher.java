import core.YandexGeocodeAnswer;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class YandexGeocodeMatcher extends TypeSafeMatcher {

    @Override
    protected boolean matchesSafely(Object o) {
        return false;
    }

    @Override
    public void describeTo(Description description) {

    }

    boolean matchesSize(YandexGeocodeAnswer yandexGeocodeAnswer, int size){
        return yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().size() == size;
    }

    boolean matchesCountry(YandexGeocodeAnswer yandexGeocodeAnswer, String country){
        boolean answer = false;
        int size = yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().size();
        for (int i = 0; i < size; i++) {
            if (yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().get(i).getGeoObject()
                    .getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry().getCountryName().equals(country))
                answer = true;
        }
        return answer;
    }

    boolean matchesName(YandexGeocodeAnswer yandexGeocodeAnswer, String name){
        int size = yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().size();
        for (int i = 0; i < size; i++) {
            if (yandexGeocodeAnswer.getResponse().getGeoObjectCollection()
                    .getFeatureMember().get(i).getGeoObject().getName().equals(name))
                return true;
        }
        return false;
    }

    boolean matchesPos(YandexGeocodeAnswer yandexGeocodeAnswer, String pos){
        int size = yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().size();
        for (int i = 0; i < size; i++) {
            if (yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember()
                    .get(i).getGeoObject().getPoint().getPos().equals(pos))
                return true;
        }
        return false;
    }

    boolean matchesAdministrativeArea(YandexGeocodeAnswer yandexGeocodeAnswer, String administrativeArea){
        int size = yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember().size();
        for (int i = 1; i < size; i++) {
            if (yandexGeocodeAnswer.getResponse().getGeoObjectCollection().getFeatureMember()
                    .get(i).getGeoObject().getMetaDataProperty().getGeocoderMetaData().getAddressDetails().getCountry()
                    .getAdministrativeArea().getAdministrativeAreaName().equals(administrativeArea))
                return true;
        }
        return false;
    }
}
