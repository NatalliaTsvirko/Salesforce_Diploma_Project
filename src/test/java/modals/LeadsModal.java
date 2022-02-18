package modals;

import elements.Dropdown;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class LeadsModal extends BaseModal {

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

    public LeadsModal fillForm(Lead lead) {

        log.info(String.format("Filling form with lead info: %s", lead));

        if (lead.getLeadStatus() != null) {
            new Dropdown(driver, "Lead Status").selectOption(lead.getLeadStatus().getName());
        }

        if (lead.getSalutation() != null) {
            new Dropdown(driver, "Salutation").selectOption(lead.getSalutation().getName());
        }

        if (lead.getFirstName() != null) {
            driver.findElement(FIRST_NAME).sendKeys(lead.getFirstName());
        }

        if (lead.getMiddleName() != null) {
            driver.findElement(MIDDLE_NAME).sendKeys(lead.getMiddleName());
        }

        if (lead.getLastName() != null) {
            driver.findElement(LAST_NAME).sendKeys(lead.getLastName());
        }

        if (lead.getSuffix() != null) {
            driver.findElement(SUFFIX).sendKeys(lead.getSuffix());
        }

        if (lead.getWebsite() != null) {
            driver.findElement(WEBSITE).sendKeys(lead.getWebsite());
        }

        if (lead.getTitle() != null) {
            driver.findElement(TITLE).sendKeys(lead.getTitle());
        }

        if (lead.getEmail() != null) {
            driver.findElement(EMAIL).sendKeys(lead.getEmail());
        }

        if (lead.getCompany() != null) {
            driver.findElement(COMPANY).sendKeys(lead.getCompany());
        }

        if (lead.getPhone() != null) {
            driver.findElement(PHONE).sendKeys(lead.getPhone());
        }

        if (lead.getNumberOfEmployee() != null) {
            driver.findElement(NUMBER_OF_EMPLOYEE).sendKeys(lead.getNumberOfEmployee());
        }

        if (lead.getMobile() != null) {
            driver.findElement(MOBILE_PHONE).sendKeys(lead.getMobile());
        }

        if (lead.getLeadSource() != null) {
            new Dropdown(driver, "Lead Source").selectOption(lead.getLeadSource().getName());
        }

        if (lead.getRating() != null) {
            new Dropdown(driver, "Rating").selectOption(lead.getRating().getName());
        }

        if (lead.getStreet() != null) {
            driver.findElement(STREET).sendKeys(lead.getStreet());
        }

        if (lead.getCity() != null) {
            driver.findElement(CITY).sendKeys(lead.getCity());
        }

        if (lead.getStateProvince() != null) {
            driver.findElement(PROVINCE).sendKeys(lead.getStateProvince());
        }

        if (lead.getZipPostalCode() != null) {
            driver.findElement(POSTAL_CODE).sendKeys(lead.getZipPostalCode());
        }

        if (lead.getCountry() != null) {
            driver.findElement(COUNTRY).sendKeys(lead.getCountry());
        }
        return this;
    }
}
