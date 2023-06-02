package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"type\"]")
    private WebElement selectSavingAccount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div/input")
    private WebElement openNewAccountButton;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[2]/a")
    private WebElement accountsOverviewLink;

    @FindBy(id = "availableBalance")
    public WebElement checkingAccountBalance;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    public WebElement checkingAccountLink;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a")
    public WebElement savingsAccountLink;

    @FindBy(id = "balance")
    public WebElement savingsAccountBalance;

    @FindBy(id = "accountType")
    public WebElement savingsAccountText;

    public void selectSavingsAccountType() {
        org.openqa.selenium.support.ui.Select dropdown = new Select(selectSavingAccount);
        dropdown.getOptions().get(1).click();
    }

    public void clickOpenNewAccountButton() {
        openNewAccountButton.isDisplayed();
        openNewAccountButton.click();
    }

    public void clickAccountOverviewLink() {
        accountsOverviewLink.isDisplayed();
        accountsOverviewLink.click();
    }

    public void clickSavingsAccountLink() {
        savingsAccountLink.isDisplayed();
        savingsAccountLink.click();
    }

    public void clickCheckingAccountLink() {
        checkingAccountLink.isDisplayed();
        checkingAccountLink.click();
    }

}