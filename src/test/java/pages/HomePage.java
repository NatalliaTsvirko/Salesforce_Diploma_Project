package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    private static final By SALES_LABEL = By.xpath("//*[@title='Sales']");
    private static final By ACCOUNTS_MENU_LINK = By.xpath("//*[@title='Accounts']");
    private static final By CONTACTS_MENU_LINK = By.xpath("//*[@title='Contacts']");
    private static final By LEADS_MENU_LINK = By.xpath("//*[@title='Leads']");
    private static final By CALENDAR_MENU_LINK = By.xpath("//a[@title='Calendar']");
    private static final By PROFILE_BUTTON = By.xpath("//button[contains(@class,'branding-userProfile-button')]");
    private static final By LOGOUT_LINK = By.xpath("//a[contains(@class,'logout')]");
    private static final By GROUPS_LINK = By.xpath("//a[@title='Groups']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(SALES_LABEL);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URL + "/lightning/page/home");
        return this;
    }


    @Step("Click account menu link")
    public AccountsPage clickAccountMenuLink() {
        log.info("open account page");
        jsClick(driver.findElement(ACCOUNTS_MENU_LINK));
        return new AccountsPage(driver);
    }

    @Step("Click contacts menu link")
    public ContactsPage clickContactsMenuLink() {
        log.info("open contacts page");
        jsClick(driver.findElement(CONTACTS_MENU_LINK));
        return new ContactsPage(driver);
    }


    @Step("Click leads menu link")
    public LeadsPage clickLeadsMenuLink() {
        log.info("open leads page");
        jsClick(driver.findElement(LEADS_MENU_LINK));
        return new LeadsPage(driver);
    }

    @Step("Click calendar menu link")
    public CalendarPage clickCalendarMenuLink() {
        log.info("open calendar page");
        jsClick(driver.findElement(CALENDAR_MENU_LINK));
        return new CalendarPage(driver);
    }

    @Step("Click on profile button")
    public HomePage clickProfileButton() {
        log.info("open profile contecst menu");
        driver.findElement(PROFILE_BUTTON).click();
        return this;
    }

    @Step("Click on logOut link")
    public void clickLogoutLink() {
        log.info("logout user");
        driver.findElement(LOGOUT_LINK).click();
    }

    @Step("Click on File link")
    public void clickGroupsLink() {
        log.info("Click on 'groups' link");
        jsClick(driver.findElement(GROUPS_LINK));

    }
}

