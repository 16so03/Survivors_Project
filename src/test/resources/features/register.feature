Feature: User Registration
  @wip
  Scenario: Successful user registration
    Given the user is on the registration page
    When the user enters valid details
      | FirstName  | JohA           |
      | LastName   | Doz            |
      | Email       | john57e@example.com |
      | Password    | Se!cure@123     |
    And clicks the "Register" button
    Then the user should see a success message "Thank you for registering with Main Website Store."

  Scenario: Registration with an already registered email
    Given the user is on the registration page
    When the user enters an email that is already in use
    And clicks the "Register" button
    Then the user should see an error message "Email is already registered"

  Scenario: Registration with invalid password
    Given the user is on the registration page
    When the user enters a password that does not meet security requirements
    And clicks the "Register" button
    Then the user should see an error message "Password must contain at least 8 characters, one uppercase, one lowercase, and one special character"