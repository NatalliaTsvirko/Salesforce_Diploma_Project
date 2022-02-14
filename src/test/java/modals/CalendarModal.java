package modals;

import elements.Dropdown;
import elements.DropdownCalendarGroups;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarModal extends BaseModal {

    private final static By INPUT_LOCATION = By.xpath("//input[@class=' input']");

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

}



