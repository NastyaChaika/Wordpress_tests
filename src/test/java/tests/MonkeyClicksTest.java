package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MonkeyPage;

public class MonkeyClicksTest extends BaseTest {

    @Test(description = "Test with the number of clicks")
    @Parameters({"NUMBEROFCLICKS"})
    public void MonkeyClicksTest (int numberOfClicks) {
        MonkeyPage monkeyPage = new MonkeyPage(driver);

        for (int i = 0; i < numberOfClicks; i++) {
            monkeyPage.monkeyClick(i);
        }
    }
}
