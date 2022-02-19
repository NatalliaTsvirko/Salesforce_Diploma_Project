package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement {
    final String inputElementLocator = "//div[@role='dialog' and @aria-modal='true']//*[text()= '%s']/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String inputName) {
        super(driver, inputName);
    }

    public void write(String text) {
        log.info(String.format("Setting %s into %s input", text, label));
        driver.findElement(By.xpath(String.format(inputElementLocator, label))).sendKeys(text);
    }
}