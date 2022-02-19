package modals;

import elements.Dropdown;
import elements.DropdownCalendarGroups;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class CalendarModal extends BaseModal {

    private final static By INPUT_LOCATION = By.xpath("//input[@class=' input']");
    private final static By TIME_FIELD_START = By.xpath("//legend[text()='Start']/ancestor::lightning-datetimepicker//lightning-timepicker//input");
    private final static By DATE_FIELD_START = By.xpath("//legend[text()='Start']/ancestor::lightning-datetimepicker//lightning-datepicker//input");
    private String optionTimeLocator = "//span[@title='%s']";

    public CalendarModal(WebDriver driver) {
        super(driver);
    }

    public CalendarModal fillForm(Calendar calendar) {

        log.info(String.format("Filling form with calendar info: %s", calendar));

        if (calendar.getSubject() != null) {
            new Dropdown(driver, "Subject").selectOption(calendar.getSubject().getName());
        }

        if (calendar.getLocation() != null) {
            driver.findElement(INPUT_LOCATION).sendKeys(calendar.getLocation());
        }

        if (calendar.getCalendarType() != null) {
            new DropdownCalendarGroups(driver, "Type").selectOptions(calendar.getCalendarType().getName());
        }

        if (calendar.getDescription() != null) {
            new TextArea(driver, "Description").write(calendar.getDescription());
        }
        return this;
    }

    @Step("Set event start date")
    public String setEventDate(String startDate) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DATE_FIELD_START)).click()
                .sendKeys(Keys.BACK_SPACE, Keys.CLEAR)
                .build().perform();
        WebElement dateStart = driver.findElement(DATE_FIELD_START);
        dateStart.sendKeys(startDate);
        return startDate;
    }

    @Step("Set event start time")
    public void setEventTime(String startTime) {
        driver.findElement(TIME_FIELD_START).click();
        WebElement timeOption = driver.findElement(By.xpath(String.format(optionTimeLocator, startTime)));
        scrollIntoView(timeOption);
        timeOption.click();
    }
}



