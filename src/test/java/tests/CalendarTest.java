package tests;

import modals.CalendarModal;
import models.Calendar;
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

    @Test(description = "Create calendar event and verify notification message", groups = {"Regression"})
    public void createNewEvent() {
        Calendar testCalendar = calendarGenerator.getCalendarData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickCalendarMenuLink()
                .clickNewEventButton();
        calendarModal.fillForm(testCalendar)
                .clickSaveButton();
        String expectedMessage = "Event Call was created.";
        assertEquals(calendarPage.getCreatedNotificationMessage(), expectedMessage);
        //here don't have detail page.Only notification message

    }
}
