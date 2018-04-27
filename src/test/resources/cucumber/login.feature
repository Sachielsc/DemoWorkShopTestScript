Feature: Login
  Users need to login

  @LoginSuccess
  Scenario: Successfully login to the website
    Given I'm on the login page
    When I input a valid username
    And I input the valid password
    And I click the login button
    Then I should be taken to the home page

  @IncorrectUsername
  Scenario: Unsuccessfully login to the website due to incorrect username
    Given I'm on the login page
    When I input an invalid username
    And I input the valid password
    And I click the login button
    Then I should not be taken to the home page
    And The Error should read "No customer account found"

  @IncorrectPassword
  Scenario: Unsuccessfully login to the website due to incorrect password
    Given I'm on the login page
    When I input a valid username
    And I input an invalid password in the login page
    And I click the login button
    Then I should not be taken to the home page
    And The Error should read "The credentials provided are incorrect"