Feature: Build your own cheap computer
  Build your own cheap computer

  @SuccessfulPurchase
  Scenario: Go through the complete process of buying a PC
    Given I'm on the home page
    When I navigate to the cheap pc page
    And Add the cheap pc to cart
    And Navigate to the shopping cart
    And Click agree with terms of service
    And Click the checkout button
    And Login to checkout
    And Click agree with terms of service
    And Click the checkout button
    And Select a country
    And Input a city
    And Fill out address line 1
    And Fill out zip postal
