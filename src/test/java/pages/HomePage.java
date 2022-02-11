package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    final static By SALES_LABEL = By.xpath("//*[@title='Sales']");
    final static By ACCOUNTS_MENU_LINK = By.xpath("//*[@title='Accounts']");
    final static By CONTACTS_MENU_LINK = By.xpath("//*[@title='Contacts']");
    final static By LEADS_MENU_LINK = By.xpath("//*[@title='Leads']");
    final static By PROFILE_BUTTON = By.xpath("//button[contains(@class,'branding-userProfile-button')]");
    final static By LOGOUT_LINK = By.xpath("//a[contains(@class,'logout')]");
    final static By IMG_LOGO = By.xpath("//img[@id='logo']");



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

    @Step("Click on profile button")
    public HomePage clickProfileButton(){
        log.info("open profile contecst menu");
        driver.findElement(PROFILE_BUTTON).click();
        return this;
    }

    @Step("Click on logOut link")
    public boolean clickLogoutLink(){
        log.info("logout user");
        driver.findElement(LOGOUT_LINK).click();
        driver.findElement(IMG_LOGO).isDisplayed();
        return true;
    }
}

