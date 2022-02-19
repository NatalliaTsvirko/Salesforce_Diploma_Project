package modals;

import elements.DropdownCalendarGroups;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

@Log4j2
public class GroupsModal extends BaseModal {


    private final static By INPUT_NAME = By.xpath("//input[@class=' input']");
    private final static By TEXT_BOX = By.xpath("//div[@aria-label='Compose text']");
    private final static By SAVE_AND_NEXT_BUTTON = By.xpath("//span[text()='Save & Next']//ancestor::button[contains(@class,'next')]");
    private static final By CHOOSE_FILE_BUTTON = By.xpath("//input[@type='file']");
    private static final By NEXT_BUTTON = By.xpath("//span[text()='Next']/ancestor::button[contains(@class,'next')]");
    private static final By DONE_BUTTON = By.xpath("//span[text()='Done']/ancestor::button[contains(@class,'finish')]");
    private static final By GROUP_DETAILS_TEXT = By.xpath("//span[@title='Group Details']");

    public GroupsModal(WebDriver driver) {
        super(driver);
    }

    public GroupsModal fillForm(Group group) {

        log.info(String.format("Filling form with group info: %s", group));

        if (group.getName() != null) {
            driver.findElement(INPUT_NAME).sendKeys(group.getName());
        }

        if (group.getDescription() != null) {
            new TextArea(driver, "Description").write(group.getDescription());
        }

        if (group.getInformation() != null) {
            driver.findElement(TEXT_BOX).sendKeys(group.getInformation());
        }

        if (group.getAccessType() != null) {
            new DropdownCalendarGroups(driver, "Access Type").selectOptions(group.getAccessType().getName());
        }

        return this;
    }

    @Step("Click on button 'save&next'")
    public void clickOnSaveButton() {
        log.info("Click on button save");
        driver.findElement(SAVE_AND_NEXT_BUTTON).click();
    }

    @Step("Upload image for groups")
    public void chooseFile(String pathName) {
        WebElement input = driver.findElement(CHOOSE_FILE_BUTTON);
        File file = new File(pathName);
        input.sendKeys(file.getAbsolutePath());
        wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DONE_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GROUP_DETAILS_TEXT));
    }

}
