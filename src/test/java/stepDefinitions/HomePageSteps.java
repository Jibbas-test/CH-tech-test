package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.UpdateContactInfoPage;
import utilities.WebDriverUtil;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;
    private UpdateContactInfoPage updateContactInfoPage;


    public HomePageSteps() {
        driver = WebDriverUtil.getWebDriver();
        homePage = new HomePage(driver);
        updateContactInfoPage = new UpdateContactInfoPage(driver);
    }

    /**
     * Navigate to Parabank website and asserts page heading is true.
     */
    @Given("I have navigated to the Parabank home page")
    public void navigateToParabankHomePage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    /**
     * Clicks on the Register link.
     */
    @When("I click on the Register link")
    public void clickOnTheRegisterLink() {
        homePage.clickRegisterLink();
    }

    /**
     * Clicks on the Update Contact Info link.
     */
    @Given("I click on the Update Contact Info link")
    public void clickOnUpdateContactInfoLink() {
        homePage.clickUpdateContactInfoLink();
        updateContactInfoPage.updateContactInfoHeadingIsDisplayed();
    }

    /**
     * Logs out of account and closes browser.
     */
    @And("I logout and close browser")
    public void logoutAndCloseBrowser() throws IOException {
        homePage.clickLogOutLink();
        driver.close();
        driver.quit();
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