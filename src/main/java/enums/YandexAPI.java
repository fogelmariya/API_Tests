package enums;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum YandexAPI {
    GEOCODE_URI("url", "https://geocode-maps.yandex.ru/1.x/?format=json&"),
    SCO("sco", "latlong"),
    LL("ll", "37.618920,55.756994"),
    SPN("spn", "0.552069,0.400552"),
    GEOCODE("geocode", null),
    RSPN("rspn", "1"),
    KIND("kind", "house");

    public String key;
    public String value;
}
