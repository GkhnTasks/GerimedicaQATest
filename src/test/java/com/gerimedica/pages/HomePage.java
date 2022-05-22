package com.gerimedica.pages;

import com.gerimedica.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(css = "[class='cookie-banner-button btn']")
    public WebElement cookiesAccept;

    public  WebElement getElement(String linkText){

       return Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='"+linkText+"']"));

    }



}
