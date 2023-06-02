package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtil {

    private static WebDriver driver;

    public static synchronized WebDriver getWebDriver() {
        if (driver == null) {
            initialiseWebDriver();
        }
        return driver;
    }

    private static void initialiseWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

}