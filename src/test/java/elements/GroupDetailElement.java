package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupDetailElement extends BaseElement {

    private static final By TEXT_DESCRIPTION = By.xpath("//div[contains(@class,'groupDescription')]/span");
    private static final By TEXT_INFORMATION = By.xpath("//div[contains(@data-aura-class,'uiOutputRichText')]/p");

    public GroupDetailElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getTextDescription() {
        return driver.findElement(TEXT_DESCRIPTION).getText();
    }

    public String getTextInformation() {
        return driver.findElement(TEXT_INFORMATION).getText();
    }
}
