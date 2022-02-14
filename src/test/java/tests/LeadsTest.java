package tests;

import lombok.extern.log4j.Log4j2;
import modals.LeadsModal;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.LeadsDetailsPage;
import pages.LeadsPage;
import utils.LeadsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


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

/*I can't assert detail page because after created lead i have only message "Your lead has been converted".
And after close this modal i see only list with leads and i don't know which lead created because i use faker */
    @Test(description = "Create leads ",retryAnalyzer = ReTry.class , groups = {"Smoke"})
    public void createLeads() {
        expectedMessage = "Your lead has been converted";
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickLeadsMenuLink()
                .clickNewButton();
        leadsModal.fillForm(leadsGenerator.getLeadsWithAllData()).clickSaveButton();
        leadsDetailsPage.clickButtonStatus();
        leadsDetailsPage.clickConvertButton();
        String actualMessage =leadsModal.createLeadText();
        assertEquals(actualMessage, expectedMessage);

    }

    /*Here i can't try get notification message because salesforce have trouble with loader modal window(
    And I deleted all the leads... I don't have any more leads */
    @Test(description = "Delete leads page", groups = {"Smoke"})
    public void deleteLead(){
        String leadName = "Cornelia Octavio Grant Goodwin Bednar DVM";
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
        homePage.clickLeadsMenuLink();
        leadsPage.deleteLeads(leadName);
        leadsPage.clickDeleteButton();
        String expectedNotificationMessage = "";
        leadsPage.getCreatedNotificationMessage();
        assertEquals(leadsPage.getCreatedNotificationMessage(), expectedNotificationMessage);
        int numberOfElements =leadsPage.getVisibleLeadsName(leadName);
        assertEquals(numberOfElements, 0, "Element on page");
    }

}

