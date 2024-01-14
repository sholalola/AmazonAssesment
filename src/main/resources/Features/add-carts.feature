Feature: Add to cart
  Background:
  Given user is on the homepage



  Scenario: Add monitor to cart
    Given a user enter "monitor" in search field
    And user select the first monitor on the list
    When user add item to cart
    Then the sub total on the Cart is identical to the product page

  Scenario: Add Laptop to cart
    Given a user enter "laptop" in search field
    And user select the second laptop on the list
    When user add laptop to cart
    Then the laptop sub total on the Cart should be identical to the product page