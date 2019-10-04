@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Title of your scenario
    Given The user is in home page and click add button
    When The user enters details then click submit
      | fname  | lname  | email               | address | phno       |
      | mahesh | reddy  | mahesh123@gmail.com | omr     | 1234567890 |
      | reddy  | mahesh | reddy123@gmail.com  | ecr     | 9876543218 |
    Then The user navigates to next page
