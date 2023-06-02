@Parabank
Feature: Parabank Banking website

  Parabank website - https://parabank.parasoft.com/parabank/index.htm

  As a customer of the Parabank Banking website
  I want to be able to create an account/sign in
  So that I can carry out any financial transactions that I may need

  Scenario: Register for a new account
    Given I have navigated to the Parabank home page
    When I click on the Register link
    And I complete the registration form with valid details
    Then I should see the following confirmation message "Your account was created successfully. You are now logged in."

  Scenario: Open a new savings account
    Given I check the balance of Checking account is "$10000.00"
    When I click on the Open New Account link
    And I select Savings and Open New Account
    And I click on the Accounts Overview link
    Then The balance of the Checking Account is now "$9950.00"
    And The balance of the Savings Account is "$50.00"

  Scenario: Error validation appears on Update Contact Info page
    Given I click on the Update Contact Info link
    When I clear the previously entered data
    Then The appropriate error messages are displayed for each field

  Scenario: Update my contact info after a change of address
    Given I change my address and telephone number details
    When I click the Update Profile button
    Then My new address and telephone number are correctly saved
    And I logout and close browser