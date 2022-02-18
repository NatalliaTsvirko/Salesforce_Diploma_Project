package tests;

import io.qameta.allure.Description;
import modals.CalendarModal;
import models.Calendar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalendarPage;
import utils.CalendarGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalendarTest extends BaseTest {

    CalendarPage calendarPage;
    CalendarModal calendarModal;
    CalendarGenerator calendarGenerator;


    @BeforeClass
    public void initializePages() {
        calendarPage = new CalendarPage(driver);
        calendarModal = new CalendarModal(driver);
        calendarGenerator = new CalendarGenerator();

    }

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }


    @Test(description = "Create calendar event ", groups = {"Regression"})
    @Description("Create calendar event ")
    public void createNewEvent() {
        Calendar testCalendar = calendarGenerator.getCalendarData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickCalendarMenuLink()
                .setStartDate("21");
        calendarPage.clickNewEventButton();
        calendarModal.setEventTime("12:00 AM");
        calendarModal.fillForm(testCalendar)
                .clickSaveButton();
        assertTrue(calendarPage.isNotificationMessageDisplayed());
        calendarPage.setDecorationPageView("Table");
        String expectedEventDate = "2/21/2022, 12:00 AM";
        int numberOfElements = calendarPage.getCreatedEventDay(expectedEventDate);
        assertEquals(numberOfElements, 1, "Element on page");

    }
}
