package com.erdioran.base;


import com.erdioran.utils.ConfigManager;
import com.erdioran.utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class AutomationMethods {

    private static final Logger LOGGER = LogManager.getLogger(AutomationMethods.class);

    public static void enterText(By by, String textToEnter) {
        WebElement element = findObject(by);
        element.clear();
        element.sendKeys(textToEnter);
    }

    public static String getText(By by) {
        return findObject(by).getText().trim();
    }

    public static WebElement findObject(By by) {
        FluentWait<WebDriver> wait = getFluentWait();
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static List<WebElement> waitAllElement(By selector) {
        FluentWait<WebDriver> wait = getFluentWait();
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }


    public static void click(By by) {
        waitForIntervalsAndClick(by, 1, ConfigManager.getExplicitWaitTime());
    }


    public static void waitForIntervalsAndClick(By by, int interval, int maxWait) {
        boolean elementExists = false;
        int counter = 0;
        while (counter <= maxWait) {
            try {
                DriverManager.getDriver().findElement(by).click();
                elementExists = true;
                counter = maxWait + 1;
            } catch (Exception e) {
                LOGGER.info("Web element [{}] | Click attempt : [{}]", by.toString(), counter);
                Helper.sleepInSeconds(interval);
                counter++;
                elementExists = false;
            }
        }
        if (!elementExists) {
            DriverManager.getDriver().findElement(by).click();
        }
    }


    public static FluentWait<WebDriver> getFluentWait(int intervalInSeconds, int maxWaitTimeInSeconds) {
        return new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(intervalInSeconds))
                .pollingEvery(Duration.ofSeconds(maxWaitTimeInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementNotVisibleException.class);
    }

    public static FluentWait<WebDriver> getFluentWait() {
        return getFluentWait(1, ConfigManager.getExplicitWaitTime());
    }

    public static void switchToTab() {

        String main = DriverManager.getDriver().getWindowHandle();
        for (String windowHandle : DriverManager.getDriver().getWindowHandles()) {
            if (!main.contentEquals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
                LOGGER.info("Tab switch");
                break;
            }
        }
    }

    public static int getTabCount() {
        return DriverManager.getDriver().getWindowHandles().size();
    }

    public static String getTabUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }




}
