Feature: Retrieve Name of Last Item in Men’s Jackets
@smoke
  Scenario: Capture the name of the last item in men’s jackets
    Given User is on the "homepage"
    When User navigates to "Men" -"Tops" -"Jackets"
    And User scrolls to the bottom of the page
    Then User captures the name of the last item displayed