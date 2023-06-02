package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {

    private static WebDriver driver;

    // Edit for Windows configuration to the location of your chrome web driver.
    private static final String webDriverLocation = "/usr/local/bin/chromedriver";

    public static synchronized WebDriver getWebDriver() {
        if (driver == null) {
            initialiseWebDriver();
        }
        return driver;
    }

    private static void initialiseWebDriver() {
        setWebDriverLocation();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private static void setWebDriverLocation() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", webDriverLocation);
        }
    }
}