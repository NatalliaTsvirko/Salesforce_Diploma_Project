package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import modals.LeadsModal;
import models.Lead;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.LeadsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Log4j2
public class LeadsTest extends BaseTest {

    HomePage homePage;
    AccountsPage accountsPage;
    LeadsPage leadsPage;
    LeadsModal leadsModal;
    LeadsDetailsPage leadsDetailsPage;
    LeadsGenerator leadsGenerator;
    OpportunitiesPage opportunitiesPage;

    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        leadsPage = new LeadsPage(driver);
        leadsModal = new LeadsModal(driver);
        leadsDetailsPage = new LeadsDetailsPage(driver);
        leadsGenerator = new LeadsGenerator();
        opportunitiesPage = new OpportunitiesPage(driver);

    }

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Create new lead", groups = {"Smoke"})
    @Description("Create new lead with status 'New'")
    public void createLeadStatusNew() {
        String expectedStatusNew = "New";
        String expectedStatusWorking = "Working";
        String expectedStatusNurturing = "Nurturing";
        Lead leadName = leadsGenerator.getLeadWithName();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickLeadsMenuLink()
                .clickNewButton();
        leadsModal.fillForm(leadName).clickSaveButton();
        assertTrue(leadsDetailsPage.isNotificationMessageDisplayed());
        leadsDetailsPage.openDetailsTab();
        assertEquals(leadsDetailsPage.getLeadStatus(), expectedStatusNew);
        leadsDetailsPage.clickButtonStatus();
        assertTrue(leadsDetailsPage.isNotificationMessageDisplayed());
        assertEquals(leadsDetailsPage.getLeadStatus(), expectedStatusWorking);
        leadsDetailsPage.clickButtonStatus();
        assertTrue(leadsDetailsPage.isNotificationMessageDisplayed());
        assertEquals(leadsDetailsPage.getLeadStatus(), expectedStatusNurturing);
        leadsDetailsPage.clickButtonStatus();
        leadsDetailsPage.clickConvertButton();
        assertTrue(leadsDetailsPage.isConvertLeadMessageDisplayed());
        leadsDetailsPage.clickButtonGoToLeads();
        opportunitiesPage.clickOpportunityMenuLink();
        assertEquals(opportunitiesPage.getLeadNameOnList(leadName.getCompany()), 1, "Element not found");

    }


    @Test(description = "Create new lead", groups = {"Smoke"})
    @Description("Create new lead with status 'Nurturing'")
    public void createLead() {
        String expectedStatusNurturing = "Nurturing";
        Lead leadName = leadsGenerator.getLeadWithNurturingStatus();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickLeadsMenuLink()
                .clickNewButton();
        leadsModal.fillForm(leadName).clickSaveButton();
        assertTrue(leadsDetailsPage.isNotificationMessageDisplayed());
        leadsDetailsPage.openDetailsTab();
        assertEquals(leadsDetailsPage.getLeadStatus(), expectedStatusNurturing);
        leadsDetailsPage.clickButtonStatus();
        leadsDetailsPage.clickConvertButton();
        assertTrue(leadsDetailsPage.isConvertLeadMessageDisplayed());
        leadsDetailsPage.clickButtonGoToLeads();
        opportunitiesPage.clickOpportunityMenuLink();
        assertEquals(opportunitiesPage.getLeadNameOnList(leadName.getCompany()), 1, "Element not found");

    }


    @Test(description = "Delete lead on page", groups = {"Smoke"})
    @Description("Delete lead on page")
    public void deleteLead() {
        String expectedStatusNurturing = "Nurturing";
        Lead leadName = leadsGenerator.getLeadWithNurturingStatus();
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
        homePage.clickLeadsMenuLink()
                .clickNewButton();
        leadsModal.fillForm(leadName).clickSaveButton();
        assertTrue(leadsDetailsPage.isNotificationMessageDisplayed());
        leadsDetailsPage.openDetailsTab();
        assertEquals(leadsDetailsPage.getLeadStatus(), expectedStatusNurturing);
        leadsDetailsPage.clickButtonStatus();
        leadsDetailsPage.clickConvertButton();
        assertTrue(leadsDetailsPage.isConvertLeadMessageDisplayed());
        leadsDetailsPage.clickButtonGoToLeads();
        opportunitiesPage.clickOpportunityMenuLink();
        leadsPage.deleteLeads(leadName.getCompany());
        assertEquals(opportunitiesPage.getLeadNameOnList(leadName.getCompany()), 0, "Element not found");

    }
}

