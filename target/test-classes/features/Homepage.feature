Feature: Landing on Homepage

  Background: 
    Given I have launched the application
    When I enter the correct username and password
    And I click on Login Button

  @regression
  Scenario: To add one product into the cart
    And I add below product as "Sauce Labs Backpack"
    Then I should have cart item updated as to be 1

  @sanity
  Scenario: To add more than one product
    When I add below Products
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
    Then I should have cart item updated as to be 3
