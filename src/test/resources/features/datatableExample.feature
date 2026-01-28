Feature: Validate Datatable with Cucumber and REST-assured

Scenario: User login
Given user enters login details
| username | password |
| admin    | admin123 |



  Scenario: Create user using POST API
    Given user provides request payload
      | name | job    |
      | Alex | Tester |
    When user calls create user API
    Then response status code should be 201
    And response should contain "name" as "Alex"