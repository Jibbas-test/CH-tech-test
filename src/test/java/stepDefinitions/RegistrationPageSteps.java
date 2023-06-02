package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;
import utilities.WebDriverUtil;

import static org.junit.Assert.assertTrue;

public class RegistrationPageSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    public RegistrationPageSteps() {
        driver = WebDriverUtil.getWebDriver();
        registerPage = new RegisterPage(driver);
    }

    /**
     * Complete all relevant fields for account creation.
     */
    @And("I complete the registration form with valid details")
    public void completeTheRegistrationFormWithValidDetails() {
        registerPage.setRegisterField(registerPage.firstName,"First Name Field");
        registerPage.setRegisterField(registerPage.lastName,"Last Name Field");
        registerPage.setRegisterField(registerPage.addressField,"Address Field");
        registerPage.setRegisterField(registerPage.cityField,"City Field");
        registerPage.setRegisterField(registerPage.stateField,"State Field");
        registerPage.setRegisterField(registerPage.zipCode,"Zip Code Field");
        registerPage.setRegisterField(registerPage.phoneNumber, "012345678910");
        registerPage.setRegisterField(registerPage.socialSecurity,"SSN Field");
        String randomUsername = RandomStringUtils.randomAlphabetic(8);
        registerPage.setRegisterField(registerPage.userName,randomUsername);
        registerPage.setRegisterField(registerPage.passwordField,"Password123");
        registerPage.setRegisterField(registerPage.passwordConfirmation,"Password123");
        registerPage.clickRegisterButton();
    }

    /**
     * Asserts that confirmation message is shown stating account has been created.
     */
    @Then("I should see the following confirmation message {string}")
    public void accountCreationConfirmationMessage(String string) {
        assertTrue(registerPage.confirmationMessage.getText().contains(string));
    }

    /**
     * Clicks on the open new account link.
     */
    @When("I click on the Open New Account link")
    public void clickOnTheOpenNewAccountLink() {
        registerPage.clickOpenNewAccountLink();
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