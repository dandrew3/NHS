@Smoke
Feature: Sign-in functionality

  Background: Navigation to the website
    Given the user navigates to the NHS website
    And user validates the url of the page
    And The fields password and username are empty

  Scenario: TC_1 NHS Positive Login testing
    When User enters valid credentials
      | admin |
      | admin |
    And the user clicks the SignIn button
    Then The user should validate the title

  Scenario Outline: TC_02 NHS Negative Login test with an invalid credentials
    When the user enters the invalid credentials '<userName>' and '<password>'
    And the user clicks the SignIn button
    # Then should be assert pop up message
    Examples:
      | userName | password |
      | admin    | aaaaa    |
      | aaaaa    | admin    |
      | ddddd    | aaaaa    |


  Scenario Outline: TC_03 NHS Negative Login test with a blank password
    When the user enters the credentials '<admin>' and '<password>'
    And the user clicks the SignIn button
    # Then user validates the error message
    Examples:
      | admin | password |
      | admin |          |
      |       | admin    |
      |       |          |




