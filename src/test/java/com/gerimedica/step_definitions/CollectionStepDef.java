package com.gerimedica.step_definitions;

import com.gerimedica.pages.CollectionPage;
import com.gerimedica.pages.HomePage;
import com.gerimedica.utilities.BrowserUtils;
import com.gerimedica.utilities.ConfigurationReader;
import com.gerimedica.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionStepDef {

    HomePage homePage=new HomePage();
    CollectionPage collectionPage=new CollectionPage();

    @Given("user go to the website")
    public void user_go_to_the_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user click {string} link")
    public void userClickLink(String text) {

        homePage.cookiesAccept.click();
        BrowserUtils.scrollToRight(homePage.getElement(text));
        homePage.getElement(text).click();
    }


    @Then("user should be see the collectie page")
    public void user_should_be_see_the_collectie_page(List<String> expectedResult){

        BrowserUtils.waitForVisibility(collectionPage.collectionHeaderTitle,20);

        assertEquals(expectedResult.get(0),collectionPage.collectionHeaderTitle.getText());
        assertEquals(expectedResult.get(1),Driver.getDriver().getCurrentUrl());

    }

    @When("user click search tab")
    public void user_click_search_tab() {

        collectionPage.searchTab.click();
    }

    @And("user search the painting with title {string} from the search box")
    public void userSearchThePaintingWithTitleFromTheSearchBox(String searchWord){

        collectionPage.searchTab.sendKeys(searchWord, Keys.ENTER);
    }

    @Then("user see the result more than {int}")
    public void user_see_the_result_more_than(Integer expectedResult) {

        BrowserUtils.waitForVisibility(collectionPage.result,10);
        Integer actualResult=Integer.valueOf(collectionPage.result.getText());
        assertTrue("Result smaller then "+ expectedResult ,actualResult>expectedResult);
    }



}
