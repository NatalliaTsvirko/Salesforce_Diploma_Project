package tests;

import lombok.extern.log4j.Log4j2;
import modals.ContactsModal;
import models.Contacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactsPage;
import pages.HomePage;
import utils.ContactsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class CreateContactTest extends BaseTest {

    HomePage homePage;
    ContactsPage contactsPage;
    ContactDetailsPage contactDetailsPage;
    ContactsModal contactsModal;
    ContactsGenerator contactsGenerator;


    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        contactsModal = new ContactsModal(driver);
        contactsGenerator = new ContactsGenerator();

    }

    @Test(description = "Create contact with all data", retryAnalyzer = ReTry.class, groups = {"Smoke", "Regression"})
    public void createContactWithAllData() {
        Contacts testContact = contactsGenerator.getContactsWithAllData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickContactsMenuLink()
                .clickNewButton();
        contactsModal.selectAccountName("Dickens-O'Hara");
        contactsModal.fillForm(testContact).clickSaveButton();
        String expectedMessage = "";
        //salesforce modal page is broken and i can't take notification message.I'm wait.
        assertEquals(contactsPage.getCreatedNotificationMessage(), expectedMessage);
        Contacts actualContactsDetailsInfo = contactsPage.openDetailsTab()
                .getContactsDetailsInfo();
        assertEquals(actualContactsDetailsInfo, testContact, "Contacts details don't match test account data");
    }

    @Test(description = "Send email list to contac",groups = {"Smoke"})
    public void sendEmailList(){
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickContactsMenuLink();
        contactsPage.selectContactCheckbox("t78p");
        contactsPage.clickButtonSendEmail();
        contactsPage.fillSendList("Hello","All cool");
        String expectedMessage = "success\n" +
                "List email was queued.\n" +
                "Close";
        assertEquals(contactsPage.getCreatedNotificationMessage(),expectedMessage);
    }
}
