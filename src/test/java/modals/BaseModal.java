package modals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseModal {

    protected static final Logger log = LogManager.getLogger(BaseModal.class.getName());

    WebDriver driver;
    WebDriverWait wait;


    public BaseModal(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

}
