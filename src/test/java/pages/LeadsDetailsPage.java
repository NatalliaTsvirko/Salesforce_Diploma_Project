package pages;


import elements.LightningFormattedElement;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LeadsDetailsPage extends BasePage {

    private static final By TITLE_COMPANY_NAME = By.xpath("//span[@title='Company']");
    private static final By BUTTON_STATUS_COMPLETE = By.xpath("//button[contains(@class,'slds-button--brand')]//span[text()='Mark Status as Complete']");
    private static final By BUTTON_CONVERT = By.xpath("//span[text()='Convert']");
    private static final By CREATED_LEADS_MESSAGE = By.xpath("//span[text()='Your lead has been converted']");
    private static final By INPUT_ACCOUNT_NAME = By.xpath("//span[text()='Account Name']");
    private static final By BUTTON_GO_TO_LEADS = By.xpath("//button[@type='button' and text()='Go to Leads']");
    private static final By NEW_BUTTON = By.cssSelector("a[title=New]");
    private static final By LEAD_STATUS = By.xpath("//span[text()='Lead Status']/ancestor::records-record-layout-item/div//lightning-formatted-text");
    private static final By DETAILS_TAB = By.xpath("//a[@data-tab-value='detailTab']");

    public LeadsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE_COMPANY_NAME);
    }

    @Override
    public BasePage open() {

        return null;
    }

    public Lead getLeadsDetailsInfo() {

        Lead leads = Lead.builder().build();

        log.info(String.format("Filling form with account info: %s", leads));


        LeadStatus leadsLeadStatus = LeadStatus.fromString(new LightningFormattedElement(driver, "Lead Status").getText());
        if (leadsLeadStatus != null) {
            leads.setLeadStatus(leadsLeadStatus);
        }


        String leadsName = new LightningFormattedElement(driver, "Name").getText();
        if (leadsName != "") {
            leads.setLastName(leadsName);
        }

        String leadsTitle = new LightningFormattedElement(driver, "Titel").getText();
        if (leadsTitle != "") {
            leads.setTitle(leadsTitle);
        }

        String leadsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (leadsEmail != "") {
            leads.setEmail(leadsEmail);
        }

        String leadsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (leadsPhone != "") {
            leads.setPhone(leadsPhone);
        }

        String leadsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (leadsMobile != "") {
            leads.setMobile(leadsMobile);
        }

        Rating leadsRating = Rating.fromString(new LightningFormattedElement(driver, "Rating").getText());
        if (leadsRating != null) {
            leads.setRating(leadsRating);
        }

        String leadsWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (leadsWebsite != "") {
            leads.setWebsite(leadsWebsite);
        }

        String leadsCompany = new LightningFormattedElement(driver, "Company").getText();
        if (leadsCompany != "") {
            leads.setCompany(leadsCompany);
        }

        Industry leadsIndustry = Industry.fromString(new LightningFormattedElement(driver, "Company").getText());
        if (leadsIndustry != null) {
            leads.setIndustry(leadsIndustry);
        }

        String leadsNoOfEmployee = new LightningFormattedElement(driver, "No. of Employee").getText();
        if (leadsNoOfEmployee != "") {
            leads.setNumberOfEmployee(leadsNoOfEmployee);
        }

        LeadSource leadsLeadSource = LeadSource.fromString(new LightningFormattedElement(driver, "Lead Source").getText());
        if (leadsLeadSource != null) {
            leads.setLeadSource(leadsLeadSource);
        }

        String leadsAddress = new LightningFormattedElement(driver, "Address").getText();
        if (leadsAddress != "") {
            leads.setSearchAddress(leadsAddress);
        }

        return leads;

    }

    @Step("Click button 'status'")
    public void clickButtonStatus() {
        log.info("clicking button status complete");
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_STATUS_COMPLETE));
        jsClick(driver.findElement(BUTTON_STATUS_COMPLETE));

    }

    @Step("Click button 'convert'")
    public void clickConvertButton() {
        log.info("click convert button on leads modal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_ACCOUNT_NAME));
        driver.findElement(BUTTON_CONVERT).click();

    }

    @Step("Click button 'Go to Leads'")
    public LeadsDetailsPage clickButtonGoToLeads() {
        log.info("click on button 'Go to Leads'");
        driver.findElement(BUTTON_GO_TO_LEADS).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        return this;
    }

    @Step("Get lead Status information")
    public String getLeadStatus() {
        log.info("Get lead Status information");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LEAD_STATUS));
        return driver.findElement(LEAD_STATUS).getText();
    }

    @Step("Open detail tab after created lead ")
    public void openDetailsTab() {
        log.info("open details lead table");
        wait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB));
        driver.findElement(DETAILS_TAB).click();

    }

    @Step("Get message about lead is convert")
    public boolean isConvertLeadMessageDisplayed() {
        log.info("Get message about lead is convert");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATED_LEADS_MESSAGE));
        return driver.findElement(CREATED_LEADS_MESSAGE).isDisplayed();

    }
}

