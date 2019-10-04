
Feature: validate login function of facebook
  I want to use this template for my feature file

  
  Scenario: valid user and invalid pass
    Given lanch the browser
    And load the url
    When Valid user name
    And invalid password
    And click login
    Then Validate result 
    And quit browser