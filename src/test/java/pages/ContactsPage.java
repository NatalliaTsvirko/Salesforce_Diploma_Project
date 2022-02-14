package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ContactsPage extends BasePage {

    private final String contactCheckbox = "//a[text()='%s']//ancestor::tr//span[@class='slds-checkbox--faux']";
    private static final By COLUMN_NAME = By.xpath("//span[@title='Name']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//a[@title='Send List Email']");
    private static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    private static final By SUBJECT_INPUT = By.xpath("//input[@placeholder='Enter Subject...']");
    private static final By IFRAME = By.xpath("//iframe[@title='CK Editor Container']");
    private static final By IFRAME_SECOND = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
    private static final By TEXT_BOX_IFRAME = By.xpath("//body[contains(@class,'cke_editable')]");
    private static final By SAVE_BUTTON_ON_LIST_EMAIL = By.xpath("//button[@type='button' and text()='Send']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(COLUMN_NAME);
    }

    @Override
    public ContactsPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Open detail page after creating an contact")
    public ContactDetailsPage openDetailsTab() {
        log.info("open details contacts table");
        driver.findElement(DETAILS_TAB).click();
        return new ContactDetailsPage(driver);
    }

    @Step("Send list email to contact")
    public void selectContactCheckbox(String contactName) {
        driver.findElement(By.xpath(String.format(contactCheckbox, contactName))).click();

    }

    @Step("Click button 'send email list'")
    public void clickButtonSendEmail() {
        driver.findElement(SEND_EMAIL_BUTTON).click();
    }

    @Step("Fill form send list")
    public void fillSendList(String subject, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUBJECT_INPUT));
        driver.findElement(SUBJECT_INPUT).sendKeys(subject);
        driver.findElement(IFRAME).click();
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(IFRAME_SECOND));
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(TEXT_BOX_IFRAME);
        textBox.click();
        textBox.sendKeys(text);
        driver.switchTo().defaultContent();
        driver.findElement(SAVE_BUTTON_ON_LIST_EMAIL).click();

    }

}
