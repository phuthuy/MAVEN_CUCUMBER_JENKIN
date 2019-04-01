Feature: Open app
  As a PO
  I want to open to application

  @register
  Scenario: Register to application
    Given I get Login Url
    When i click to here link
    And i input to email textbox with data "autorandom"
    And I click to Submit button at Register page
    Then I get UserID infor
    When I open Login page again

  @login
  Scenario: Login to application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login Page
    Then Verify Home page display with message "Welcome To Manager's Page of Guru99 Bank"
