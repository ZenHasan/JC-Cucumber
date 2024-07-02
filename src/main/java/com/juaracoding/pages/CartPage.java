package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    //div[@class='inventory_item_name']
    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement txtItemName;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckout;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement backBtn;

    public String getTxtItemName(){
        return txtItemName.getText();
    }

    public void setBtnCheckout(){
        btnCheckout.click();
    }

    public void setBackBtn(){
        backBtn.click();
    }
}
