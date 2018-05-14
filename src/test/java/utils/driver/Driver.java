package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class holds a static WebDriver so that there can only ever be one webdriver in use at once. This also means there
 * can be no parallel testing.
 */
public class Driver {
    private static WebDriver webDriver;

    public Driver(){
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null || webDriver.toString().contains("null")){
            String chrome = "C:\\Users\\Admin\\OneDrive - Planit Software Testing\\Code\\chromedriver_win32\\chromedriver.exe";    //HOME:*/ "C:\\Users\\Malachi\\OneDrive - Planit Software Testing\\Code\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chrome);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.setHeadless(false);
            webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }

    public static void quitWebDriver() {
        if (!hasQuit(webDriver)){
            webDriver.quit();
        }
    }

    public static boolean hasQuit(WebDriver driver) {
        return ((RemoteWebDriver)driver).getSessionId() == null;
    }

}
