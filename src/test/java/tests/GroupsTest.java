package tests;

import io.qameta.allure.Description;
import modals.GroupsModal;
import models.Group;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GroupDetailsPage;
import pages.GroupsPage;
import utils.GroupsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GroupsTest extends BaseTest {

    GroupsPage groupsPage;
    GroupsGenerator groupsGenerator;
    GroupsModal groupsModal;
    GroupDetailsPage groupDetailsPage;

    @BeforeClass
    public void initializePages() {
        groupsPage = new GroupsPage(driver);
        groupsGenerator = new GroupsGenerator();
        groupsModal = new GroupsModal(driver);
        groupDetailsPage = new GroupDetailsPage(driver);
    }

    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Create new group",retryAnalyzer = ReTry.class,groups = {"Smoke"})
    @Description("Create new group")
    public void createGroups() {
        Group testGroups = groupsGenerator.getGroupsData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickGroupsLink();
        groupsPage.clickNewButton();
        groupsModal.fillForm(testGroups)
                .clickOnSaveButton();
        groupsModal.chooseFile();
        groupDetailsPage.isPageOpened();
        Group actualGroupDetailsInfo = groupDetailsPage.getGroupsDetailsInfo();
        assertEquals(actualGroupDetailsInfo, testGroups, "Account details don't match test account data");

    }
}
