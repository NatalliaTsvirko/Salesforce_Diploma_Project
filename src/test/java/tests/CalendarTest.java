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
        String expectedDate = "2/26/2022, 1:45 PM";
        Calendar testCalendar = calendarGenerator.getCalendarData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickCalendarMenuLink();
        calendarPage.clickNewEventButton();
        calendarModal.setEventDate("02/26/2022");
        calendarModal.setEventTime("1:45 PM");
        calendarModal.fillForm(testCalendar)
                .clickSaveButton();
        assertTrue(calendarPage.isNotificationMessageDisplayed());
        calendarPage.setDecorationPageView("Table");
        calendarPage.clickCreatedEventDay(expectedDate, "Meeting");
        Calendar actualCalendarDetailsInfo = calendarDetailsPage.getCalendarDetailsInfo();
        assertEquals(actualCalendarDetailsInfo, testCalendar, "Calendar details don't match test calendar data");

    }
}
