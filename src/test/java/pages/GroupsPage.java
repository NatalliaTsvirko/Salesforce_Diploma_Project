package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupsPage extends BasePage {

    private final static By NEW_BUTTON = By.xpath("//a[@title='New']");

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(NEW_BUTTON);
    }

    @Override
    public GroupsPage open() {
        driver.get(BASE_URL + "/lightning/o/CollaborationGroup/list?filterName=Recent");
        return this;
    }


}
