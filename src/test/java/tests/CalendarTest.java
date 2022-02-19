package tests;

import io.qameta.allure.Description;
import modals.CalendarModal;
import models.Calendar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalendarDetailsPage;
import pages.CalendarPage;
import utils.CalendarGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalendarTest extends BaseTest {

    CalendarPage calendarPage;
    CalendarModal calendarModal;
    CalendarGenerator calendarGenerator;
    CalendarDetailsPage calendarDetailsPage;
    private String testDate = "2/26/2022";
    private String testTime = "1:45 PM";

    @BeforeClass
    public void initializePages() {
        calendarPage = new CalendarPage(driver);
        calendarModal = new CalendarModal(driver);
        calendarGenerator = new CalendarGenerator();
        calendarDetailsPage = new CalendarDetailsPage(driver);
    }

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }


    @Test(description = "Create calendar event ", groups = {"Regression"})
    @Description("Create calendar event ")
    public void createNewEvent() {
        String expectedDate = testDate + ", " + testTime;
        Calendar testCalendar = calendarGenerator.getCalendarData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickCalendarMenuLink();
        calendarPage.clickNewEventButton();
        calendarModal.setEventDate(testDate);
        calendarModal.setEventTime(testTime);
        calendarModal.fillForm(testCalendar)
                .clickSaveButton();
        assertTrue(calendarPage.isNotificationMessageDisplayed());
        calendarPage.setDecorationPageView("Table");
        String getSubject = String.valueOf(testCalendar.getSubject().getName());
        calendarPage.clickCreatedEventDay(expectedDate, getSubject);
        Calendar actualCalendarDetailsInfo = calendarDetailsPage.getCalendarDetailsInfo();
        assertEquals(actualCalendarDetailsInfo, testCalendar, "Calendar details don't match test calendar data");

    }
}
