@dataDriven @UIScenarios
Feature: As an admin user, I need to be able to navigate to orangeHRM website and login
  so that I can get the number of record found and add or delete new added users


  Scenario: 01 - Admin user Can add new user or delete it and check the number of users records

    Given navigate to orangeHRM and login with admin credentials
      | username | password |
      | Admin    | admin123 |
    When click on admin tab on the left side menu
    And get the number of records found
    When click on add button and add new user
      | empName | name    | passwd      | confPasswd  |
      | b       | MoGaddo | Mg123456789 | Mg123456789 |
    Then verify that the number of records increased by 1
    When search with the userName for the new user
    | userName |
    | MoGaddo  |
    And delete the new user
    Then verify that the number of records decreased by 1