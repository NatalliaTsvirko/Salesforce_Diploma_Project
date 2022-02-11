package enums;

public enum Industry {

    AGRICULTURE("Agriculture"),
    APPAREL("Apparel"),
    BANKING("Banking"),
    BIOTECHNOLOGY("Biotechnology"),
    CHEMICALS("Chemicals"),
    COMMUNICATIONS("Communications"),
    CONSTRUCTION("Construction"),
    CONSULTING("Consulting"),
    EDUCATION("Education"),
    ELECTRONICS("Electronics"),
    ENERGY("Energy"),
    ENGINEERING("Engineering"),
    ENTERTAINMENT("Entertainment"),
    ENVIRONMENTAL("Environmental"),
    FINANCE("Finance"),
    FOOD_AND_BEVERAGE("Food & Beverage"),
    GOVERNMENT("Government"),
    HEALTHCARE("Healthcare"),
    HOSPITALITY("Hospitality"),
    INSURANCE("Insurance"),
    MACHINERY("Machinery"),
    MANUFACTURING("Manufacturing"),
    MEDIA("Media"),
    NOT_FOR_PROFIT("Not For Profit"),
    OTHER("Other"),
    RECREATION("Recreation"),
    RETAIL("Retail"),
    SHIPPING("Shipping"),
    TECHNOLOGY("Technology"),
    TELECOMMUNICATIONS("Telecommunications"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities");

    private String text;

    Industry(String text) {
        this.text = text;
    }

    public static Industry fromString(String text) {
        for (Industry b : Industry.values()) {
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
