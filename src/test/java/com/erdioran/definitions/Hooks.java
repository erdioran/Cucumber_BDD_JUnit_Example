package com.erdioran.definitions;

import com.erdioran.base.DriverManager;
import com.erdioran.utils.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void before() {

        DriverManager.launchBrowser(ConfigManager.getBrowser());

    }


    @After()
    public void after() {

        DriverManager.quitDriver();

    }


}
