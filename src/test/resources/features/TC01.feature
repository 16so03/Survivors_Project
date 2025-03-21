Feature: Add First Item to Cart and Verify

  Scenario: Add first item in S size, blue color, quantity 1, and verify in cart
    Given User is on the homepage
    When User clicks on the first item in the catalog
    And User selects size "S"
    And User selects color "Blue"
    And User sets quantity to "1"
    And User clicks on "Add to Cart"
    Then User opens the cart
    And The cart should contain the item with size "S", color "Blue", andquantity "1"