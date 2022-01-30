package pages;

import io.qameta.allure.Step;
import modals.LeadsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadsPage extends BasePage {

    private String listLocator = "//a[text()='%s']//ancestor::tr//a[contains(@class,'slds-button')]";
    private String optionLocator = "//ul[@class='scrollable']//a[@title='Delete']";
    private String leadName = "//a[text()='%s']/ancestor::div[contains(@class,'listViewContainer ')]";
    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");


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

    @Step("Get notification message ")
    public boolean getNotificationMessage() {
        log.info("wait notification message ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE));
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        return successMessage.isDisplayed();
    }

    @Step("Delete leads")
    public void deleteLeads(String nameLead) {
        WebElement searchFieldToClick = driver.findElement(By.xpath(String.format(listLocator,nameLead)));
        searchFieldToClick.click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator)));
        optionToClick.click();
    }


    public void clickDeleteButton(){
        driver.findElement(DELETE_BUTTON).click();
    }

    public int getVisibleLeadsByCountName(String name){
        int numberOfElements = driver.findElements(By.xpath(String.format(leadName,name))).size();
        return numberOfElements;
    }

}


