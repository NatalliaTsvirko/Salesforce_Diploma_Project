package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea extends BaseElement {

    final String textAreaElementLocator = "//div[@role='dialog' and @aria-modal='true']//*[text()= '%s']/ancestor::div[contains(@class, 'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        log.info(String.format("Setting %s into %s input", text, label));
        driver.findElement(By
                .xpath(String.format(textAreaElementLocator, label))).sendKeys(text);
    }

}
