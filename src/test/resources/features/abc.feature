Feature: My feature

  @cucumber-test
  Scenario: Log in
    Given I navigate on the page
      Then Application is displayed
      When I choose to sign in
        Then the "Authentication" page is displayed
        When I enter the "test_test@test.com" "email" for Log in
        When I enter the "Test1234!" "password" for Log in
        When I click on the Submit button to Log in
          Then the "My Account" page is displayed


