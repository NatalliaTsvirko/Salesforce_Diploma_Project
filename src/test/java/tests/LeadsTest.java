package tests;

import lombok.extern.log4j.Log4j2;
import modals.LeadsModal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.LeadsDetailsPage;
import pages.LeadsPage;
import utils.AllureUtils;
import utils.LeadsGenerator;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


@Log4j2
public class LeadsTest extends BaseTest {

    private String expectedMessage;
    HomePage homePage;
    AccountsPage accountsPage;
    LeadsPage leadsPage;
    LeadsModal leadsModal;
    LeadsDetailsPage leadsDetailsPage;
    LeadsGenerator leadsGenerator;

    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        leadsPage = new LeadsPage(driver);
        leadsModal = new LeadsModal(driver);
        leadsDetailsPage = new LeadsDetailsPage(driver);
        leadsGenerator = new LeadsGenerator();

    }

    @Test(description = "Create leads page",retryAnalyzer = ReTry.class , groups = {"Smoke"})
    public void createLeadsPage() {
        expectedMessage = "Your lead has been converted";
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        AllureUtils.attachScreenshot(driver);
        log.info("opening account page");
        homePage.clickLeadsMenuLink()
                .clickNewButton();
        leadsModal.fillForm(leadsGenerator.getLeadsWithAllData()).clickSaveButton();
        leadsPage.verifyNotificationMessage();
        log.info("Clicking on button Status");
        leadsDetailsPage.clickButtonStatus();
        leadsDetailsPage.clickConvertButton();
        AllureUtils.attachScreenshot(driver);
        String actualMessage = leadsDetailsPage.verifyNotificationMessage().getText();
        assertEquals(actualMessage, expectedMessage);

    }

    @Test(description = "Delete leads page", groups = {"Smoke"})
    public void deleteLead(){
        String leadName = "awef";
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickLeadsMenuLink();
        leadsPage.deleteLeads(leadName);
        leadsPage.clickDeleteButton();
        int numberOfElements =leadsPage.verifyElementNotOnPage(leadName);
        assertEquals(String.valueOf(numberOfElements), 0, "Element on page");

    }

}

