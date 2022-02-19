package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Log4j2
public class DropdownCalendarGroups extends BaseElement {

    private static final By TYPE = By.xpath("//a[@class='select']");
    private String optionLocator = "//div[@class='select-options']/ul//a[@title='%s']";

    public DropdownCalendarGroups(WebDriver driver, String label) {
        super(driver, label);
    }

    @Step("Delete leads from list")
    public void selectOptions(String optionName) {
        driver.findElement(TYPE).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }
}
