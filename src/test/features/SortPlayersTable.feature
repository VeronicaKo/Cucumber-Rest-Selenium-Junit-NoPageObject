@sortplayerstable
Feature: Opening table of players

  Scenario: Open players in admin interface
    Given I am on the login page "http://test-app.d6.dev.devcaz.com/admin/login"
    When I enter in the login "admin1"
    And I enter in the password "[9k<k8^z!+$$GkuP"
    And I press Login button
    And I select the menu administration item by number "6"
    And I click on the button players
    And I should see table of players with "20" item
    And I click heading Username of Players table
    Then I check sorting of Username
