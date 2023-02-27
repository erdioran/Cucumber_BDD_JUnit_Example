package com.erdioran.base;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


    public static void clickTopMenu(String menu) {
        click(By.xpath("//li[@class='main-link-wrapper']//a[@title='" + menu + "']"));
        LOGGER.info(menu + " select in left menu.");
    }
}

