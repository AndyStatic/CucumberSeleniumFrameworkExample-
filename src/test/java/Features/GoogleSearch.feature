Feature: Google Search Page
  This feature covers opening of the google search page and do the basic search

  Scenario: Navigation to google search page and search for "Selenium"
    Given I navigate to google search page
    When I enter the search keyword "Selenium"
    And I press the "Google Search" button
    Then list with results is displayed
    And results list contains "Selenium - Web Browser Automation" link

    @TagExample
  Scenario: Login to login example page
    Given I navigate to google search page
    When I enter the search keyword "login example page"
    And I press the "Google Search" button
    Then list with results is displayed
    And results list contains "Login Example - Semantic" link
    When I click the link with title "Login Example - Semantic"
    Then I navigate to page with title "Login Example - Semantic"
    When I enter email address and password via DataTable
    | email        | password   |
    | test@test.te | PassWd123! |
    And I press the "Login" button on login example page
    Then I navigate to page with title "Login Example - Semantic"

  Scenario Outline: Login to login example page with multiple accounts
    Given I navigate to google search page
    When I enter the search keyword "login example page"
    And I press the "Google Search" button
    Then list with results is displayed
    And results list contains "Login Example - Semantic" link
    When I click the link with title "Login Example - Semantic"
    Then I navigate to page with title "Login Example - Semantic"
    When I enter "<email>" email address and "<password>" password
    And I press the "Login" button on login example page
    Then I navigate to page with title "Login Example - Semantic"
    Examples:
      | email         | password   |
      | test@test.te  | PassWd123! |
      | test2@test.te | PassWd124! |