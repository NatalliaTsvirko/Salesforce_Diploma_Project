package enums;

public enum AccountType {
    ANALYST("Analyst"),
    COMPETITOR("Competitor"),
    CUSTOMER("Customer"),
    INTEGRATOR("Integrator"),
    INVESTOR("Investor"),
    PARTNER("Partner"),
    PRESS("Press"),
    PROSPECT("Prospect"),
    RESELLER("Reseller"),
    OTHER("Other");

    private String text;

    AccountType(String name) {
        this.text = name;
    }

    public static AccountType fromString(String text) {
        for (AccountType b : AccountType.values()) {
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