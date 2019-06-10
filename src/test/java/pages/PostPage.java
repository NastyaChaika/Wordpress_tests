package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends BasePage {

    // Elements of the Post page
    private By fldPageTitle = By.xpath("//*[@class='entry-title']");
    private By fldPageText = By.xpath("//*[@class='entry-content']");

    public PostPage (WebDriver driver) {
        super(driver);
    }

    // Check that the post page is correct
    public PostPage checkResults(String title, String bodyText) {
        String actualTitle = getText(fldPageTitle);
        String actualText = getText(fldPageText);
        if (actualTitle.equals(title) && actualText.equals(bodyText))
            System.out.println("Post is added. Test case is PASSED.");
        else
            System.out.println("Test case is FAILED. \n" + "Title : \n" + actualTitle + "\nText: \n" + actualText);
        return this;
    }

    public PostPage checkResults(String title) {
        String actualTitle = getText(fldPageTitle);
        if (actualTitle.equals(title))
            System.out.println("Post is added. Test case is PASSED.");
        else
            System.out.println("Test case is FAILED. \n" + "Title : \n" + actualTitle);
        return this;
    }
}