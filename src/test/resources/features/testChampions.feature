@all
Feature: Log in WWE Champions Web Portal, change Avatar and Frame for the Player and logged out

  Background: User navigates to WWE Champions webpage for login
    Given User is in initial page and title should by "WWE Champions"
    Then User clicks on initial login button
    And User clicks on login with ScopelyID button

  @firstTestCase
  Scenario: Login and change Avatar for the Player
    And User fills "styopa.hovhannisyan@gmail.com" in username field
    And User fills "Champions1987" in password field
    And User clicks on submit button
    And User clicks on account settings button
    And User clicks on change avatar button
    And User gets avatar attribute value for comparing
    And User changes avatar
    And User applies to change avatar
    And User checks that avatar is changed
    And User clicks on account settings button
    And User logouts the page

  @secondTestCase
  Scenario: Login and change Frame for the Player
    And User clicks on account settings button
    And User clicks on change avatar button
    And User clicks on change frame button
    And User gets frame attribute value for comparing
    And User changes frame
    And User applies to change frame
    And User checks that frame is changed
    And User clicks on account settings button
    And User logouts the page
