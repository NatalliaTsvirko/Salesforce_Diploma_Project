package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;


public abstract class BasePage {

    String BASE_URL = System.getenv().getOrDefault("BASE_URL", PropertyReader.getProperty("salesforce.base_url"));

    protected static final Logger log = LogManager.getLogger(BasePage.class.getName());
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

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}


