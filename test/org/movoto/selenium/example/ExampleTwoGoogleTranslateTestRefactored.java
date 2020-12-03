package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ExampleTwoGoogleTranslateTestRefactored {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String GOOGLE_TRANSLATE_URL = "https://translate.google.com/";
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
    public void testGoogleTranslate() throws IOException {
        testHelper.visit(GOOGLE_TRANSLATE_URL);
        testHelper.clickOnMoreLanguagesButton();
        testHelper.clickOnAutoDetectLanguageButton();
        testHelper.clickOnOption("ar");
        testHelper.clickOnMoreLanguagesButton();
        WebElement translationTextBox = testHelper.getElementByClassName("er8xn");
        translationTextBox.sendKeys("software engineer");
        testHelper.getElementContains("مهندس برمجيات");
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
