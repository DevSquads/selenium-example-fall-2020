package org.movoto.selenium.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ExampleOneGoogleTranslateTest {
    public static final String PATH_TO_WEBDRIVER = "./lib/webdriver/chromedriver_mac";
    public static final String GOOGLE_TRANSLATE_URL = "https://translate.google.com/";
    private WebDriver driver;

    @Before
    public void prepare() {
        System.setProperty(
                "webdriver.chrome.driver",
                PATH_TO_WEBDRIVER);
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTranslate() throws IOException {
        driver.get(GOOGLE_TRANSLATE_URL);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement moreLanguagesButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label=\"More target languages\"]"))
        );
        moreLanguagesButton.click();
        WebElement arabicLanguageOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-language-code=\"ar\"]"))
        );
        arabicLanguageOption.click();
        moreLanguagesButton.click();
        WebElement translationTextBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("er8xn")));
        translationTextBox.sendKeys("software engineer");
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'مهندس برمجيات')]]")));
    }

    @After
    public void teardown() throws IOException {
        driver.quit();
    }

}
