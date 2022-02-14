package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.CalendarModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

@Log4j2
public class CalendarPage extends BasePage{


    private final String optionViewCalendar = "//ul[@class='scrollable']//a[@title='%s']";
    private final static By LINK_VIEW = By.xpath("//a[@title='View']");
    private final static By TITLE_CALENDAR = By.xpath("//p[text()='Calendar']");
    private final static By BUTTON_NEW_EVENT = By.xpath("//button[contains(@class,'new-event-button')]");

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE_CALENDAR);
    }

    @Override
    public CalendarPage open() {
        driver.get(BASE_URL + "/lightning/o/Event/home");
        return this;
    }

    @Step("Click 'new event' button on calendar page")
    public CalendarModal clickNewEventButton() {
        log.info("clicking new button on account page");
        driver.findElement(BUTTON_NEW_EVENT).click();
        return new CalendarModal(driver);
    }

    @Step("Select view decoration page")
    public void selectDecorationPageView(String optionName) {
        driver.findElement((LINK_VIEW)).click();
        AllureUtils.attachScreenshot(driver);
        driver.findElement(By.xpath(String.format(optionViewCalendar, optionName))).click();

    }
}
