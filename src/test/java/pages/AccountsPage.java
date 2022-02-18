package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.AllureUtils;


@Log4j2
public class AccountsPage extends BasePage {

    private static final By COLUMN_NAME = By.xpath("//span[@title='Account Name']");
    private static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    private static final By SEARCH_FIELD = By.xpath("//label[text()='Search this list...']/following::input[@type='search']");
    private static final By FIND_ACCOUNT_NAME = By.xpath("//th//a[@data-refid='recordId']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(COLUMN_NAME);
    }

    @Override
    public AccountsPage open() {
        driver.get(BASE_URL + "/lightning/o/Account/list?filterName=Recent");
        return this;
    }

    @Step("Open detail page after creating an account")
    public AccountDetailsPage openDetailsTab() {
        log.info("open details table");
        driver.findElement(DETAILS_TAB).click();
        return new AccountDetailsPage(driver);
    }

    @Step("Input in search field account name")
    public void setAccountName(String accountName) {
        log.info("input account name");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(SEARCH_FIELD))
                .click()
                .sendKeys(accountName, Keys.ENTER)
                .pause(5)
                .build()
                .perform();
    }

    @Step("Get searching account name")
    public String getAccountName() {
        log.info("get account name");
        AllureUtils.attachScreenshot(driver);
        return driver.findElement(FIND_ACCOUNT_NAME).getText();

    }
}

