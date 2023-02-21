Feature: Dashboard functionality

  Scenario: Dashboards rooms should be visible for user
    Given the user navigates to the NHS website
    When the user successfully loges in
    And amount of rooms are 3
    Then the rooms should be display on the page