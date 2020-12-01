package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by haozuo on 3/22/16.
 */
public class ExampleTwoDevsquadsTestRefactored {

    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String DEVSQUADS_URL = "https://devsquads.com/";
    private WebDriver driver;
    private TestHelper testHelper;

    @Before
    public void prepare() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        // to run tests in headless mode
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        // driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        testHelper = new TestHelper(driver);
    }

    @Test
    public void testDevSquadsAboutPage() throws IOException {
        testHelper.visit(DEVSQUADS_URL);
        WebElement aboutTab = testHelper.getElementByText("About");
        testHelper.hoverOver(aboutTab);
        testHelper.getElementByCssSelector("a[href=\"./team.html\"]").click();
        testHelper.getElementContains("Amr Elssamadisy");
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
