package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ExampleThreeVidscolaTest {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String VIDSCOLA_URL = "https://vidscola.com/";
    private WebDriver driver;

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
    }

    @Test
    public void testVidscola() throws IOException {
        driver.get(VIDSCOLA_URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("navbar-search__toggle"))
        );
        searchIcon.click();
        WebElement searchBar = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("s"))
        );
        searchBar.sendKeys("testing automation");
        searchBar.sendKeys(Keys.ENTER);
        WebElement agileTestingAutomationCourse = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-662\"]/div/div[3]/h3/a"))
        );
        agileTestingAutomationCourse.click();
        WebElement courseTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("course__title"))
        );
        Assert.assertEquals(courseTitle.getText(), "AGILE TESTING AUTOMATION WORKSHOP");
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }
}
