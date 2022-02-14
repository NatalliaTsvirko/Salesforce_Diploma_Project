package tests;

import modals.GroupsModal;
import models.Groups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GroupsPage;
import utils.GroupsGenerator;

import static org.testng.Assert.assertTrue;

public class GroupsTest extends BaseTest {

    GroupsPage groupsPage;
    GroupsGenerator groupsGenerator;
    GroupsModal groupsModal;

    @BeforeClass
    public void initializePages() {
        groupsPage = new GroupsPage(driver);
        groupsGenerator = new GroupsGenerator();
        groupsModal = new GroupsModal(driver);
    }

    @Test(description = "", groups = {"Smoke"})
    public void createGroups() {
        Groups testGroups = groupsGenerator.getGroupsData();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickGroupsLink();
        groupsPage.clickNewButton();
        groupsModal.fillForm(testGroups)
                .clickOnSaveButton();
        groupsModal.chooseFile();
        //I can't find a unique locator for the "details" form and make assert
    }
}
