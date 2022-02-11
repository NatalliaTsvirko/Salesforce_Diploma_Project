package pages;

import io.qameta.allure.Step;
import modals.LeadsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeadsPage extends BasePage {

    private String listLocator = "//a[contains(@class,'rowActionsPlaceHolder')]";
    private String optionLocator = "//ul[@class='scrollable']//a[@title='Delete']";
    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");
    final By LEADS_NAME = By.xpath("//a[text()='%s']/ancestor::div[contains(@class,'listViewContainer ')]");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public LeadsPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Click 'new' button on lead page")
    public LeadsModal clickNewButton() {
        log.info("open contacts modal");
        driver.findElement(NEW_BUTTON).click();
        return new LeadsModal(driver);
    }

    @Step("Open detail tab after created lead ")
    public LeadsDetailsPage openDetailsTab() {
        log.info("open details lead table");
        driver.findElement(DETAILS_TAB).click();
        return new LeadsDetailsPage(driver);
    }

    @Step("Verify notification message 'lead is created' ")
    public boolean verifyNotificationMessage() {
        log.info("wait notification message ");
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        return successMessage.isDisplayed();
    }

    @Step("Delete leads")
    public void deleteLeads(String optionName) {
        WebElement searchFieldToClick = driver.findElement(By.xpath(listLocator));
        searchFieldToClick.click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator,optionName)));
        optionToClick.click();
    }


    public void clickDeleteButton(){
        driver.findElement(DELETE_BUTTON).click();
    }

    public int verifyElementNotOnPage(String name){
        int numberOfElements = driver.findElements(LEADS_NAME).size();
        return numberOfElements;
    }

}


