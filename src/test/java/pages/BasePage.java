package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;


@Log4j2
public abstract class BasePage {

    private static final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");

    String BASE_URL = System.getenv().getOrDefault("BASE_URL", PropertyReader.getProperty("salesforce.base_url"));

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public abstract boolean isPageOpened();

    public abstract BasePage open();


    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Step("Verify notification message ")
    public boolean isNotificationMessageDisplayed() {
        log.info("wait notification message ");
        return driver.findElement(SUCCESS_MESSAGE).isDisplayed();

    }

    @Step("Click 'new' button page")
    public void clickNewButton() {
        log.info("clicking 'new' button page");
        driver.findElement(NEW_BUTTON).click();

    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}


