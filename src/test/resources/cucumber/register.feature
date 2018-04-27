Feature: Register
  Users need to register to purchase from the website

  @RegisterSuccess
  Scenario: Successfully register to the website
    Given I'm on the register page
    When I select gender male
    And I input a valid first name
    And I input a valid last name
    And I input a valid email
    And I input a valid password
    And I confirm a valid password
    And I click the register button
    Then I should be taken to the registration complete page

  @InvalidEmail
  Scenario: Unsuccessfully register to the website due to invalid email
    Given I'm on the register page
    When I select gender male
    And I input a valid first name
    And I input a valid last name
    When I input an invalid email
    And I input a valid password
    And I confirm a valid password
    And I click the register button
    Then I should not be taken to the registration complete page
    And The Error should read "Wrong email"

  @InvalidPassword
  Scenario: Unsuccessfully register to the website due to invalid password
    Given I'm on the register page
    When I select gender male
    And I input a valid first name
    And I input a valid last name
    And I input a valid email
    And I input an invalid password in the register page
    And I confirm a valid password
    And I click the register button
    Then I should not be taken to the registration complete page
    And The Error should read "The password should have at least 6 characters."

  @PasswordsDon'tMatch
  Scenario: Unsuccessfully register to the website due to mismatching password
    Given I'm on the register page
    When I select gender male
    And I input a valid first name
    And I input a valid last name
    And I input a valid email
    And I input a valid password
    And I confirm an invalid password
    And I click the register button
    Then I should not be taken from the register page to the home page
    And The Error should read "The password and confirmation password do not match."