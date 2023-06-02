package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#topPanel > a:nth-child(2) > img")
    public WebElement parabankTitle;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    public WebElement registerLink;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[6]/a")
    public WebElement updateContactInfo;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    public WebElement logoutLink;

    public boolean homePageIsDisplayed() {
        parabankTitle.isDisplayed();
        return true;
    }

    public void clickRegisterLink() {
        registerLink.isDisplayed();
        registerLink.click();
    }

    public void clickUpdateContactInfoLink() {
        updateContactInfo.isDisplayed();
        updateContactInfo.click();
    }

    public void clickLogOutLink() {
        logoutLink.isDisplayed();
        logoutLink.click();
    }

}