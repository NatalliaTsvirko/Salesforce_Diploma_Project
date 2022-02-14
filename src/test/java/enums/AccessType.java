package enums;

public enum AccessType {

    PUBLIC("Public"),
    PRIVATE("Private"),
    UNLISTED("Unlisted");

    private String text;

    AccessType(String name) {
        this.text = name;
    }

    public static AccessType fromString(String text) {
        for (AccessType b : AccessType.values()) {
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
