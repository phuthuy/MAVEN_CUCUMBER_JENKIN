Feature: Login
  As a PO 
  I want to login to application 
  So that verify login function work well

  @register
  Scenario: Register to application
    Given I open application
    When I click to here link
    And I input to email textbox with data ""
    And I click to Submit button at Register Page
    Then I getuserID infor
    And I getPassword infor
    And I close Browser

  @login
  Scenario: Login to System
    Given I open application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login Page
    Then I verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    And I close Browser

  #Scenario Outline: Login to System with example datatable
  #Given I open application
  #When I input to Username "<Username>"
  #And I input to Password "<password>"
  #And I click to Login button at Login Page
  #Then I verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
  #And I close Browser
  #
  #Examples: Username and password Datatable
  #| Username   | password |
  #| mngr163633 | hEjApuz  |
  #| mngr164840 | ugAhUdU  |
  #| mngr164841 | hapEsyr  |
  @new_customer
  Scenario: Create new Customer
    Given I open application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login Page
    Then I verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open to New Customer page
    And Input to new Customer form with data
      | Name      | Gender | DateOfBirth | Address      | City   | State     | Pin    | Email    | Phone      | Password |
      | Auto Test | m      | 1991-10-10  | 123 Ngoc Hoi | Ha Noi | Thanh tri | 123456 | autotest | 0905699939 |  1234332 |
    And I click to Submit button at New Customer page
    Then verify message displayed with data "Customer Registered Successfully!!!"
    And verify all information create success
      | Name      | Gender | DateOfBirth | Address      | City   | State     | Pin    | Phone      | Email    |
      | Auto Test | male   | 1991-10-10  | 123 Ngoc Hoi | Ha Noi | Thanh tri | 123456 | 0905699939 | autotest |
    When I get Customer ID at New Customer page
    And I close Browser

  @edit_customer
  Scenario Outline: Edit Customer
    Given I open application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login Page
    Then I verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open to EditCustomer page
    And Input Customer ID to textbox
    And I click to submit button at EditCustomer Page
    And Input to edit Customer form with data
      | Address   | City   | State   | Pin   | Phone   | Email   |
      | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    And I click to Submit button at Edit Customer page
    Then Verify message display with data "Customer details update Successfully!!!"
    And I verify all above information edited success
      | Address   | City   | State   | Pin   | Phone   | Email   |
      | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |

    Examples: Edit customer info
      | Address         | City             | State        | Pin    | Phone      | Email        |
      | Edit 123 Le Loi | Edit Ho Chi Minh | Edit Thu Duc | 123456 | 0905699939 | editautotest |
