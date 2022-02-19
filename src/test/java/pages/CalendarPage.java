package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.CalendarModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

@Log4j2
public class CalendarPage extends BasePage {

    private final static By LINK_VIEW = By.xpath("//a[@title='View']");
    private final static By TITLE_CALENDAR = By.xpath("//p[text()='Calendar']");
    private final static By BUTTON_NEW_EVENT = By.xpath("//button[contains(@class,'new-event-button')]");
    private String optionViewCalendar = "//ul[@class='scrollable']//a[@title='%s']";
    private String eventDateOnList = "//span[text()='%s']/ancestor::tr//a[@title='%s']";

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

    @Step("Get start date event on list page")
    public void clickCreatedEventDay(String eventDay, String eventSubject) {
        driver.findElement(By.xpath(String.format(eventDateOnList, eventDay, eventSubject))).click();
    }

    @Step("Click 'new event' button on calendar page")
    public CalendarModal clickNewEventButton() {
        log.info("clicking new button on account page");
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_NEW_EVENT));
        jsClick(driver.findElement(BUTTON_NEW_EVENT));
        return new CalendarModal(driver);
    }

    @Step("Select view decoration page")
    public void setDecorationPageView(String optionName) {
        wait.until(ExpectedConditions.elementToBeClickable(LINK_VIEW));
        jsClick(driver.findElement(LINK_VIEW));
        AllureUtils.attachScreenshot(driver);
        driver.findElement(By.xpath(String.format(optionViewCalendar, optionName))).click();
    }
}
