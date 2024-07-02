    package com.juaracoding.pages;

    import com.juaracoding.drivers.DriverSingleton;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    public class CheckoutPage {
        private WebDriver driver;

        public CheckoutPage(){
            this.driver = DriverSingleton.getDriver();
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//input[@id='first-name']")
        private WebElement firstName;

        @FindBy(xpath = "//input[@id='last-name']")
        private WebElement lastName;

        @FindBy(xpath = "//input[@id='postal-code']")
        private WebElement zipPostalCode;

        @FindBy(xpath = "//input[@id='continue']")
        private WebElement btnContinue;

        @FindBy(xpath = "//button[@id='finish']")
        private WebElement btnFinish;

        @FindBy(xpath = "//h2[@class='complete-header']")
        private WebElement txtCheckoutComplete;

        public void inputYourInformation(String firstName, String lastName, String zipPostalCode){
            this.firstName.sendKeys(firstName);
            this.lastName.sendKeys(lastName);
            this.zipPostalCode.sendKeys(zipPostalCode);
            btnContinue.click();
        }

        public void setBtnFinish(){
            btnFinish.click();
        }

        public String getTxtCheckoutComplete(){
            return txtCheckoutComplete.getText();
        }
    }
