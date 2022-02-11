package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.ContactsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class ContactsPage extends BasePage {
    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public ContactsPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Click 'new' button on contact page")
    public ContactsModal clickNewButton() {
        log.info("clicking button 'New' on contact page");
        driver.findElement(NEW_BUTTON).click();
        return new ContactsModal(driver);
    }

    @Step("Open detail page after creating an contact")
    public ContactDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        log.info("open details contacts table");
        return new ContactDetailsPage(driver);
    }

    @Step("Verify notification message 'contact is created' ")
    public boolean verifyNotificationMessage() {
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        log.info("wait notification message ");
        return successMessage.isDisplayed();
    }
}
