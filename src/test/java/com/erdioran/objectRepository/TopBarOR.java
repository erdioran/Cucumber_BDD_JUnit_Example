package com.erdioran.objectRepository;


import org.openqa.selenium.By;

public class TopBarOR {


    public static final By SEARCH_BUTTON_XPATH = By.xpath("//div[@class='header-navigation-button']//div[@class='header-navigation-button__icon']");

    public static final By SEARCH_BAR_TEXT_AREA_ID = By.id("global-search");

    public static final By SEARCH_BAR_SEARCH_BUTTON_XPATH = By.xpath("//button[normalize-space()='Search']");

}
