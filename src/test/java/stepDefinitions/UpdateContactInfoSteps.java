package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.UpdateContactInfoPage;
import utilities.WebDriverUtil;

import static org.junit.Assert.assertTrue;

public class UpdateContactInfoSteps {

    private WebDriver driver;
    private UpdateContactInfoPage updateContactInfoPage;
    private HomePage homePage;

    public UpdateContactInfoSteps() {
        driver = WebDriverUtil.getWebDriver();
        updateContactInfoPage = new UpdateContactInfoPage(driver);
        homePage = new HomePage(driver);
    }

    /**
     * Updates all Contact Info fields with new details.
     */
    @When("I change my address and telephone number details")
    public void updateAddressAndTelephoneNumber() throws Exception {
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateFirstName, "New First Name");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateLastName, "New Last Name");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateStreetAddress, "New Street Address");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateCity, "New City");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateState, "New State");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updateZipCode, "New Zip Code");
        updateContactInfoPage.setUpdatedContactInfoFields(updateContactInfoPage.updatePhoneNumber, "10987654321");
        Thread.sleep(2000);
    }

    /**
     * Clears all Contact Info fields of previously entered details.
     */
    @And("I clear the previously entered data")
    public void clearPreviouslyEnteredData() throws Exception {
        Thread.sleep(2000);
        updateContactInfoPage.updateFirstName.clear();
        updateContactInfoPage.updateLastName.clear();
        updateContactInfoPage.updateStreetAddress.clear();
        updateContactInfoPage.updateCity.clear();
        updateContactInfoPage.updateState.clear();
        updateContactInfoPage.updateZipCode.clear();
        updateContactInfoPage.updatePhoneNumber.clear();
        Thread.sleep(2000);
    }

    /**
     * Clicks the Update Profile button.
     */
    @And("I click the Update Profile button")
    public void clickOnUpdateProfileButton() throws Exception {
        Thread.sleep(2000);
        updateContactInfoPage.clickUpdateProfileButton();
    }

    /**
     * Asserts that the appropriate error messages are displayed.
     */
    @Then("The appropriate error messages are displayed for each field")
    public void updateContactInfoErrorMessagesDisplayed() {
        Assert.assertTrue(updateContactInfoPage.updateContactInfoValidationIsDisplayed());
    }

    /**
     * Asserts that the newly updated Contact Info details are correct.
     */
    @Then("My new address and telephone number are correctly saved")
    public void addressAndTelephoneDetailsUpdated() throws Exception {
        Thread.sleep(2000);
        updateContactInfoPage.clickContactInfoUpdateLink();
        Thread.sleep(2000);
        assertTrue(updateContactInfoPage.updateFirstName.getAttribute("value").contains("New First Name"));
        assertTrue(updateContactInfoPage.updateLastName.getAttribute("value").contains("New Last Name"));
        assertTrue(updateContactInfoPage.updateStreetAddress.getAttribute("value").contains("New Street Address"));
        assertTrue(updateContactInfoPage.updateCity.getAttribute("value").contains("New City"));
        assertTrue(updateContactInfoPage.updateState.getAttribute("value").contains("New State"));
        assertTrue(updateContactInfoPage.updateZipCode.getAttribute("value").contains("New Zip Code"));
        assertTrue(updateContactInfoPage.updatePhoneNumber.getAttribute("value").contains("10987654321"));
    }

}