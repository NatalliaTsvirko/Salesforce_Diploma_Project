package tests;


import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import modals.AccountModal;
import models.Account;
import org.testng.annotations.*;
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

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.open().login(USERNAME, PASSWORD);

    }

    @AfterMethod(alwaysRun = true)
    public void clearCookie() {
        homePage.logOut();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }

    @Test(description = "Create account with all data", dataProvider = "Create account with different data", groups = {"Smoke"})
    @Description("Create account with all data")
    public void createAccount(Account testAccount) {
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.parentAccountNameSearch("Jospeh");
        accountModal.fillForm(testAccount).clickSaveButton();
        assertTrue(accountsPage.isNotificationMessageDisplayed());
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");

    }

    @DataProvider(name = "Create account with different data")
    public Object[][] getAccountData() {
        return new Object[][]{
                {accountsGenerator.getAccountWithAllData()},
                {accountsGenerator.getWithAccountName()}
        };
    }

    @Test(description = "Search account name on account page", groups = {"Regression"})
    @Description("Search account name on account page")
    public void searchAccount() {
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink();
        accountsPage.setAccountName("Runolfsson, Schiller and Bailey");
        String expectedName = "Runolfsson, Schiller and Bailey";
        assertEquals(accountsPage.getAccountName(), expectedName);

    }
}