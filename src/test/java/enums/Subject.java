package enums;

public enum Subject {
    CALL("Call"),
    EMAIL("Email"),
    MEETING("Meeting"),
    SEND_LETTER_QUOTE("Send Letter/Quote"),
    PROF("Other");

    private String text;

    Subject(String name) {
        this.text = name;
    }

    public static Subject fromString(String text) {
        for (Subject b : Subject.values()) {
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
