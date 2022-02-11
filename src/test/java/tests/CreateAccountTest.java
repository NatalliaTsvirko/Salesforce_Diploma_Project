package tests;


import lombok.extern.log4j.Log4j2;
import modals.AccountModal;
import models.Account;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.HomePage;
import utils.AccountsGenerator;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class CreateAccountTest extends BaseTest {

    HomePage homePage;
    AccountsPage accountsPage;
    AccountDetailsPage accountDetailsPage;
    AccountModal accountModal;
    AccountsGenerator accountsGenerator;


    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
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
        AllureUtils.attachScreenshot(driver);
        log.info("opening account page");
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.selectOption("Winston");
        log.info("fill account modal form with all data");
        accountModal.fillForm(testAccount).clickSaveButton();
        AllureUtils.attachScreenshot(driver);
        accountsPage.verifyNotificationMessage();
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }

    @Test(description = "Create account only with account name", groups = {"Negative"})
    public void createAccountWithAccountName() {
        Account testAccountName = accountsGenerator.getWithAccountName();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        AllureUtils.attachScreenshot(driver);
        log.info("opening account page and fill account modal form with account name");
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.fillForm(testAccountName).clickSaveButton();
        AllureUtils.attachScreenshot(driver);
        log.info("verify notification message");
        accountsPage.verifyNotificationMessage();
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccountName, "Account details don't match test account data");
    }

}