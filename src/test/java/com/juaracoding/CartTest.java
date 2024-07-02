package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartTest {
     private WebDriver driver;
     private ExtentTest extentTest;

     private LoginPage loginPage = new LoginPage();
     private HomePage homePage = new HomePage();
     private CartPage cartPage = new CartPage();


     public CartTest(){
         driver = Hooks.driver;
         extentTest = Hooks.extentTest;
     }

    @Given("I am logged in to the application")
    public void i_am_logged_in_to_the_application(){
        loginPage.clearUserNamePassword();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickLoginBtn();
        extentTest.log(LogStatus.PASS, "I am logged in to the application");

    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart(){
        homePage.setAddBtnToCart();
        extentTest.log(LogStatus.PASS, "I add a product to the cart");

    }

    @Then("I should see total product on icon cart")
    public void i_should_see_total_product_on_icon_cart(){
        Assert.assertEquals(homePage.getTxtCartBadge(),"1");
        extentTest.log(LogStatus.PASS, "I should see total product on icon cart");

    }

    @And("button Add to cart changed to Remove")
    public void button_Add_to_cart_changed_to_Remove(){
        Assert.assertEquals(homePage.getTxtRemoveFromCart(), "Remove");
        extentTest.log(LogStatus.PASS, "button Add to cart changed to Remove");

    }

    @And("I am on the cart page")
    public void i_am_on_the_cart_page(){
        homePage.setCartBtn();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        extentTest.log(LogStatus.PASS, "I am on the cart page");
    }

    @And("the product should be in the cart")
    public void the_product_should_be_in_the_cart(){
        Assert.assertEquals(cartPage.getTxtItemName(),"Sauce Labs Backpack");
        cartPage.setBackBtn();
        homePage.setRemoveBtn();
        homePage.logout();
        extentTest.log(LogStatus.PASS, "the product should be in the cart");

    }
}
