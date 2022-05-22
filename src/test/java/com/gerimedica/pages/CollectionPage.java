package com.gerimedica.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CollectionPage extends BasePage{

    @FindBy(css = "[class*='heading-1']")
    public WebElement collectionHeaderTitle;

    @FindBy(xpath = "(//*[@class='search-field-input'])[1]")
    public WebElement searchTab;

    @FindBy(className = "results")
    public WebElement result;

    @FindBy(css = " [role='article']")
    public WebElement listAllPaint;




}
