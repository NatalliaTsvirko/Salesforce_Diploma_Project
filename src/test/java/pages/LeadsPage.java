package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LeadsPage extends BasePage {

    private String listLocator = "//a[text()='%s']//ancestor::tr//a[contains(@class,'slds-button')]";
    private String leadName = "//a[text()='%s']/ancestor::div[contains(@class,'listViewContainer ')]";
    private static final By DELETE_OPTION = By.xpath("//ul[@class='scrollable']//a[@title='Delete']");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    private static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");


    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(NEW_BUTTON);
    }

    @Override
    public LeadsPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Open detail tab after created lead ")
    public LeadsDetailsPage openDetailsTab() {
        log.info("open details lead table");
        driver.findElement(DETAILS_TAB).click();
        return new LeadsDetailsPage(driver);
    }

    @Step("Delete leads from list")
    public void deleteLeads(String nameLead) {
        WebElement searchFieldToClick = driver.findElement(By.xpath(String.format(listLocator, nameLead)));
        searchFieldToClick.click();
        WebElement optionDeleteToClick = driver.findElement(DELETE_OPTION);
        optionDeleteToClick.click();
    }

    @Step("Click on 'delete' button")
    public void clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
    }

    @Step("Get leads name list ")
    public int getVisibleLeadsName(String name) {
        int numberOfElements = driver.findElements(By.xpath(String.format(leadName, name))).size();
        return numberOfElements;
    }

}


