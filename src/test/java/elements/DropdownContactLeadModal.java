package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownContactLeadModal extends  BaseElement{
    private String dropdownLocator = "//label[text()='%s']";
    private String optionLocator = "//lightning-base-combobox-item[@data-value='%s']";

    public DropdownContactLeadModal(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String optionName) {
        driver.findElement(By.xpath(String.format(dropdownLocator, label))).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }
}
