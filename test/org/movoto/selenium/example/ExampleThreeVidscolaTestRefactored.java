package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by haozuo on 3/22/16.
 */
public class ExampleThreeVidscolaTestRefactored {

    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String VIDSCOLA_URL = "https://vidscola.com/";
    private WebDriver driver;
    private TestHelper testHelper;

    @Before
    public void prepare() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        driver = new ChromeDriver();
        testHelper = new TestHelper(driver);
    }

    @Test
    public void testDevSquadsAboutPage() throws IOException {
        testHelper.visit(VIDSCOLA_URL);
        WebElement searchBarIcon = testHelper.getElementByClassName("navbar-search__toggle");
        searchBarIcon.click();
        WebElement searchBar = testHelper.getElementByName("s");
        searchBar.sendKeys("testing automation");
        searchBar.sendKeys(Keys.ENTER);
        WebElement agileTestingAutomationCourse = testHelper.getElementByXPath("//*[@id=\"post-662\"]/div/div[3]/h3/a");
        agileTestingAutomationCourse.click();
        WebElement courseTitle = testHelper.getElementByClassName("course__title");
        String expectedText = "AGILE TESTING AUTOMATION WORKSHOP";
        String actualText = courseTitle.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
