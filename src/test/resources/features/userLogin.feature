@Smoke
Feature: Sign-in functionality

  Background: Navigation to the website
    Given User navigate to the website
    And The fields password and username are empty


  Scenario: Successful Login with Valid Credentials
    When User enters valid credentials
      | admin |
      | admin |
    Then User should be at the 'NHS patients' page
