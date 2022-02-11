package modals;

import elements.Dropdown;
import elements.Input;
import elements.TextArea;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AccountsPage;

@Log4j2
public class AccountModal extends BaseModal {
    private String listLocator = "//span[text()='Parent Account']";
    private String optionLocator = "//a[@role='option']//div[@title='%s']/ancestor::ul[@class='lookup__list  visible']";

    final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");


    public AccountModal(WebDriver driver) {
        super(driver);
    }

    public AccountModal fillForm(Account account) {

        log.info(String.format("Filling form with account info: $s",account));

        if(account.getAccountName()!= null){
            new Input(driver, "Account Name").write(account.getAccountName());
        }

        if(account.getType()!= null){
            new Dropdown(driver, "Type").selectOption(account.getType().getName());
        }

        if(account.getWebsite()!= null){
            new Input(driver, "Website").write(account.getWebsite());
        }

        if(account.getDescription()!=null){
            new TextArea(driver, "Description").write(account.getDescription());
        }

        if(account.getPhone()!= null){
            new Input(driver, "Phone").write(account.getPhone());
        }

        if(account.getIndustry()!= null){
            new Dropdown(driver, "Industry").selectOption(account.getIndustry().getName());
        }

        if(account.getEmployees()!= null){
            new Input(driver, "Employees").write(account.getEmployees());
        }

        if(account.getBillingStreet()!= null){
            new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        }

        if(account.getShippingStreet()!= null){
            new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        }

        if(account.getBillingCity()!= null){
            new Input(driver, "Billing City").write(account.getBillingCity());
        }

        if(account.getShippingCity()!= null){
            new Input(driver, "Shipping City").write(account.getShippingCity());
        }

        if(account.getBillingStateProvince()!= null){
            new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        }

        if(account.getShippingStateProvince()!= null){
            new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        }

        if(account.getBillingZipPostalCode()!= null){
            new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        }

        if(account.getShippingZipPostalCode()!= null){
            new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        }

        if(account.getBillingCountry()!= null){
            new Input(driver, "Billing Country").write(account.getBillingCountry());
        }

        if(account.getShippingCountry()!= null){
            new Input(driver, "Shipping Country").write(account.getShippingCountry());
        }
        return this;
    }

    public void selectOption(String optionName) {
        WebElement searchFieldToClick = driver.findElement(By.xpath(String.format(listLocator)));
        searchFieldToClick.click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        optionToClick.click();
    }

    public AccountsPage clickSaveButton() {
        log.info("click save button on accounts modal");
        driver.findElement(SAVE_BUTTON).click();
        return new AccountsPage(driver);
    }

}


