package pages;

import org.openqa.selenium.*;

public class MainPage extends BasePage {

    // Elements of the Main page
    By btnCreatePage = By.xpath("//*[@class='welcome-icon welcome-write-blog']");
    By btnCloseHelp = By.xpath("//*[@class='components-button components-icon-button nux-dot-tip__disable']");
    By linkToMainPage = By.xpath("//*[@id='wp-admin-bar-site-name']/a");
    By linkToAllPosts = By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-post']");
    By actionsList = By.id("bulk-action-selector-top");
    By deletePostDropdown = By.xpath("//*[@id='bulk-action-selector-top']/option[@value='trash']");
    By btnDoAction = By.id("doaction");

    public MainPage (WebDriver driver) {
        super(driver);
    }

    public void createNewPage() {
        driver.navigate().to("http://localhost:8888/wordpress/wp-admin/post-new.php");
        try {
            click(btnCloseHelp);
        }
        catch (NoSuchElementException e) { }
    }

    public MainPage navigateToMainPage() {
        click(linkToMainPage);
        return this;
    }

    public MainPage navigateToAllPosts() {
        click(linkToAllPosts);
        return this;
    }

    public MainPage deletePost(String url) {
        By chkbxPost = By.xpath("//*[contains(@href, '" + url + "')]/../../../..//*[@class='check-column']/input");
        click(chkbxPost);
        click(actionsList);
        click(deletePostDropdown);
        click(btnDoAction);
        try {
            driver.findElement(chkbxPost).isDisplayed();
            System.out.println("Post is not deleted. Test case is FAILED.");
        }
        catch(NoSuchElementException e) {
            System.out.println("Post is deleted. Test case is PASSED.");
        }
        return this;
    }
}