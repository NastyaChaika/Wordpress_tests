package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.LoginPage;
import pages.MainPage;
import pages.PostPage;

public class CreatePostTest extends BaseTest {
    @Test (description = "Create a new Post on your website")
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

        // Get URL of the posted page
        postUrl = PageFactory.initElements(driver, PostPage.class)
                .getUrlOfPost();
    }
}
