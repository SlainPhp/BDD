Feature: User Authorization

  Background:
    Given the user is on the login page
    And the Login field is cleared
    And the Password field is cleared

  Scenario Outline: Successful login with valid credentials
    Given the user enters login "<login>"
    And the user enters password "<password>"
    When the user clicks the "Login" button
    Then the system should redirect to the main page
    And the profile header should display name "<name>"

    Examples:
      | login | password | name     |
      | user1 | pass1    | User One |
      | user2 | pass2    | User Two |

  Scenario: Failed login with wrong password
    Given the user enters login "user1"
    And the user enters password "wrong_password"
    When the user clicks the "Login" button
    Then an error message "Неверный логин или пароль" should appear
