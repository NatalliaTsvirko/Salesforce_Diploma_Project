package pages;

import elements.CalendarElement;
import enums.CalendarType;
import enums.Subject;
import lombok.extern.log4j.Log4j2;
import models.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarDetailsPage extends BasePage {

    private static final By NAME_DETAILS_TAB = By.xpath("//span[text()='Details']");

    public CalendarDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(NAME_DETAILS_TAB);
    }

    @Override
    public BasePage open() {
        return null;
    }

    public Calendar getCalendarDetailsInfo() {

        Calendar calendar = Calendar.builder().build();

        log.info(String.format("Filling form with calendar info: %s", calendar));

        Subject calendarSubject = Subject.fromString(new CalendarElement(driver, "Subject").getTextSubjectAndLocation());
        if (calendarSubject != null) {
            calendar.setSubject(calendarSubject);
        }

        String calendarLocation = new CalendarElement(driver, "Location").getTextSubjectAndLocation();
        if (calendarLocation != "") {
            calendar.setLocation(calendarLocation);
        }

        String calendarStart = new CalendarElement(driver, "Start").getStartDateTimeText();
        if (calendarStart != "") {
            calendar.setDate(calendarStart);
        }

        String calendarEnd = new CalendarElement(driver, "Start").getEndDateTimeText();
        if (calendarEnd != "") {
            calendar.setDate(calendarEnd);
        }

        CalendarType calendarType = CalendarType.fromString(new CalendarElement(driver, "Type").getTypeText());
        if (calendarType != null) {
            calendar.setCalendarType(calendarType);
        }

        String calendarDescription = new CalendarElement(driver, "Description").getDescriptionText();
        if (calendarDescription != "") {
            calendar.setDescription(calendarDescription);
        }
        return calendar;
    }
}
