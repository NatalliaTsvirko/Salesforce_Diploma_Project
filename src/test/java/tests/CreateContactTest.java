package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import modals.ContactsModal;
import models.Contact;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookie() {
        homePage.logOut();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Create contact with all data", groups = {"Smoke", "Regression"})
    @Description("Create contact with all data")
    public void createContactWithAllData() {
        Contact testContact = contactsGenerator.getContactsWithAllData();
        homePage.clickContactsMenuLink()
                .clickNewButton();
        contactsModal.selectAccountName("Raynor-Boehm");
        contactsModal.fillForm(testContact).clickSaveButton();
        assertTrue(contactsPage.isNotificationMessageDisplayed());
        Contact actualContactsDetailsInfo = contactsPage.openDetailsTab()
                .getContactsDetailsInfo();
        assertEquals(actualContactsDetailsInfo, testContact, "Contacts details don't match test account data");
    }

    @Test(description = "Send email list to contact", groups = {"Smoke"})
    @Description("Send email list to contact")
    public void sendEmailList() {
        homePage.clickContactsMenuLink();
        contactsPage.setContactCheckbox("Bernardina Gerlach");
        contactsPage.clickButtonSendEmail();
        contactsPage.fillFormSendList("Hello", "All cool");
        assertTrue(contactsPage.isNotificationMessageDisplayed());
    }
}
