Feature: Sign up of a new user
  As a new user I want to sign up

  Background:
    Given I am on home page an accept all cookies

  @regression
  Scenario: I want to sign up as a new user
    When I click on sign up
    And I enter email and password
    And I click on register button
    And I add additional information
    Then I can see sign out option

  @regression
  Scenario Outline: User can login with credentials
    When I enter "<email>" in email field
    And I enter "<password>" in password field
    And I click on login button
    Then I verify "<error message>"
    Examples:
    |      email       | password |                                             error message                                                                                           |
    | abcabd@gmail.com |  123456  | The email address or password entered is invalid. Please use the Forgot Password link to reset your password or click Sign Up to create an account. |
    | abs snaj         | Pass@1234| The email address or password entered is invalid. Please use the Forgot Password link to reset your password or click Sign Up to create an account. |
    | bobnah@gmail.com | bob12345 | The email address or password entered is invalid. Please use the Forgot Password link to reset your password or click Sign Up to create an account. |


