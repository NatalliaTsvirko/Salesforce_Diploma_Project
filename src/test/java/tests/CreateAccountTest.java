package tests;


import lombok.extern.log4j.Log4j2;
import modals.AccountModal;
import models.Account;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import utils.AccountsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class CreateAccountTest extends BaseTest {

    AccountsPage accountsPage;
    AccountDetailsPage accountDetailsPage;
    AccountModal accountModal;
    AccountsGenerator accountsGenerator;


    @BeforeClass
    public void initializePages() {
        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        accountModal = new AccountModal(driver);
        accountsGenerator = new AccountsGenerator();
    }

    @Test(description = "Create account with all data", groups = {"Smoke"})
    public void createAccountWithAllData() {
        Account testAccount = accountsGenerator.getAccountWithAllData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.searchParentAccountName("Winston");
        accountModal.fillForm(testAccount).clickSaveButton();
        String expectedMessage = "";
        accountsPage.getCreatedNotificationMessage();
        assertEquals(accountsPage.getCreatedNotificationMessage(), expectedMessage);
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }

    @Test(description = "Create account only with account name", groups = {"Smoke"})
    public void createAccountWithAccountName() {
        Account testAccountName = accountsGenerator.getWithAccountName();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.fillForm(testAccountName).clickSaveButton();
        String expectedMessage = "";
        accountsPage.getCreatedNotificationMessage();
        assertEquals(accountsPage.getCreatedNotificationMessage(), expectedMessage);
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccountName, "Account details don't match test account data");
    }

    @Test(description = "Search account name on account page",groups = {"Regression"})
    public void searchAccount(){
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink();
        accountsPage.inputAccountName("Huels Inc");
        String expectedName = "Huels Inc";
        assertEquals(accountsPage.getAccountName(),expectedName);
    }
}