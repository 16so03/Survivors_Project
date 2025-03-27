Feature: Add a Review to the First Item
  @wip@ui
  Scenario Outline: Submit a review for an item
    Given User is on the homepage
    When User clicks on "<Item Name>" in the catalog
    And User scrolls down to the review section
    And User fills out the review form with:
      | Rating   | <Rating>   |
      | Nickname | <Nickname> |
      | Summary  | <Summary>  |
      | Review   | <Review>   |
    And User submits the review
    Then A confirmation message "You submitted your review for moderation." should be displayed

    Examples:
      | Item Name     | Rating   | Nickname | Summary        | Review                                             |
      | Radiant Tee   | 5  | Zulhumar  | Great product! | The quality is amazing, and the fit is perfect!    |
      | Hero Hoodie   | 4  | Zubayya   | Good value     | Loved the color and material, but runs a bit small |