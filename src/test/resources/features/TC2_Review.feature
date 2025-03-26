Feature: Add a Review to the First Item

  @smoke
  Scenario: Submit a review for the first item
    Given User is on the "homepage"
    When User clicks on the first item in the catalog
    And User scrolls down to the review section
    And User clicks on "Add Your Review"
    And User fills out the review form with:
      | Field    | Value                                           |
      | Rating   | 5                                               |
      | nickname | Bob                                             |
      | Summary  | Great product!                                  |
      | Review   | The quality is amazing, and the fit is perfect! |
    And User submits the review
    Then A confirmation message should be displayed
