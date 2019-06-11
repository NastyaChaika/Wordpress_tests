package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public void waitForElement (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitForElement (WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click (By elementBy) {
        waitForElement(elementBy);
        driver.findElement(elementBy).click();
    }

    public void click (WebElement element) {
 //       waitForElement(element);
        element.click();
    }

    public void inputText (By elementBy, String text) {
        waitForElement(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void clickAndInputText (By elementBy, String text) {
        waitForElement(elementBy);
        driver.findElement(elementBy).click();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By elementBy) {
        waitForElement(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public boolean isDisplayed (By elementBy) {
        return driver.findElement(elementBy).isDisplayed();
    }

    public boolean isDisplayed (WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnabled (WebElement element) {
        return element.isEnabled();
    }

    public String getText (By elementBy) {
        waitForElement(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public String getUrlOfPost() {
        String path = "";
        try {
            String strUrl = driver.getCurrentUrl();
            URL url = new URL(strUrl);
            path = url.getPath();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        return path;
    }

    public void compareUrls(String url) {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), url);
        }
        catch (AssertionError e) {
            System.out.println("URL is incorrect: " + e.getMessage());
        }
    }
}