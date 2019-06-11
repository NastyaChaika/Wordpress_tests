package pages;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

public class MonkeyPage extends BasePage {
    public final String[] elementsArray = {"button", "a", "label", "checkbox", "input", "link", "textarea"};

    public MonkeyPage(WebDriver driver) {
        super(driver);
    }

    public void monkeyClick (int i) {
        WebElement element = getRandomElementByXpath();
        try {
            click(element);
        }
        catch (Exception e) {
            i--;
        }
    }

    public void monkeyClick () {
        WebElement element = getRandomElementByXpath();
        try {
            click(element);
        }
        catch (Exception e) { }
    }

    private WebElement getRandomElementByXpath () {
        By elementBy = getRandomXpath();
        List<WebElement> webElementList = driver.findElements(elementBy);
        WebElement element = null;
        if (webElementList.size() != 0) {
            for (int i = 0; i < webElementList.size(); i++) {
                element = webElementList.get(i);
                try {
                    if (element == null || !isDisplayed(element) || !isEnabled(element))
                        webElementList.remove(i);
                }
                catch (Exception e) {
                    webElementList.remove(i);
                }
            }
            element = getRandomElementFromList(webElementList);
        }
        return (element);
    }

    private WebElement getRandomElementFromList(List<WebElement> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private By getRandomXpath () {
        Random random = new Random();
        return (By.xpath("//" + elementsArray[random.nextInt(7)]));
    }
}
