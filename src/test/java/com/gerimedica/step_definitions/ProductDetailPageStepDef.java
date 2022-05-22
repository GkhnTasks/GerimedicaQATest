package com.gerimedica.step_definitions;

import com.gerimedica.pages.CollectionPage;
import com.gerimedica.pages.ProductDetailPage;
import com.gerimedica.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class ProductDetailPageStepDef {

    ProductDetailPage productDetailPage=new ProductDetailPage();
    CollectionPage collectionPage=new CollectionPage();

    @When("user click first result")
    public void user_click_first_result() {
        BrowserUtils.waitForVisibility(collectionPage.listAllPaint,10);
        collectionPage.listAllPaint.click();
    }

    @When("user click Objectgegevens link")
    public void user_click_objectgegevens_link() throws InterruptedException {

        BrowserUtils.waitForVisibility(productDetailPage.paintingDataButton.get(0),10);
        BrowserUtils.scrollToElement(productDetailPage.paintingDataButton.get(0));
        BrowserUtils.waitFor(2);

        productDetailPage.paintingDataButton.get(0).click();

    }

    @And("user click {string} link for see details")
    public void userClickLinkForSeeDetails(String text) {

        BrowserUtils.waitForVisibility(productDetailPage.getElement(text),10);
        BrowserUtils.scrollToElement(productDetailPage.getElement(text));
        BrowserUtils.waitFor(2);
        productDetailPage.getElement(text).click();

    }

    @Then("user should be see painting details Title and Result")
    public void userShouldBeSeePaintingDetailsTitleAndResult(Map<String,String> expectedResult) {

        List<String> actualKeys=BrowserUtils.getElementsText(productDetailPage.objectDataListTitle);
        List<String> actualValues=BrowserUtils.getElementsText(productDetailPage.objectDataListValue);

        int i=0;
        for (Map.Entry<String, String> entry : expectedResult.entrySet()) {
            assertEquals(entry.getKey(),actualKeys.get(i));
            assertEquals(entry.getValue(),actualValues.get(i));
            i++;
        }

    }
}
