package com.cucumber.junit.steps;

import com.cucumber.junit.pages.DocsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DocsSteps {

    private final DocsPage docsPage = new DocsPage();

    @Then("there are {int} items in the left-side menu")
    public void verifyLeftSideMenuSize(int expectedSize) {
        Assertions.assertThat(docsPage.getMenuItemTitles())
                .as("The left-side menu size is not as expected")
                .hasSize(expectedSize);
    }

    @Then("left-side menu contain the following links")
    public void verifyLeftSideMenuContainFollowingLinks(List<String> expectedTitles) {
        Assertions.assertThat(docsPage.getMenuItemTitles())
                .extracting(WebElement::getText)
                .as("Some of the left-side menu items are not as expected")
                .containsAll(expectedTitles);
    }
}
