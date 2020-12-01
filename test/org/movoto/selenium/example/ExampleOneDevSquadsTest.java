package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class ExampleOneDevSquadsTest {

    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String DEVSQUADS_URL = "https://devsquads.com/";
    private WebDriver driver;

    @Before
    public void prepare() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        driver = new ChromeDriver();
    }

    @Test
    public void testDevSquadsAboutPage() throws IOException {
        driver.get(DEVSQUADS_URL);
        driver.findElement(By.xpath("//*[text() = 'What we offer']"));
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
