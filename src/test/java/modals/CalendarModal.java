package modals;

import elements.Dropdown;
import elements.DropdownCalendarGroups;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class CalendarModal extends BaseModal {

    private final static By INPUT_LOCATION = By.xpath("//input[@class=' input']");
    private final static By TIME_FIELD = By.xpath("//legend[text()='Start']/ancestor::lightning-datetimepicker//lightning-timepicker//input");
    private String optionLocator = "//span[@title='%s']";

    public CalendarModal(WebDriver driver) {
        super(driver);
    }

    public CalendarModal fillForm(Calendar calendar) {

        log.info(String.format("Filling form with account info: %s", calendar));

        if (calendar.getSubject() != null) {
            new Dropdown(driver, "Subject").selectOption(calendar.getSubject().getName());
        }

        if (calendar.getLocation() != null) {
            driver.findElement(INPUT_LOCATION).sendKeys(calendar.getLocation());
        }

        if (calendar.getCalendarType() != null) {
            new DropdownCalendarGroups(driver,"Type").selectOptions(calendar.getCalendarType().getName());
        }

        if (calendar.getDescription() != null) {
            new TextArea(driver, "Description").write(calendar.getDescription());
        }
        return this;
    }

    public void setEventTime(String optionTime) {
        driver.findElement(TIME_FIELD).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionTime)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }

}



