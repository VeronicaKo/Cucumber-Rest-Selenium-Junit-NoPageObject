Feature: Opening table of players

  Scenario: Open players in admin interface
    Given I am in the admin page
    When I click on the button user
    And I click on the button players
    Then I should see table of players