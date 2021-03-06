package modals;

import elements.Dropdown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;


@Log4j2
public class ContactsModal extends BaseModal {

    private static final By FIELD_ACCOUNT_NAME = By.xpath("//label[text()='Account Name']");
    private static final By TITLE = By.xpath("//input[@name='Title']");
    private static final By SUFFIX = By.xpath("//input[@name='suffix']");
    private static final By FIRST_NAME = By.xpath("//input[@name='firstName']");
    private static final By MIDDLE_NAME = By.xpath("//input[@name='middleName']");
    private static final By LAST_NAME = By.xpath("//input[@name='lastName']");
    private static final By PHONE = By.xpath("//input[@name='Phone']");
    private static final By MOBILE_PHONE = By.xpath("//input[@name='MobilePhone']");
    private static final By EMAIL = By.xpath("//input[@name='Email']");
    private static final By REPORTS_TO = By.xpath("//input[@placeholder='Search Contacts...']");
    private static final By MAILING_CITY = By.xpath("//label[text()='Mailing City']/ancestor::lightning-input//input[@name='city']");
    private static final By MAILING_PROVINCE = By.xpath("//label[text()='Mailing State/Province']/ancestor::lightning-input//input[@name='province']");
    private static final By MAILING_ZIP = By.xpath("//label[text()='Mailing Zip/Postal Code']/ancestor::lightning-input//input[@name='postalCode']");
    private static final By MAILING_COUNTRY = By.xpath("//label[text()='Mailing Country']/ancestor::lightning-input//input[@name='country']");
    private static final By FAX = By.xpath("//input[@name='Fax']");
    private static final By DEPARTMENT = By.xpath("//input[@name='Department']");
    private static final By MAILING_STREET = By.xpath("//label[text()='Mailing Street']/ancestor::lightning-textarea//textarea[@name='street']");
    private String optionLocator = "//span[@title='%s']/ancestor::ul[@aria-label='Recent Accounts']";

    public ContactsModal(WebDriver driver) {
        super(driver);
    }

    public ContactsModal fillForm(Contact contacts) {

        log.info(String.format("Filling form with contact info: %s", contacts));

        if (contacts.getSalutation() != null) {
            new Dropdown(driver, "Salutation").selectOption(contacts.getSalutation().getName());
        }

        if (contacts.getFirstName() != null) {
            driver.findElement(FIRST_NAME).sendKeys(contacts.getFirstName());
        }

        if (contacts.getMiddleName() != null) {
            driver.findElement(MIDDLE_NAME).sendKeys(contacts.getMiddleName());
        }

        if (contacts.getLastName() != null) {
            driver.findElement(LAST_NAME).sendKeys(contacts.getLastName());
        }

        if (contacts.getSuffix() != null) {
            driver.findElement(SUFFIX).sendKeys(contacts.getSuffix());
        }

        if (contacts.getReportsTo() != null) {
            driver.findElement(REPORTS_TO).sendKeys(contacts.getReportsTo());
        }

        if (contacts.getTitle() != null) {
            driver.findElement(TITLE).sendKeys(contacts.getTitle());
        }

        if (contacts.getDepartment() != null) {
            driver.findElement(DEPARTMENT).sendKeys(contacts.getDepartment());
        }

        if (contacts.getFax() != null) {
            driver.findElement(FAX).sendKeys(contacts.getFax());
        }

        if (contacts.getEmail() != null) {
            driver.findElement(EMAIL).sendKeys(contacts.getEmail());
        }

        if (contacts.getPhone() != null) {
            driver.findElement(PHONE).sendKeys(contacts.getPhone());
        }

        if (contacts.getMobile() != null) {
            driver.findElement(MOBILE_PHONE).sendKeys(contacts.getMobile());
        }

        if (contacts.getMailingStreet() != null) {
            driver.findElement(MAILING_STREET).sendKeys(contacts.getMailingStreet());
        }

        if (contacts.getMailingCity() != null) {
            driver.findElement(MAILING_CITY).sendKeys(contacts.getMailingCity());
        }

        if (contacts.getMailingStateProvince() != null) {
            driver.findElement(MAILING_PROVINCE).sendKeys(contacts.getMailingStateProvince());
        }

        if (contacts.getMailingZipPostalCode() != null) {
            driver.findElement(MAILING_ZIP).sendKeys(contacts.getMailingZipPostalCode());
        }

        if (contacts.getMailingCountry() != null) {
            driver.findElement(MAILING_COUNTRY).sendKeys(contacts.getMailingCountry());
        }
        return this;
    }

    @Step("Select account name from search field")
    public void selectAccountName(String optionName) {
        driver.findElement((FIELD_ACCOUNT_NAME)).click();
        AllureUtils.attachScreenshot(driver);
        driver.findElement(By.xpath(String.format(optionLocator, optionName))).click();

    }

}
