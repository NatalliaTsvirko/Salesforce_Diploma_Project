package enums;

public enum CalendarType {

    EMAIL("Email"),
    MEETING("Meeting"),
    OTHER("Other"),
    CALL("Call");

    private String text;

    CalendarType(String name) {
        this.text = name;
    }

    public static CalendarType fromString(String text) {
        for (CalendarType b : CalendarType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getName() {
        return this.text;
    }
}
