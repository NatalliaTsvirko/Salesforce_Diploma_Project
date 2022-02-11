package pages;

import elements.LightningFormattedElement;
import enums.AccountType;
import enums.Industry;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }

    public Account getAccountDetailsInfo() {
        Account account = Account.builder().build();

        log.info(String.format("Filling form with account info: $s", account));

        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (accountName != null) {
            account.setAccountName(accountName);
        }

        AccountType accountType = AccountType.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountType != null) {
            account.setType(accountType);
        }

        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != null) {
            account.setParentAccount(parentAccount);
        }

        String accountWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (accountWebsite != null) {
            account.setWebsite(accountWebsite);
        }

        String accountPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (accountPhone != null) {
            account.setPhone(accountPhone);
        }

        String accountDescription = new LightningFormattedElement(driver, "Description").getText();
        if (accountDescription != null) {
            account.setDescription(accountDescription);
        }

        Industry accountIndustry = Industry.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountIndustry != null) {
            account.setIndustry(accountIndustry);
        }

        String accountEmployees = new LightningFormattedElement(driver, "Employees").getText();
        if (accountEmployees != null) {
            account.setEmployees(accountEmployees);
        }
        String accountBillingAddress = new LightningFormattedElement(driver, "Billing Address").getText();
        if (accountBillingAddress != null) {
            account.setBillingAddress(accountBillingAddress);
        }

        String accountShippingAddress = new LightningFormattedElement(driver, "Shipping Address").getText();
        if (accountShippingAddress != null) {
            account.setShippingAddress(accountShippingAddress);
        }
        return account;

    }

}
