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

    public int tabCount;
    public String tabUrl;
    public String fileName;

    @Given("user is on {string} page")
    public void user_is_on_lely_com_page(String url) {
        pageLoad(getData("url." + url));
        LOGGER.info("user is redirect to " + url + " page");

    }

    @And("accept cookies")
    public void accept_cookies() {

        click(ACCEPT_COOKIES_ID);
        LOGGER.info("Clicked accept cookies");

    }

    @When("click search button")
    public void click_search_button() {

        click(SEARCH_BUTTON_XPATH);
        LOGGER.info("click search button");

    }

    @Then("check appeared search bar text area")
    public void check_appeared_search_bar_text_area() {
        boolean displayed = driver.findElement(SEARCH_BAR_TEXT_AREA_ID).isDisplayed();
        assertTrue(displayed);
        LOGGER.info("search bar text area appeared ");

    }


    @When("send {string} on search area and click search button")
    public void send_string_on_search_area_and_click_search_button(String string) {

        enterText(SEARCH_BAR_TEXT_AREA_ID, string);
        click(SEARCH_BAR_SEARCH_BUTTON_XPATH);
        LOGGER.info("searh " + string);

    }

    @Then("search result contain {string}")
    public void search_result_contain_string(String text) {

        Assert.assertEquals(0, checkText(SEARCH_RESULT_DESC_XPATH, text));
        LOGGER.info("Check search result description ");

    }


    @When("select {string} in dropdown")
    public void select_string_in_dropdown(String text) {

        click(DOCUMENT_PAGE_DROPDOWN_ID);
        dropdownSelect(DOCUMENT_PAGE_DROPDOWN_LIST_XPATH, text);

    }

    @Then("check {string} can be seen")
    public void check_catalog_can_be_seen(String text) {

        Assert.assertEquals(0, checkText(DOCUMENT_PAGE_CATALOG_XPATH, text));
        LOGGER.info(text + " is appeared catalog list.");

    }

    @When("click {string} {string}")
    public void click_string(String key, String row) {

        click(By.xpath("(//a[contains(text(),'" + key + "')])[" + row + "]"));

    }

    @And("switch tab")
    public void switch_tab() {
        switchToTab();

    }

    @And("get tab count")
    public void get_tab_count() {
        tabCount = getTabCount();

    }

    @And("get tab title")
    public void get_tab_title() {
        tabUrl = getTabUrl();
        LOGGER.info("Tab url is " + tabUrl);
        fileName=getFileName(tabUrl);
    }

    @Then("check opened on a new tab")
    public void check_opened_on_a_new_tab() {

        Assert.assertEquals(tabCount + 1, getTabCount());

    }


    @And("download the {string} document")
    public void download_the_document(String row) {

        click(By.xpath("(//a[contains(text(),'Download')])[" + row + "]"));
        LOGGER.info("Clicked download " + row + ".product");
        sleepInSeconds(5000);

    }

    @Then("verify document downloaded")
    public void verify_document_downloaded() {
        Assert.assertTrue(checkFile(fileName));
    }


}
