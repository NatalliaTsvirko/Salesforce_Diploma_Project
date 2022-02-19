package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LeadsPage extends BasePage {

    private static final By DELETE_OPTION = By.xpath("//ul[@class='scrollable']//a[@title='Delete']");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    private String optionsDeleteLocator = "//a[@title='%s']//ancestor::tr//a[contains(@class,'slds-button')]";


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
        driver.findElement(DELETE_BUTTON).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
    }


}


