package pages;

import elements.LightningFormattedElement;
import lombok.extern.log4j.Log4j2;
import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactDetailsPage extends BasePage {

    private static final By TITLE = By.xpath("//p[@title='Title']");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE);
    }

    @Override
    public ContactDetailsPage open() {
        driver.get(BASE_URL + "/lightning/r/Contact/0035j00000JJaW4AAL/view");
        return this;
    }

    public Contacts getContactsDetailsInfo() {

        Contacts contacts = Contacts.builder().build();

        log.info(String.format("Filling form with account info: %s", contacts));

        String contactName = new LightningFormattedElement(driver, "Name").getText();
        if (contactName != null ) {
            contacts.setFirstName(contactName);
        }

        String contactsAccountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (contactsAccountName != null ) {
            contacts.setAccountName(contactsAccountName);
        }

        String contactsTitle = new LightningFormattedElement(driver, "Title").getText();
        if (contactsTitle != null ) {
            contacts.setTitle(contactsTitle);
        }

        String contactsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (contactsPhone != null ) {
            contacts.setPhone(contactsPhone);
        }

        String contactsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (contactsEmail != null ) {
            contacts.setEmail(contactsEmail);
        }

        String contactsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (contactsMobile != null ) {
            contacts.setMobile(contactsMobile);
        }

        String contactsReportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (contactsReportsTo != null ) {
            contacts.setReportsTo(contactsReportsTo);
        }

        String contactsFax = new LightningFormattedElement(driver, "Fax").getText();
        if (contactsFax != null ) {
            contacts.setFax(contactsFax);
        }
        return contacts;
    }
}
