package com.erdioran.definitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.erdioran.base.AutomationMethods;
import com.erdioran.base.DriverManager;
import com.erdioran.utils.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before()
    public void before() {
// test
        DriverManager.launchBrowser(ConfigManager.getBrowser());

    }


    @After(order = 0)
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(AutomationMethods.getBase64Screenshot()).build());
        }
    }

}
