package org.movoto.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOver(WebElement aboutTab) {
        Actions a = new Actions(driver);
        a.moveToElement(aboutTab).perform();
    }
    public WebElement getElementByText(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text() = '" + text + "']"));
    }
    public WebElement getElementContains(String text) {
        return waitForElementToBeVisible(By.xpath("//*[text()[contains(.,'" + text + "')]]"));
    }
    public WebElement getElementByCssSelector(String cssSelector) {
        return waitForElementToBeVisible(By.cssSelector(cssSelector));
    }
    private WebElement waitForElementToBeVisible(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public WebElement getElementById(String id) {
        return waitForElementToBeVisible(By.id(id));
    }
    public void visit(String url) {
        driver.get(url);
    }
    private WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }
    public void searchGoogleFor(String keyword) {
        WebElement searchBox = getElementByName("q");
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.ENTER);
    }
}
