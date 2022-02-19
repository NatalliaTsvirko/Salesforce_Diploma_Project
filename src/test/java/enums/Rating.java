package enums;

public enum Rating {

    HOT("Hot"),
    WARM("Warm"),
    COLD("Cold");

    private String text;

    Rating(String name) {
        this.text = name;
    }

    public static Rating fromString(String text) {
        for (Rating b : Rating.values()) {
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
