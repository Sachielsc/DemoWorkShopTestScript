package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuildYourOwnCheapComputerPage extends DemoWebShopPage {

//    public BuildYourOwnCheapComputerPage(WebDriver driver) {
//        super(driver, "http://demowebshop.tricentis.com/build-your-cheap-own-computer");
//        PageFactory.initElements(driver, this);
//    }

    public BuildYourOwnCheapComputerPage() {
        super("http://demowebshop.tricentis.com/build-your-cheap-own-computer");
    }

    @FindBy(css = "#add-to-cart-button-72")
    public WebElement addToCart;

    public void addToCart() {
        addToCart.click();
    }


}

