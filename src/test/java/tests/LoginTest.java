package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(description = "Login as admin to your website's configurator")
    @Parameters({"LOGIN", "PASSWORD", "FINISH_URL"})
    public void loginToWebsiteTest(String login, String password, String finishUrl) throws NoSuchElementException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loginWithoutRemember(login, password)
                .compareUrls(finishUrl);
    }
}
