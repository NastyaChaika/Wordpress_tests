package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.*;

public class PostPageTest extends BaseTest {

    @Test (description = "Login as admin to your website's configurator")
    @Parameters({"LOGIN", "PASSWORD", "FINISH_URL"})
    public void loginToWebsiteTest(String login, String password, String finishUrl) throws NoSuchElementException {
        PageFactory.initElements(driver, LoginPage.class)
                .loginWithoutRemember(login, password)
                .compareUrls(finishUrl);
    }

    @Test (priority = 1, description = "Create a new Post on your website")
    @Parameters({"TITLE", "TEXT"})
    public void createNewPostTest(String title, String text) throws NoSuchElementException {
        // Create a new page
        PageFactory.initElements(driver, MainPage.class)
                .createNewPage();

        PageFactory.initElements(driver, EditPage.class)
                // Fill in title and text on a new page
                .enterPageTitle(title)
                .enterOneLineText(text)
                // Publish a new page
                .publishPage()
                // Navigate to the created page
                .navigateToCreatedPage();

        // Check test results
        PageFactory.initElements(driver, PostPage.class)
                .checkResults(title, text);
    }
}