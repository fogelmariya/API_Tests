package enums;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum YandexAPI {
    GEOCODE_URI("url", "https://geocode-maps.yandex.ru/1.x/?format=json&"),
    FIRST_LOCATION("geocode", "Москва, улица Новый Арбат, дом 24"),
    SECOND_LOCATION("geocode=", "Москва,+Тверская+улица,+дом+7");

    public String key;
    public String value;
}
