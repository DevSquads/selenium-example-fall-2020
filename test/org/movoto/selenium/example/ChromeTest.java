package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by haozuo on 3/22/16.
 */
public class ChromeTest {

    private static final String GOOGLE_TEST_URL = "https://www.google.com/";
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
    public void testSearchGoogleForYoutube() throws IOException {
        visit(GOOGLE_TEST_URL);
        searchGoogleFor("youtube");
        getElementByCssSelector("a[href='https://www.youtube.com/']").click();
        getElementById("logo-red-icon-container");
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
        return driver.findElement(By.xpath("//*[text() = '" + text + "']"));
    }

    private WebElement getElementContains(String text) {
        return driver.findElement(By.xpath("//*[text()[contains(.,'" + text + "')]]"));
    }

    private void visit(String url) {
        driver.get(url);
    }

    private WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    private void searchGoogleFor(String keyword) {
        WebElement searchBox = getElementByName("q");
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }

    private WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }

    private WebElement getElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
