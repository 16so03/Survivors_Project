Feature: Verify Number of Items Displayed Under Women’s Tees
@smoke
  Scenario: Check if 12 items are displayed on the page
    Given User is on the "homepage"
    When User navigates to "Women" -"Tops" -"Tees"
    Then User should see exactly "12" items displayed on the page