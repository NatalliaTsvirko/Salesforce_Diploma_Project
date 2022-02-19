package pages;

import elements.LightningFormattedElement;
import lombok.extern.log4j.Log4j2;
import models.Contact;
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
    public BasePage open() {
        return null;
    }

    public Contact getContactsDetailsInfo() {

        Contact contacts = Contact.builder().build();

        log.info(String.format("Filling form with account info: %s", contacts));

        String contactName = new LightningFormattedElement(driver, "Name").getText();
        if (contactName != "") {
            contacts.setFirstName(contactName);
        }

        String contactsAccountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (contactsAccountName != "") {
            contacts.setAccountName(contactsAccountName);
        }

        String contactsTitle = new LightningFormattedElement(driver, "Title").getText();
        if (contactsTitle != "") {
            contacts.setTitle(contactsTitle);
        }

        String contactsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (contactsPhone != "") {
            contacts.setPhone(contactsPhone);
        }

        String contactsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (contactsEmail != "") {
            contacts.setEmail(contactsEmail);
        }

        String contactsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (contactsMobile != "") {
            contacts.setMobile(contactsMobile);
        }

        String contactsReportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (contactsReportsTo != "") {
            contacts.setReportsTo(contactsReportsTo);
        }

        String contactsFax = new LightningFormattedElement(driver, "Fax").getText();
        if (contactsFax != "") {
            contacts.setFax(contactsFax);
        }
        return contacts;
    }
}
