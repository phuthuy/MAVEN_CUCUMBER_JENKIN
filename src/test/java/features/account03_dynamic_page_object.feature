@account
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
    
  @new_customer
  Scenario Outline: Create New Customer
    Given I open "New Customer" page
    When I input to "name" textbox with data "<Name>"
    And I select "m" radio button
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with "2" data "<Email>"
    And I input to "password" textbox with data "<Password>"
    And I click to "Submit" button
    And verify message "Customer Registered Successfully!!!" displayed success

    #And I sleep with "10" times
    Examples: 
      | Name      | Gender | DateOfBirth | Address    | City | State   | Pin    | Phone      | Email    | Password | Message                           |
      | Auto Test | male   | 01-01-1990  | 123 Le Loi | HCM  | Thu Duc | 123456 | 0905699939 | autoTest |   123123 | Customer Register Successfully!!! |
      | Auto Test | male   | 01-01-1990  | 123 Le Loi | HCM  | Thu Duc | 123456 | 0905699939 | autoTest |   123123 | Customer Register Successfully!!! |
