package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarElement extends BaseElement {

    String visibleTextLocator = "//span[text()='%s' and  @class='test-id__field-label']//following::span/span[@class='uiOutputText']";
    String startDateTimeText = "//span[text()='%s' and  @class='test-id__field-label']//following::span/span[@class='uiOutputDateTime']";
    String endDateTimeText = "//span[text()='%s' and  @class='test-id__field-label']//following::span/span[@class='uiOutputDateTime']";
    String typeText = "//span[text()='%s' and  @class='test-id__field-label']//following::span/span";
    String descriptionText = "//span[text()='%s' and  @class='test-id__field-label']//following::span/span[@class='uiOutputTextArea']";

    public CalendarElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getTextSubjectAndLocation() {
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }

    public String getStartDateTimeText() {
        return driver.findElement(By.xpath(String.format(startDateTimeText, label))).getText();
    }

    public String getEndDateTimeText() {
        return driver.findElement(By.xpath(String.format(endDateTimeText, label))).getText();
    }

    public String getTypeText() {
        return driver.findElement(By.xpath(String.format(typeText, label))).getText();
    }

    public String getDescriptionText() {
        return driver.findElement(By.xpath(String.format(descriptionText, label))).getText();
    }
}
