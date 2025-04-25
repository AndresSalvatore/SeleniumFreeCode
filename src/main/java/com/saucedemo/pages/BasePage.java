package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private final long defaultWaitTimeoutSeconds = 10;
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTimeoutSeconds));
    }
    public WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public abstract boolean isPageLoaded();


    protected WebElement waitForElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementPresent(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean waitForElementNotVisible(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean waitForTextToBePresent(By locator, String text){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }

    //DropDowns container

    private Select findDropDown(By locator){
        return new Select(driver.findElement(locator));
    }

    public void selectByVisibleValue(By locator, String text){
        findDropDown(locator).selectByVisibleText(text);
    }

    public void selectByIndex(By locator, int value)
    {
        findDropDown(locator).selectByIndex(value);
    }

    public void selectByVisibleText(By locator, String text){
        findDropDown(locator).selectByVisibleText(text);
    }



    protected WebElement find(By locator) {

        return waitForElementPresent(locator);

    }

    //Send Keys method wait for
    protected void set(By locator, String text){
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator){
        waitForElementClickable(locator).click();
    }

    protected String getElement(By locator){
        return waitForElementVisible(locator).getText();
    }
}















