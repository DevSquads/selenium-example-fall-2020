package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ExampleTwoDevSquadsTest {

    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String DEVSQUADS_URL = "https://devsquads.com/";
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
    public void testDevSquadsAboutPage() throws IOException {
        driver.get(DEVSQUADS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement aboutTab = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'About']")));
        Actions a = new Actions(driver);
        a.moveToElement(aboutTab).perform();
        WebElement team = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href=\"./team.html\"]")));
        team.click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'Amr Elssamadisy')]]")));
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
