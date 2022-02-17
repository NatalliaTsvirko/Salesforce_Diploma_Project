package pages;

import elements.GroupDetailElement;
import lombok.extern.log4j.Log4j2;
import models.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class GroupDetailsPage extends BasePage {

    private static final By TITLE_PAGE = By.xpath("//span[@title='Sales']");

    public GroupDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE_PAGE);
    }

    @Override
    public GroupDetailsPage open() {
        driver.get(BASE_URL + "/lightning/r/CollaborationGroup/0F95j000000kJiOCAU/view");
        return this;
    }

    public Group getGroupsDetailsInfo() {

        Group groups = Group.builder().build();

        log.info(String.format("Filling form with account info: %s", groups));

        String groupsDescription = new GroupDetailElement(driver, "Description").getTextDescription();
        if (groupsDescription != "" ) {
            groups.setDescription(groupsDescription);
        }

        String groupsInformation = new GroupDetailElement(driver, "Information").getTextInformation();
        if (groupsInformation != "" ) {
            groups.setInformation(groupsInformation);
        }
        return groups;
    }

}
