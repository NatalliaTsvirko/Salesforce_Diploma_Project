package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class OpportunitiesPage extends BasePage {

    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By OPPORTUNITY_MENU_LINK = By.xpath("//a[@title='Opportunities']");
    private String leadName = "//a[@title='%s']/ancestor::div[contains(@class,'listViewContainer ')]";


    public OpportunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(NEW_BUTTON);
    }

    @Override
    public OpportunitiesPage open() {
        driver.get(BASE_URL + "/lightning/o/Opportunity/list?filterName=Recent");
        return this;
    }

    @Step("Click Opportunity menu link")
    public void clickOpportunityMenuLink() {
        log.info("open Opportunity page");
        wait.until(ExpectedConditions.elementToBeClickable(OPPORTUNITY_MENU_LINK));
        jsClick(driver.findElement(OPPORTUNITY_MENU_LINK));

    }

    @Step("Get leads name list ")
    public int getLeadNameOnList(String name) {
        log.info("Get leads name list ");
        int countOfElementsOnPage = driver.findElements(By.xpath(String.format(leadName, name))).size();
        return countOfElementsOnPage;
    }
}
