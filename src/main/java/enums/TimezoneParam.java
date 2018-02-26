package enums;

public enum TimezoneParam {

    FIRST_LOCATION("38.908133,-77.047119"),
    SECOND_LOCATION("39.6034810,-119.6822510"),
    FIRST_TIMESTAMP("1331766000"),
    SECOND_TIMESTAMP("1331161200");

    public String param;

    TimezoneParam(String param) {
        this.param = param;
    }
}
