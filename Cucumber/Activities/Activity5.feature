@activity5
Feature: Login test

  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<username>" and "<password>"
    Then Read the page title and confirmation message
    Then close the browser
    Examples:
      | username | password |
      | admin    | password |