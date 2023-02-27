@Smoke
Feature: Dashboard functionality

  Background: successful log in
    Given the user navigates to the NHS website
    When the user successfully loges in

  Scenario: TC_4 Dashboards rooms should be visible for user
    And amount of rooms are 3
    Then the rooms should be display on the page

  Scenario: TC_5 Patient cards should be visible for user
    When 3 Patient Cards is visible for user
    And information of patients with rooms is displayed
    Then headers of Patients with rooms has the right information
      | no.                 |
      | Patients with rooms |
      | Room                |
      | Score               |



