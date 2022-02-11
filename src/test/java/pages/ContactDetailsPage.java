package pages;

import elements.LightningFormattedElement;
import lombok.extern.log4j.Log4j2;
import models.Contacts;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactDetailsPage extends BasePage {

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }

    public Contacts getContactsDetailsInfo() {

        Contacts contacts = Contacts.builder().build();

        log.info(String.format("Filling form with account info: $s", contacts));

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
