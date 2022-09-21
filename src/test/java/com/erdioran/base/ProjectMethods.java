package com.erdioran.base;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class ProjectMethods extends AutomationMethods {

    private static final Logger LOGGER = LogManager.getLogger(ProjectMethods.class);

    public static void pageLoad(String url) {

        DriverManager.getDriver().get(url);


    }


    public static int checkText(By by, String expectedText) {

        List<WebElement> elements = DriverManager.getDriver().findElements(by);

        int i = 0;
        int a = 0;
        for (WebElement element : elements) {

            if (!element.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                LOGGER.info(i + ". result description not contain expected text");
                a++;
            }
            i++;
        }
        LOGGER.info(a + " out of " + i + " results do not contain the expected result.");
        return a;

    }

    public static boolean checkFile(String file) {
        String home = System.getProperty("user.home");
        File dir = new File(home + "/Downloads/" + file);
        LOGGER.info("Folder path: " + dir);
        return dir.exists();

    }


    public static void dropdownSelect(By by, String text) {

        Select drop = new Select(DriverManager.getDriver().findElement(by));
        drop.selectByVisibleText(text);
        LOGGER.info(text + "select in dropdown.");

    }

    public static String getFileName(String tabUrl) {
        String fileName = StringUtils.substringBetween(tabUrl, "name=", "&");
        LOGGER.info("File name is " + fileName);
        return fileName;
    }





}
