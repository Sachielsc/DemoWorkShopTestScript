package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoWebShopPage {
    private WebDriver driver;

    public WebDriverWait getWait() {
        return wait;
    }

    private WebDriverWait wait;
    private String URL;

    public DemoWebShopPage(WebDriver driver, String URL, WebDriverWait wait) {
        setDriver(driver);
        setURL(URL);
        setWebDriverWait(wait);
        init();
    }

    private void setWebDriverWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public DemoWebShopPage(String URL) {
        setURL(URL);
    }

    public DemoWebShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void init(){
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setURL(String url) {
        URL = url;
    }

    public String getURL() {
        return URL;
    }

    public ShoppingCartPage gotToShoppingCart() {
        shoppingCartLink.click();
        return new ShoppingCartPage(getDriver(), getWait());
    }

    @FindBy(id = "small-searchterms")
    public WebElement searchBar;

    @FindBy(className = "search-box-button")
    public WebElement searchButton;

    @FindBy(className = "ico-register")
    public WebElement registerLink;

    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(className = "ico-cart")
    public WebElement shoppingCartLink;

    @FindBy(className = "ico-wishlist")
    public WebElement wishlistLink;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
    public WebElement booksNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
    public WebElement computersNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a")
    public WebElement electronicsNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a")
    public WebElement apparelAndShoesNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[5]/a")
    public WebElement digitalDownloadsNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")
    public WebElement jewelryNavBar;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[7]/a")
    public WebElement giftCardsNavBar;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void exit() {
        driver.close();
        driver.quit();
    }
}
