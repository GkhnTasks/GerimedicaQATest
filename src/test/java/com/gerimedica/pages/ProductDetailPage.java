package com.gerimedica.pages;

import com.gerimedica.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailPage extends BasePage{

    @FindBy(className = "accordion-item-button")
    public List<WebElement> paintingDataButton;

    @FindBy(className = "definition-list-item-label")
    public List<WebElement>  objectDataListTitle;

    @FindBy(className = "definition-list-item-value")
    public List<WebElement>  objectDataListValue;


    public  WebElement getElement(String linkText){

        return Driver.getDriver().findElement(By.xpath("//button[normalize-space(.)='"+linkText+"']"));

    }
}
