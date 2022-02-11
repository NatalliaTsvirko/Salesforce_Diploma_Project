package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class LoginPage extends BasePage {

    final static By EMAIL_INPUT = By.id("username");
    final static By PASSWORD_INPUT = By.id("password");
    final static By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Login to Salesforce.com with username and password")
    public HomePage login(String email, String password) {
        log.info("open home page");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        AllureUtils.attachScreenshot(driver);
        return new HomePage(driver);
    }
}
