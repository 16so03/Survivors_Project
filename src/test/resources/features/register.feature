@ui
Feature: User Registration

  Scenario: Successful user registration
    Given the user is on the registration page
    When the user enters valid details
    And clicks the Register button
    Then the user should see a success message "Thank you for registering with Main Website Store."

  Scenario: Registration with an already registered email
    Given the user is on the registration page
    When the user enters an email that is already in use
    And clicks the Register button
    Then the user should see an error message "There is already an account with this email address."

