package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LeadsPage extends BasePage {

    private String listLocator = "//a[@title='%s']//ancestor::tr//a[contains(@class,'slds-button')]";
    private String leadName = "//a[@title='%s']/ancestor::div[contains(@class,'listViewContainer ')]";
    private static final By DELETE_OPTION = By.xpath("//ul[@class='scrollable']//a[@title='Delete']");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    private static final By OPPORTUNITY_MENU_LINK = By.xpath("//*[@title='Opportunity']");


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
    public int getVisibleLeadName(String name) {
        int numberOfElements = driver.findElements(By.xpath(String.format(leadName, name))).size();
        return numberOfElements;
    }

    @Step("Click Opportunity menu link")
    public void clickOpportunityMenuLink() {
        log.info("open Opportunity page");
        jsClick(driver.findElement(OPPORTUNITY_MENU_LINK));

    }

}


