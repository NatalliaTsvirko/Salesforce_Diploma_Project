package pages;

import elements.LightningFormattedElement;
import enums.AccountType;
import enums.Industry;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {

    private static final By TITLE_DETAILS = By.xpath("//li[@title='Details']");
    private static final By HOME_LINK = By.xpath("//a[@title='Home']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE_DETAILS);
    }

    @Override
    public AccountDetailsPage open() {
        driver.get(BASE_URL + "lightning/r/Account/0015j00000XaFT1AAN/view");
        return this;
    }

    public Account getAccountDetailsInfo() {
        Account account = Account.builder().build();

        log.info(String.format("Filling form with account info: %s", account));

        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (accountName != "") {
            account.setAccountName(accountName);
        }

        AccountType accountType = AccountType.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountType != null) {
            account.setType(accountType);
        }

        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            account.setParentAccount(parentAccount);
        }

        String accountWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (accountWebsite != "") {
            account.setWebsite(accountWebsite);
        }

        String accountPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (accountPhone != "") {
            account.setPhone(accountPhone);
        }

        String accountDescription = new LightningFormattedElement(driver, "Description").getText();
        if (accountDescription != "") {
            account.setDescription(accountDescription);
        }

        Industry accountIndustry = Industry.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountIndustry != null) {
            account.setIndustry(accountIndustry);
        }

        String accountEmployees = new LightningFormattedElement(driver, "Employees").getText();
        if (accountEmployees != "") {
            account.setEmployees(accountEmployees);
        }
        String accountBillingAddress = new LightningFormattedElement(driver, "Billing Address").getText();
        if (accountBillingAddress != "") {
            account.setBillingAddress(accountBillingAddress);
        }

        String accountShippingAddress = new LightningFormattedElement(driver, "Shipping Address").getText();
        if (accountShippingAddress != "") {
            account.setShippingAddress(accountShippingAddress);
        }
        return account;

    }

    @Step("Click home link")
    public void clickHomeLink() {
        log.info("open home page");
        jsClick(driver.findElement(HOME_LINK));

    }
}
