package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfoPage {

    public WebDriver driver;

    public UpdateContactInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#rightPanel > div > div > h1")
    public WebElement updateContactInfoHeading;

    @FindBy(id = "customer.firstName")
    public WebElement updateFirstName;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(1) > td:nth-child(3) > span")
    public WebElement updateFirstNameError;

    @FindBy(id = "customer.lastName")
    public WebElement updateLastName;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(2) > td:nth-child(3) > span")
    public WebElement updateLastNameError;

    @FindBy(id = "customer.address.street")
    public WebElement updateStreetAddress;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(3) > td:nth-child(3) > span")
    public WebElement updateStreetAddressError;

    @FindBy(id = "customer.address.city")
    public WebElement updateCity;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(4) > td:nth-child(3) > span")
    public WebElement updateCityError;

    @FindBy(id = "customer.address.state")
    public WebElement updateState;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(5) > td:nth-child(3) > span")
    public WebElement updateStateError;

    @FindBy(id = "customer.address.zipCode")
    public WebElement updateZipCode;

    @FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(6) > td:nth-child(3) > span")
    public WebElement updateZipCodeError;

    @FindBy(id = "customer.phoneNumber")
    public WebElement updatePhoneNumber;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[8]/td[2]/input")
    public WebElement updateProfileButton;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[6]/a")
    public WebElement contactInfoUpdateLink;

    public boolean updateContactInfoHeadingIsDisplayed() {
        updateContactInfoHeading.isDisplayed();
        return true;
    }

    public void setUpdatedContactInfoFields(WebElement field,String value) {
        field.click();
        field.sendKeys(value);
    }

    public void clickUpdateProfileButton() {
        updateProfileButton.isDisplayed();
        updateProfileButton.click();
    }

    public boolean updateContactInfoValidationIsDisplayed() {
        updateFirstNameError.isDisplayed();
        updateLastNameError.isDisplayed();
        updateStreetAddressError.isDisplayed();
        updateCityError.isDisplayed();
        updateStateError.isDisplayed();
        updateZipCodeError.isDisplayed();
        return true;
    }

    public void clickContactInfoUpdateLink() {
        contactInfoUpdateLink.isDisplayed();
        contactInfoUpdateLink.click();
    }

}