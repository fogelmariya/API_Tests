package enums;

public enum GeocodeParam {

    FIRST_LOCATION("Москва, улица Новый Арбат, дом 24"),
    FIRST_COORDINATES("37.587614 55.753083"),
    SECOND_LOCATION("Москва,+Тверская+улица,+дом+7"),
    FIRST_BACK_LOCATION("37.611,55.758"),
    LATLONG("latlong"),
    METRO("metro"),
    TEATRALNAYA_METRO("метро Театральная"),
    STREET("street"),
    LL_FIRST_PARAM("37.618920,55.756994"),
    SPN_FIRST_PARAM("3.552069,2.400552"),
    IVANOVKA_LOCATION("Ивановка"),
    MOSCOW_REGION("Московская область"),
    MOSCOW_WRONG("Масква"),
    CANADA("Канада"),
    AMUR_REGION("Амурская область");

   public String param;


    GeocodeParam(String param) {
        this.param = param;
    }
}
