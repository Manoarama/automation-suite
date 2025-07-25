Feature: LabCorp Job Search Verification


  Scenario: Search for and validate a job position
    Given I open the LabCorp website
    When I navigate to the Careers page
    And I search for job "QA Test Automation Developer"
    And I select the job titled "QA Test Automation Developer"
    Then I should see job title as "QA Test Automation Developer"
    And I should see job location
    And I should see job ID
    And I should see the description starts with "The right candidate"
    And I should see "Selenium" listed as a required tool
    When I click Apply Now
    Then job title, location, and ID should match the previous page