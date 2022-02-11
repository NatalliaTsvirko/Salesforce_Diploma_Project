package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.AccountModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@Log4j2
public class AccountsPage extends BasePage {

    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public AccountsPage open() {
        driver.get(BASE_URL + "/lightning/o/Account/list?filterName=Recent");
        return this;
    }
    @Step("Click 'new' button on account page")
    public AccountModal clickNewButton() {
        log.info("clicking new button on account page");
        driver.findElement(NEW_BUTTON).click();
        return new AccountModal(driver);
    }
    @Step("Open detail page after creating an account")
    public AccountDetailsPage openDetailsTab() {
        log.info("open details table");
        driver.findElement(DETAILS_TAB).click();
        return new AccountDetailsPage(driver);
    }
    @Step("Verify notification message 'account is created' ")
    public boolean verifyNotificationMessage() {
        log.info("wait notification message ");
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        return successMessage.isDisplayed();
    }

}

