package pages;

import elements.LightningFormattedElement;
import lombok.extern.log4j.Log4j2;
import models.Groups;
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

    public Groups getGroupsDetailsInfo() {

        Groups groups = Groups.builder().build();

        log.info(String.format("Filling form with account info: %s", groups));

        String groupsDescription = new LightningFormattedElement(driver, "Description").getText();
        if (groupsDescription != null ) {
            groups.setDescription(groupsDescription);
        }

        String groupsInformation = new LightningFormattedElement(driver, "Information").getText();
        if (groupsInformation != null ) {
            groups.setInformation(groupsInformation);
        }
        return groups;
    }
}
