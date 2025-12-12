Feature: SauceDemo purchase and login flows
  As a user of SauceDemo
  I want to validate login and checkout behaviours
  So that I can ensure the main flows work correctly

  # SD_TC_01
  Scenario: Successful purchase of one product
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    And I add the product "Sauce Labs Backpack" to the cart
    And I proceed to checkout with first name "Miriam", last name "Osorio" and postal code "110111"
    And I continue from the checkout information page
    And I finish the purchase
    Then I should see the order confirmation message

  # SD_TC_02
  Scenario: Purchase cheapest product using Price low to high filter
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    And I sort products by "Price (low to high)"
    And I add the first listed product to the cart
    And I proceed to checkout with first name "Miriam", last name "Osorio" and postal code "110111"
    And I continue from the checkout information page
    And I finish the purchase
    Then I should see the order confirmation message

  # SD_TC_06
  Scenario: Login with locked out user should fail
    Given I open the SauceDemo login page
    When I login with username "locked_out_user" and password "secret_sauce"
    Then I should see a login error message containing "locked out"

  # SD_TC_08
  Scenario: Login with empty credentials
    Given I open the SauceDemo login page
    When I click on the login button without entering credentials
    Then I should see a login error message containing "Username is required"

  # SD_TC_12
  Scenario: Checkout with empty postal code
    Given I open the SauceDemo login page
    And I login with username "standard_user" and password "secret_sauce"
    And I add the product "Sauce Labs Backpack" to the cart
    And I proceed to checkout with first name "Miriam", last name "Osorio" and postal code ""
    When I continue from the checkout information page
    Then I should see a checkout error message containing "Postal Code is required"
