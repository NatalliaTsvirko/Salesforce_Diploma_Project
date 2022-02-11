package modals;

import elements.DropdownContactLeadModal;
import lombok.extern.log4j.Log4j2;
import models.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ContactsPage;


@Log4j2
public class LeadsModal extends BaseModal {

    final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    private static final By FIRST_NAME = By.xpath("//input[@name='firstName']");
    private static final By MIDDLE_NAME = By.xpath("//input[@name='middleName']");
    private static final By LAST_NAME = By.xpath("//input[@name='lastName']");
    private static final By SUFFIX = By.xpath("//input[@name='suffix']");
    private static final By WEBSITE = By.xpath("//input[@name='Website']");
    private static final By TITLE = By.xpath("//input[@name='Title']");
    private static final By COMPANY = By.xpath("//input[@name='Company']");
    private static final By EMAIL = By.xpath("//input[@name='Email']");
    private static final By PHONE = By.xpath("//input[@name='Phone']");
    private static final By MOBILE_PHONE = By.xpath("//input[@name='MobilePhone']");
    private static final By NUMBER_OF_EMPLOYEE = By.xpath("//input[@name='NumberOfEmployees']");
    private static final By STREET = By.xpath("//textarea[@name='street']");
    private static final By CITY = By.xpath("//input[@name='city']");
    private static final By PROVINCE = By.xpath("//input[@name='province']");
    private static final By POSTAL_CODE = By.xpath("//input[@name='postalCode']");
    private static final By COUNTRY = By.xpath("//input[@name='country']");

    public LeadsModal(WebDriver driver) {
        super(driver);
    }

    public LeadsModal fillForm(Leads leads) {

        log.info(String.format("Filling form with account info: $s", leads));

        if (leads.getLeadStatus() != null) {
            new DropdownContactLeadModal(driver, "Lead Status").selectOption(leads.getLeadStatus().getName());
        }

        if (leads.getSalutation() != null) {
            new DropdownContactLeadModal(driver, "Salutation").selectOption(leads.getSalutation().getName());
        }

        if (leads.getFirstName() != null) {
            driver.findElement(FIRST_NAME).sendKeys(leads.getFirstName());
        }

        if (leads.getMiddleName() != null) {
            driver.findElement(MIDDLE_NAME).sendKeys(leads.getMiddleName());
        }

        if (leads.getLastName() != null) {
            driver.findElement(LAST_NAME).sendKeys(leads.getLastName());
        }

        if (leads.getSuffix() != null) {
            driver.findElement(SUFFIX).sendKeys(leads.getSuffix());
        }

        if (leads.getWebsite() != null) {
            driver.findElement(WEBSITE).sendKeys(leads.getWebsite());
        }

        if (leads.getTitle() != null) {
            driver.findElement(TITLE).sendKeys(leads.getTitle());
        }

        if (leads.getEmail() != null) {
            driver.findElement(EMAIL).sendKeys(leads.getEmail());
        }

        if (leads.getCompany() != null) {
            driver.findElement(COMPANY).sendKeys(leads.getCompany());
        }

        if (leads.getPhone() != null) {
            driver.findElement(PHONE).sendKeys(leads.getPhone());
        }

        if (leads.getNumberOfEmployee() != null) {
            driver.findElement(NUMBER_OF_EMPLOYEE).sendKeys(leads.getNumberOfEmployee());
        }

        if (leads.getMobile() != null) {
            driver.findElement(MOBILE_PHONE).sendKeys(leads.getMobile());
        }

        if (leads.getLeadSource() != null) {
            new DropdownContactLeadModal(driver, "Lead Source").selectOption(leads.getLeadSource().getName());
        }

        if (leads.getRating() != null) {
            new DropdownContactLeadModal(driver, "Rating").selectOption(leads.getRating().getName());
        }

        if (leads.getStreet() != null) {
            driver.findElement(STREET).sendKeys(leads.getStreet());
        }

        if (leads.getCity() != null) {
            driver.findElement(CITY).sendKeys(leads.getCity());
        }

        if (leads.getStateProvince() != null) {
            driver.findElement(PROVINCE).sendKeys(leads.getStateProvince());
        }

        if (leads.getZipPostalCode() != null) {
            driver.findElement(POSTAL_CODE).sendKeys(leads.getZipPostalCode());
        }

        if (leads.getCountry() != null) {
            driver.findElement(COUNTRY).sendKeys(leads.getCountry());
        }
        return this;
    }

    public ContactsPage clickSaveButton() {
        log.info("click save button on contact modal");
        driver.findElement(SAVE_BUTTON).click();
        return new ContactsPage(driver);
    }

}
