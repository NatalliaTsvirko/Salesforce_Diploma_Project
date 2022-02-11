package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown extends BaseElement {
    private String dropdownLocator = "//span[text()='%s']/ancestor::div[contains(@class, 'uiInputSelect')]//a[@class= 'select']";
    private String optionLocator = "//div[contains(@class, 'uiMenuList') and contains(@class, 'select')]//a[contains(text(), '%s')]";

    public Dropdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String optionName) {
        driver.findElement(By.xpath(String.format(dropdownLocator, label))).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }

}
