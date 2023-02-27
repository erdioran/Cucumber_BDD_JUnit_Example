package com.erdioran.definitions;


import com.erdioran.base.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.erdioran.base.ProjectMethods.*;
import static com.erdioran.base.AutomationMethods.click;
import static com.erdioran.objectRepository.DocumentPageOR.*;
import static com.erdioran.objectRepository.HomePageOR.*;
import static com.erdioran.objectRepository.SearchPageOR.*;
import static com.erdioran.objectRepository.TopBarOR.*;
import static com.erdioran.utils.DataManager.getData;
import static com.erdioran.utils.Helper.sleepInSeconds;
import static org.junit.Assert.assertTrue;

public class CaseDefinitions {

    WebDriver driver = DriverManager.getDriver();


    private static final Logger LOGGER = LogManager.getLogger(CaseDefinitions.class);


    @Given("open login page")
    public void loginPage() {
        pageLoad(getData("url.base") + getData("url.login"));
        LOGGER.info("user is on login page");
    }



    @When("select {string} page in top menu")
    public void selectPageInTopMenu(String categoryName) {
        clickTopMenu(categoryName);
        LOGGER.info("user is redirect to " + categoryName + " page");
    }

    @Given("Login with test user data")
    public void loginWithTestUserData() {

    }


    @Then("{string} text is on the product list title")
    public void textIsOnTheProductListTitle(String title) {
        Assert.assertTrue(elementVisibiltyWithSize(By.xpath("//h1[normalize-space()='"+title+"']")));
    }

    @Given("open home page")
    public void openHomePage() {
        pageLoad(getData("url.base"));
    }

}
