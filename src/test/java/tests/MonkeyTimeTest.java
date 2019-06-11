package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MonkeyPage;

import java.util.concurrent.TimeUnit;

public class MonkeyTimeTest extends BaseTest {

    @Test(description = "Test with the number of clicks")
    @Parameters({"TIME"})
    public void MonkeyTimeTest(int time) {
        MonkeyPage monkeyPage = new MonkeyPage(driver);
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(time); stop > System.nanoTime(); ) {
            monkeyPage.monkeyClick();
        }
    }
}
