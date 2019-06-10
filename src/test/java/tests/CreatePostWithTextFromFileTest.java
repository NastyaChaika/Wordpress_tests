package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.MainPage;
import pages.PostPage;

import java.io.IOException;

public class CreatePostWithTextFromFileTest extends BaseTest {
    @Test (description = "Create a new Post on your website")
    @Parameters({"TITLE"})
    public void createNewPostTest(String title) throws IOException {
        PageFactory.initElements(driver, MainPage.class)
                // Create a new page
                .createNewPage();

        PageFactory.initElements(driver, EditPage.class)
                // Fill in title and text on a new page
                .enterPageTitle(title)
                .enterTextFromFile("src/test/resources/PageText.txt")
                // Publish a new page
                .publishPage()
                // Navigate to the created page
                .navigateToCreatedPage();

        postUrl = PageFactory.initElements(driver, PostPage.class)
                // Get URL of the posted page
                .getUrlOfPost();
    }
}
