package enums;

public enum GeocodeParam {

    LATLONG("latlong"),
    METRO("metro"),
    TEATRALNAYA_METRO("метро Театральная"),
    STREET("street"),
    LL_FIRST_PARAM("37.618920,55.756994"),
    SPN_FIRST_PARAM("3.552069,2.400552"),
    IVANOVKA_LOCATION("Ивановка"),
    MOSCOW_REGION("Московская область");

   public String param;


    GeocodeParam(String param) {
        this.param = param;
    }
}
