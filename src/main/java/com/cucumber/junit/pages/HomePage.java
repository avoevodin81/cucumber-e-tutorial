package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static final String CUCUMBER_URL = "https://cucumber.io/";
    public static final String TEXT_PATTERN = "%s[contains(text(), '%s')]";
    public static final String MENU_SECTION = "//a[contains(@class, 'nav-link')]";
    public static final String CHILD_MENU_ITEM = "//*[contains(@class, 'dropdown')]//*[contains(@class, 'item')]";

    public void openCucumberWebsite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(String.format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }

    public WebElement menuChildItem(String linkText) {
        return findElement(By.xpath(String.format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }
}
