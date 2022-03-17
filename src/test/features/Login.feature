@loginadmin
Feature: Authorization on the website

  Scenario: Login with valid credentials
    Given I am on the login page "http://test-app.d6.dev.devcaz.com/admin/login"
    When I enter in the login "admin1"
    And I enter in the password "[9k<k8^z!+$$GkuP"
    And I press Login button
    Then I should see admin panel
