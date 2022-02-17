package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login users with valid data",groups = {"Smoke","Regression"})
    @Description("Login users with valid data")
    public void positiveLogin() {
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
    }

    @Test(description = "logout user",groups = {"Smoke"})
    @Description("logout user")
    public void logoutUser(){
        boolean isLoggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
        homePage.clickProfileButton()
                .clickLogoutLink();
        assertTrue(loginPage.isPageOpened());
    }
}
