package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitForElement (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy) {
        waitForElement(elementBy);
        driver.findElement(elementBy).click();
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

    public void assertEquals_n (By elementBy, String ExpectedText) {
        waitForElement(elementBy);
        Assert.assertEquals(readText(elementBy), ExpectedText);
    }

    public String readText (By elementBy) {
        waitForElement(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public boolean isDisplayed (By elementBy) {
        return driver.findElement(elementBy).isDisplayed();
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