Feature: Login Feature Scenario for Saucedemo

  Scenario: To login into the page with positive case
    Given I have launched the application
    When I enter the correct username and password
    And I click on Login Button
    Then I should land on the home page

  @sanity
  Scenario Outline: To login into the page with negative case
    Given I have launched the application
    When I enter the incorrect username as "<UserName>" and password as "<pwd>"
    And I click on Login Button
    Then I should get the error message as "<Error>"

    Examples: 
      | UserName                | Pwd         | Error                                                                     |
      | standard_user           | secret_saue | Epic sadface: Username and password do not match any user in this service |
      | problem_user            | secret_sauc | Epic sadface: Username and password do not match any user in this service |
      | performance_glitch_user | secret_sace | Epic sadface: Username and password do not match any user in this service |
