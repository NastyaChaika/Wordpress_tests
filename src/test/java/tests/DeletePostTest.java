package tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.MainPage;
import pages.PostPage;

public class DeletePostTest extends BaseTest {
    @Test (description = "Delete a recently added post")
    public void deletePost () throws NoSuchElementException {
        PageFactory.initElements(driver, MainPage.class)
                // Navigate to the main page
                .navigateToMainPage()
                // Navigate to all added posts list
                .navigateToAllPosts()
                // Delete post
                .deletePost(postUrl);
    }
}