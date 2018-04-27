package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends DemoWebShopPage {

    public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, "http://demowebshop.tricentis.com/cart", wait);
    }

    public ShoppingCartPage() {
        super("http://demowebshop.tricentis.com/cart");
    }

    public CheckoutPage clickCheckout() {
        checkout.click();
        return new CheckoutPage(getDriver(),getWait());
    }

    public void clickAcceptTermsOfService() {
        termsOfService.click();
    }

    /**
     * Determines if this Shopping Cart is empty.
     *
     * @return true if empty, false otherwise.
     */
    public Boolean isEmpty() {
        WebElement empty = getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div[2]/div[2]/div"));
        return empty.getText().contains("Your Shopping Cart is empty!");
    }

    @FindBy(id = "checkout")
    public WebElement checkout;

    @FindBy(id = "termsofservice")
    public WebElement termsOfService;
}
