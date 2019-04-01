Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Common step
    #-------------Action-------------------#
    #Textbox
    And I input to "" textbox with data ""
    And I input to "" textbox with random data ""
    #0=fix data | 1= random data
    And I input to "" textbox with "0" data ""
    And I input to "" textbox with "1" data ""
    And I input to "email" textbox with "2" data "autotest"
    ## autotest0934@gmail.com
    And I input to "" textbox with "1" data ""
    #Text Area
    And I input to "" textarea with data ""
    #Dropdown
    And I select item in "selaccount" dropdown with data "Current"
    And I select item in "selaccount" dropdown with data "Saving"
    #Link 
    And I open "" page
    # Regex 
    And I input first Account ID
    And I input first Account ID
    And I transfer to "<Amount>" USD
    And I withdraw to "<Amount>" USD
    #Radio button
    And I select "m" radio button
    And I select "f" radio button
    #------------------Click-----------------------------#
    And I click to "" button
    # ----------------------------Verify-------------------#
    And verify message "Customer Registered Successfully!!!" displayed success
    And verify message "Customer details updated Successfully!!!" displayed success
    And verify message "Account Generated Successfully!!!" displayed success
    #-----------------Wait--------------------------------#
    And I sleep with "" times