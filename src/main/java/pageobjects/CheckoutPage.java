package pageobjects;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends DemoWebShopPage {

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, "http://demowebshop.tricentis.com/onepagecheckout", wait);
    }

    public void clickCheckoutAsGuest(){
        checkoutAsGuest.click();
    }

    public void completeCheckout() {
        try {
            fillOutBillingAddress();
        } catch (ElementNotVisibleException e){
            continueThroughBillingAddress();
        }
        continueThroughShippingAddress();
        continueThroughShippingMethod();
        continueThroughPaymentMethod();
        continueThroughPaymentInfo();
        confirmOrder();
    }

    private void fillOutBillingAddress() {
        firstName.sendKeys("Planit");
        lastName.sendKeys("Test");
        email.sendKeys("mmcintosh@planittesting.com");
        countryDropDown.click();
        country.click();
        city.sendKeys("Wellington");
        address.sendKeys("5 Willeston Street");
        postCode.sendKeys("6011");
        phoneNumber.sendKeys("051234567");
        continueThroughBillingAddress();
        System.out.println("Filled out shipping info.");
    }

    private void confirmOrder() {
        getWait().until(ExpectedConditions.visibilityOf(confirmOrderContinueButton));
        confirmOrderContinueButton.click();
        System.out.println("Confirmed order.");
    }

    private void continueThroughPaymentInfo() {
        getWait().until(ExpectedConditions.visibilityOf(paymentInfoContinueButton));
        paymentInfoContinueButton.click();
        System.out.println("Continuing through Payment Information.");
    }

    private void continueThroughPaymentMethod() {
        getWait().until(ExpectedConditions.visibilityOf(paymentMethodContinueButton));
        paymentMethodContinueButton.click();
        System.out.println("Continuing through Payment Method.");
    }

    private void continueThroughShippingMethod() {
        getWait().until(ExpectedConditions.visibilityOf(shippingMethodContinueButton));
        shippingMethodContinueButton.click();
        System.out.println("Continuing through Shipping Method.");
    }

    private void continueThroughShippingAddress() {
        getWait().until(ExpectedConditions.visibilityOf(shippingAddressContinueButton));
        shippingAddressContinueButton.click();
        System.out.println("Continuing through Shipping Address.");
    }

    private void continueThroughBillingAddress() {
        getWait().until(ExpectedConditions.visibilityOf(newAddressContinueButton));
        newAddressContinueButton.click();
        System.out.println("Continuing through Billing Address.");
    }

    @FindBy(className = "checkout-as-guest-button")
    private WebElement checkoutAsGuest;

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryDropDown;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]/option[2]")
    private WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement postCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(className = "new-address-next-step-button")
    private WebElement newAddressContinueButton;

    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    private WebElement shippingAddressContinueButton;

    @FindBy(className = "shipping-method-next-step-button")
    private WebElement shippingMethodContinueButton;

    @FindBy(className = "payment-method-next-step-button")
    private WebElement paymentMethodContinueButton;

    @FindBy(className = "payment-info-next-step-button")
    private WebElement paymentInfoContinueButton;

    @FindBy(className = "confirm-order-next-step-button")
    private WebElement confirmOrderContinueButton;
}
