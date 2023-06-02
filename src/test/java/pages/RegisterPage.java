package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    public WebElement registerButton;

    @FindBy(id = "customer.firstName")
    public WebElement firstName;

    @FindBy(id = "customer.firstName.errors")
    private WebElement firstNameError;

    @FindBy(id = "customer.lastName")
    public WebElement lastName;

    @FindBy(id = "customer.lastName.errors")
    private WebElement lastNameError;

    @FindBy(id = "customer.address.street")
    public WebElement addressField;

    @FindBy(id = "customer.address.street.errors")
    private WebElement addressError;

    @FindBy(id = "customer.address.city")
    public WebElement cityField;

    @FindBy(id = "customer.address.city.errors")
    private WebElement cityError;

    @FindBy(id = "customer.address.state")
    public WebElement stateField;

    @FindBy(id = "customer.address.state.errors")
    private WebElement stateError;

    @FindBy(id = "customer.address.zipCode")
    public WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "customer.address.zipCode.errors")
    private WebElement zipCodeError;

    @FindBy(id = "customer.ssn")
    public WebElement socialSecurity;

    @FindBy(id = "customer.ssn.errors")
    private WebElement socialSecurityError;

    @FindBy(id = "customer.username")
    public WebElement userName;

    @FindBy(id = "customer.username.errors")
    private WebElement userNameError;

    @FindBy(id = "customer.password")
    public WebElement passwordField;

    @FindBy(id = "customer.password.errors")
    private WebElement passwordError;

    @FindBy(id = "repeatedPassword")
    public WebElement passwordConfirmation;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement passwordConfirmationError;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    public WebElement openNewAccountLink;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    public WebElement logOutLink;

    public void clickRegisterButton() {
        registerButton.isDisplayed();
        registerButton.click();
    }

    public void clickOpenNewAccountLink() {
        openNewAccountLink.isDisplayed();
        openNewAccountLink.click();
    }

    public void clickLogOutLink() {
        logOutLink.isDisplayed();
        logOutLink.click();
    }

    public void setRegisterField(WebElement field,String value) {
        field.click();
        field.sendKeys(value);
    }

    public boolean registerValidationIsDisplayed() {
        firstNameError.isDisplayed();
        lastNameError.isDisplayed();
        addressError.isDisplayed();
        cityError.isDisplayed();
        stateError.isDisplayed();
        zipCodeError.isDisplayed();
        socialSecurityError.isDisplayed();
        userNameError.isDisplayed();
        passwordError.isDisplayed();
        passwordConfirmationError.isDisplayed();
        return true;
    }

}