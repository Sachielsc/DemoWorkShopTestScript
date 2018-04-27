package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasualBeltPage extends DemoWebShopPage {

    public CasualBeltPage(WebDriver driver, WebDriverWait wait) {
        super(driver, "http://demowebshop.tricentis.com/casual-belt", wait);
        PageFactory.initElements(driver, this);
    }

    public CasualBeltPage() {
        super("http://demowebshop.tricentis.com/casual-belt");
    }

    @FindBy(css = "#add-to-cart-button-40")
    public WebElement addToCart;

    public void addToCart() {
        addToCart.click();
    }
}

