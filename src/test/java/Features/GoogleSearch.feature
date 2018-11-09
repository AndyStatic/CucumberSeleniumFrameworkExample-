Feature: Google Search Page
  This feature covers opening of the google search page and do the basic search

  Scenario: Navigation to google search page and search for "Selenium"
    Given I navigate to google search page
    When I enter the search keyword "Selenium"
    And I press the "Google Search" button
    Then list with results is displayed
    And results list contains "Selenium - Web Browser Automation" link
