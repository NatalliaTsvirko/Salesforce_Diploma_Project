package pages;


import elements.LightningFormattedElement;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Leads;
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


    public LeadsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE_COMPANY_NAME);
    }

    @Override
    public LeadsDetailsPage open() {
        driver.get(BASE_URL + "/lightning/r/Lead/00Q5j000006bQoFEAU/view");
        return this;
    }

    public Leads getLeadsDetailsInfo() {

        Leads leads = Leads.builder().build();

        log.info(String.format("Filling form with account info: %s", leads));


        LeadStatus leadsLeadStatus = LeadStatus.fromString(new LightningFormattedElement(driver, "Lead Status").getText());
        if (leadsLeadStatus != null) {
            leads.setLeadStatus(leadsLeadStatus);
        }


        String leadsName = new LightningFormattedElement(driver, "Name").getText();
        if (leadsName != null ) {
            leads.setLastName(leadsName);
        }

        String leadsTitle = new LightningFormattedElement(driver, "Titel").getText();
        if (leadsTitle != null ) {
            leads.setTitle(leadsTitle);
        }

        String leadsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (leadsEmail != null ) {
            leads.setEmail(leadsEmail);
        }

        String leadsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (leadsPhone != null ) {
            leads.setPhone(leadsPhone);
        }

        String leadsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (leadsMobile != null ) {
            leads.setMobile(leadsMobile);
        }

        Rating leadsRating = Rating.fromString(new LightningFormattedElement(driver, "Rating").getText());
        if (leadsRating != null) {
            leads.setRating(leadsRating);
        }

        String leadsWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (leadsWebsite != null ) {
            leads.setWebsite(leadsWebsite);
        }

        String leadsCompany = new LightningFormattedElement(driver, "Company").getText();
        if (leadsCompany != null ) {
            leads.setCompany(leadsCompany);
        }

        Industry leadsIndustry = Industry.fromString(new LightningFormattedElement(driver, "Company").getText());
        if (leadsIndustry != null) {
            leads.setIndustry(leadsIndustry);
        }

        String leadsNoOfEmployee = new LightningFormattedElement(driver, "No. of Employee").getText();
        if (leadsNoOfEmployee != null) {
            leads.setNumberOfEmployee(leadsNoOfEmployee);
        }

        LeadSource leadsLeadSource = LeadSource.fromString(new LightningFormattedElement(driver, "Lead Source").getText());
        if (leadsLeadSource != null) {
            leads.setLeadSource(leadsLeadSource);
        }

        String leadsAddress = new LightningFormattedElement(driver, "Address").getText();
        if (leadsAddress != null ) {
            leads.setSearchAddress(leadsAddress);
        }

        return leads;

    }

    @Step("Click button 'status'")
    public void clickButtonStatus() {
        log.info("clicking button status complete");
        jsClick(driver.findElement(BUTTON_STATUS_COMPLETE));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_STATUS_COMPLETE));
    }

    @Step("Click button 'convert'")
    public LeadsDetailsPage clickConvertButton() {
        log.info("click convert button on leads modal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_ACCOUNT_NAME));
        driver.findElement(BUTTON_CONVERT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CREATED_LEADS_MESSAGE));
        return this;
    }
}

