Feature: Validate API with Cucumber and REST-assured

  Scenario: Get all users
    Given I hit the GET endpoint "/users"
    Then the status code should be 200

  Scenario: Create a user
    Given I have a valid user payload
    When I hit the POST endpoint "/users"
    Then the status code should be 201
