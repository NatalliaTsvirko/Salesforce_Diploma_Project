package enums;

public enum Salutation {
    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    DR("Dr."),
    PROF("Prof.");

    private String text;

    Salutation(String name) {
        this.text = name;
    }

    public static Salutation fromString(String text) {
        for (Salutation b : Salutation.values()) {
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
