Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to the inventory page

  Scenario: Failed login with valid credentials
    Given I am on the login page
    When I enter an invalid username and password
    And I click the login button
    Then I should see an error message