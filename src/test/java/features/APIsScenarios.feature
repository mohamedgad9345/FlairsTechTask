#@api @hs
#Feature: As an admin user, I need to be able to add or delete new users
#
#
#  Scenario: 01 - Admin user Can add new user
#
#    Given sends post request to add new user using portal APIs
#      | firstName | middleName | lastName | email        | contactNumber | keywords      | comment | dateOfApplication | consentToKeepData | vacancyId      |
#      | mhmd      | sayed      | Gad      | test@test.io | 01236549875   | note key word | comment | 2024-03-10        | false             | "vacancyId": 9 |
#
#    When send delete request to delete any record