package enums;

public enum LeadSource {

    ADVERTISEMENT("Advertisement"),
    CUSTOMER_EVENT("Customer Event"),
    EMPLOYEE_REFERRAL("Employee Referral"),
    GOOGLE_AD_WORDS("Google AdWords"),
    OTHER("Other"),
    PARTNER("Partner"),
    PURCHASED_LIST("Purchased List"),
    TRADE_SHOW("Trade Show"),
    WEBINAR("Webinar"),
    WEBSITE("Website");

    private String text;

    LeadSource(String name) {
        this.text = name;
    }

    public static LeadSource fromString(String text) {
        for (LeadSource b : LeadSource.values()) {
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
