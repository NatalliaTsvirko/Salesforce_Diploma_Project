package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login users with valid data",groups = {"Smoke"})
    public void positiveLogin() {
        log.info("Login users");
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
    }

    @Test(description = "logout user",groups = {"Smoke"})
    public void logoutUser(){
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
        homePage.clickProfileButton();
        boolean isLogOut = homePage.clickLogoutLink();
        assertTrue(isLogOut);

    }
}
