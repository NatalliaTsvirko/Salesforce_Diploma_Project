package tests;


import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import modals.AccountModal;
import models.Account;
import org.testng.annotations.AfterMethod;
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

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Create account with all data", groups = {"Smoke"})
    @Description("Create account with all data")
    public void createAccountWithAllData() {
        Account testAccount = accountsGenerator.getAccountWithAllData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.parentAccountNameSearch("Weissnat and Sons");
        accountModal.fillForm(testAccount).clickSaveButton();
        assertTrue(accountsPage.isNotificationMessageDisplayed());
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }

    @Test(description = "Create account only with account name", groups = {"Smoke"})
    @Description("Create account only with account name")
    public void createAccountWithAccountName() {
        Account testAccountName = accountsGenerator.getWithAccountName();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.fillForm(testAccountName).clickSaveButton();
        assertTrue(accountsPage.isNotificationMessageDisplayed());
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccountName, "Account details don't match test account data");
    }

    @Test(description = "Search account name on account page",groups = {"Regression"})
    @Description("Search account name on account page")
    public void searchAccount(){
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink();
        accountsPage.setAccountName("Huels Inc");
        String expectedName = "Huels Inc";
        assertEquals(accountsPage.getAccountName(),expectedName);
    }
}