@all @frame
Feature: Log in WWE Champions Web Portal, change Frame for the Player and logged out

  Scenario: Login and change Frame for the Player
    Given User is in initial page and title should by "WWE Champions"
    Then User clicks on initial login button
    And User clicks on login with ScopelyID button
    And User fills "styopa.hovhannisyan@gmail.com" in username field
    And User fills "Champions1987" in password field
    And User clicks on submit button
    And User clicks on account settings button
    And User clicks on change avatar button
    And User clicks on change frame button
    And User gets frame attribute value for comparing
    And User changes frame
    And User applies to change frame
    And User checks that frame is changed
    And User clicks on account settings button
    And User logouts the page