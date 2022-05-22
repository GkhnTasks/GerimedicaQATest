package com.gerimedica.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.*;

public class BrowserUtils {


        /**
        This method accepts a List<WebElements> and returns List<String>
        @param webElementList
        */
    public static List<String> getElementsText(List<WebElement> webElementList){

        //Create placeholder List<String>
        List<String> actualAsString = new ArrayList<>();

        for (WebElement each : webElementList) {

            actualAsString.add(each.getText());

        }

        return actualAsString;

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToRight(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollLeft += 250",element);
    }

}
