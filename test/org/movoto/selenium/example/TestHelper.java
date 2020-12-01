package org.movoto.selenium.example;

import org.openqa.selenium.By;
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

    public void hoverOver(WebElement element) {
        Actions a = new Actions(driver);
        a.moveToElement(element).perform();
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

    public WebElement getElementByClassName(String className) {
        return waitForElementToBeVisible(By.className(className));
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

    public void clickOnMoreLanguagesButton() {
        WebElement moreLanguagesButton = getElementByCssSelector("button[aria-label=\"More target languages\"]");
        moreLanguagesButton.click();
    }
    public void clickOnOption(String optionCode) {
        WebElement languageOption = waitForElementToBeVisible(By.cssSelector("button[data-language-code=" + optionCode + "]"));
        languageOption.click();
    }
}
