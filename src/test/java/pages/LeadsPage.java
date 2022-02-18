package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LeadsPage extends BasePage {

    private String optionsDeleteLocator = "//a[@title='%s']//ancestor::tr//a[contains(@class,'slds-button')]";
    private String leadName = "//a[@title='%s']/ancestor::div[contains(@class,'listViewContainer ')]";
    private static final By DELETE_OPTION = By.xpath("//ul[@class='scrollable']//a[@title='Delete']");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    private static final By OPPORTUNITY_MENU_LINK = By.xpath("//a[@title='Opportunities']");


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

    @Step("Open delete option on leads from list")
    public void deleteLeads(String nameLead) {
        log.info("Open delete option");
        WebElement searchFieldToClick = driver.findElement(By.xpath(String.format(optionsDeleteLocator, nameLead)));
        searchFieldToClick.click();
        WebElement optionDeleteToClick = driver.findElement(DELETE_OPTION);
        optionDeleteToClick.click();
    }

    @Step("Click on 'delete' button")
    public void clickDeleteButton() {
        log.info("Click on 'delete' button");
        driver.findElement(DELETE_BUTTON).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
    }

    @Step("Get leads name list ")
    public int getVisibleLeadName(String name) {
        log.info("Get leads name list ");
        int numberOfElements = driver.findElements(By.xpath(String.format(leadName, name))).size();
        return numberOfElements;
    }

    @Step("Click Opportunity menu link")
    public void clickOpportunityMenuLink() {
        log.info("open Opportunity page");
        wait.until(ExpectedConditions.elementToBeClickable(OPPORTUNITY_MENU_LINK));
        jsClick(driver.findElement(OPPORTUNITY_MENU_LINK));

    }

}


