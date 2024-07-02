package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtAppLogo;


    //logout
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuBtn;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutBtn;

    //add produk

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBtnToCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement txtRemoveFromCart;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement txtItemName;


    // Assertion
    public String getTxtAppLogo(){
        return txtAppLogo.getText();
    }

    public void logout(){
        menuBtn.click();
        DriverSingleton.delay(1);
        logoutBtn.click();
    }

    public void setAddBtnToCart(){
        addBtnToCart.click();
    }

    public void setCartBtn(){
        cartBtn.click();
    }

    public String getTxtCartBadge(){
        return txtCartBadge.getText();
    }

    public String getTxtRemoveFromCart(){
        return txtRemoveFromCart.getText();
    }

    public void setRemoveBtn(){
        txtRemoveFromCart.click();
    }

    public String getTxtItemName(){
        return txtItemName.getText();
    }
}
