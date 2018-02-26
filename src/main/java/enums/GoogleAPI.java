package enums;


public enum GoogleAPI {

    TIMEZONE_URI("url", "https://maps.googleapis.com/maps/api/timezone/json"),
    KEY("key", "AIzaSyBhyjEd9zMxQUdaRYiL6jHBBkffgmNcYvI"),
    LOCATION("location", null),
    TIMESTAMP("timestamp", null);

    public String type;
    public String value;

    GoogleAPI(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
