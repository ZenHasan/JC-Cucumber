package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {
    private WebDriver driver;
    private ExtentTest extentTest;

    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I have successfully logged into the application")
    public void i_have_successfully_logged_into_the_application(){
        loginPage.clearUserNamePassword();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickLoginBtn();
        extentTest.log(LogStatus.PASS, "I have successfully logged into the application");
    }

    @When("I select a product and add it to the cart")
    public void i_select_a_product_and_add_it_to_the_cart(){
        homePage.setAddBtnToCart();
        extentTest.log(LogStatus.PASS, "I select a product and add it to the cart");
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout(){
        homePage.setCartBtn();
        cartPage.setBtnCheckout();
        extentTest.log(LogStatus.PASS, "I proceed to checkout");
    }

    @And("I provide valid checkout information")
    public void i_provide_valid_checkout_information(){
        checkoutPage.inputYourInformation("Mochamad", "Zien", "40181");
        extentTest.log(LogStatus.PASS, "I provide valid checkout information");
    }

    @And("I finish the checkout process")
    public void i_finish_the_checkout_process(){
        checkoutPage.setBtnFinish();
        extentTest.log(LogStatus.PASS, "I finish the checkout process");
    }

    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page(){
        Assert.assertEquals(checkoutPage.getTxtCheckoutComplete(), "Thank you for your order!");
        extentTest.log(LogStatus.PASS, "I should see the order confirmation page");
    }
}
