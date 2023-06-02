package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import utilities.SeleniumUtil;

import static org.junit.Assert.assertTrue;

public class AccountPageSteps {

    private WebDriver driver;
    private AccountPage accountPage;

    public AccountPageSteps() {
        driver = SeleniumUtil.getWebDriver();
        accountPage = new AccountPage(driver);
    }

    /**
     * Clicks on the Savings account and then Open new account link.
     */
    @And("I select Savings and Open New Account")
    public void selectSavingsAndOpenNewAccount() throws Exception {
        accountPage.selectSavingsAccountType();
        Thread.sleep(1000);
        accountPage.clickOpenNewAccountButton();
        Thread.sleep(1000);
    }

    /**
     * Clicks on the account overview link.
     */
    @When("I click on the Accounts Overview link")
    public void clickOnTheAccountsOverviewLink() {
        accountPage.clickAccountOverviewLink();
    }

    /**
     * Gets the Checking account balance and asserts that it matches expected text.
     */
    @And("I check the balance of Checking account is {string}")
    public void checkBalanceOfCheckingAccount(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        Thread.sleep(2000);
        accountPage.clickCheckingAccountLink();
        Thread.sleep(2000);
        assertTrue(accountPage.checkingAccountBalance.getText().contains(string));
    }

    /**
     * Checks the balance is as expected after the new account deduction.
     */
    @Then("The balance of the Checking Account is now {string}")
    public void checkBalanceOfCheckingAccountAfterDeduction(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        Thread.sleep(2000);
        accountPage.clickCheckingAccountLink();
        Thread.sleep(2000);
        assertTrue(accountPage.checkingAccountBalance.getText().contains(string));
    }

    /**
     * Gets the Savings accounts value and asserts that it matches expected text.
     */
    @And("The balance of the Savings Account is {string}")
    public void checkBalanceOfSavingsAccount(String string) throws Exception {
        accountPage.clickAccountOverviewLink();
        Thread.sleep(2000);
        accountPage.clickSavingsAccountLink();
        Thread.sleep(1000);
        assertTrue(accountPage.savingsAccountText.getText().contains("SAVINGS"));
        Thread.sleep(1000);
        assertTrue(accountPage.savingsAccountBalance.getText().contains(string));
    }

    /**
     * Takes screenshot after each failed scenario step.
     */
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

}