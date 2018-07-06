package enums;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum YandexAPI {
    GEOCODE_URI("url", "https://geocode-maps.yandex.ru/1.x/?format=json&"),
    FIRST_LOCATION("geocode", "Москва, улица Новый Арбат, дом 24"),
    SECOND_LOCATION("geocode", "Москва,+Тверская+улица,+дом+7"),
    FIRST_BACK_LOCATION("geocode", "37.611,55.758"),
    SCO("sco", "latlong"),
    LL("ll", "37.618920,55.756994"),
    SPN("spn", "0.552069,0.400552"),
    RSPN("rspn", "1"),
    KIND("kind", "house");

    public String key;
    public String value;
}
