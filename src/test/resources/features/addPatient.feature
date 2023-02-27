@Smoke
Feature: Add Patient functionality

  Scenario Outline: TC_6 User should be able add patient to the patient waiting card
    Given the user navigates to the NHS website
    Then the user successfully loges in
    When the user clicks the add patient button on the left side of the page
    Then the user should be able to add patient details like '<FirstName>', '<LastName>', '<HospitalNo.>', '<DateOfBirth>', '<Sex>'
    When the user click the add patient button
    Then the patient details '<FirstName>', '<LastName>', and '<HospitalNo.>' should be displayed under Patients waiting card on main page
    Examples:
      | FirstName | LastName | HospitalNo. | DateOfBirth | Sex    |
      | Jacki     | Chan     | 9011        | 04/05/1978  | female |
      | Andrew    | Dmytriv  | 2099        | 08/09/1955  | male   |
      | Jacki     | Chan     | 9011        | 04/05/1978  | female |
      | Andrew    | Dmytriv  | 2099        | 08/09/1955  | male   |