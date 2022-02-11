package enums;

public enum LeadStatus {

    UNQUALIFIED("Unqualified"),
    NEW("New"),
    WORKING("Working"),
    NURTURING("Nurturing"),
    QUALIFIED("Qualified");

    private String text;

    LeadStatus(String name) {
        this.text = name;
    }

    public static LeadStatus fromString(String text) {
        for (LeadStatus b : LeadStatus.values()) {
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
