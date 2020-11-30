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

/**
 * Created by haozuo on 3/22/16.
 */
public class ChromeTest {

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
        visit(DEVSQUADS_URL);
        WebElement aboutTab = getElementByText("About");
        hoverOver(aboutTab);
        getElementByCssSelector("a[href=\"./team.html\"]").click();
        getElementContains("Amr Elssamadisy");
    }

    private void hoverOver(WebElement aboutTab) {
        Actions a = new Actions(driver);
        a.moveToElement(aboutTab).perform();
    }

    private WebElement getElementByText(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text() = '" + text + "']"));
    }

    private WebElement getElementContains(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text()[contains(.,'" + text + "')]]"));
    }

    private void visit(String url) {
        driver.get(url);
    }

    private WebElement getElementByCssSelector(String cssSelector) {
        return waitForElementToBeVisible(By.cssSelector(cssSelector));
    }

    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
