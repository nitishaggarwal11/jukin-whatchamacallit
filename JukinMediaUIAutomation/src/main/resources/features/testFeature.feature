# Feature to cover the Jukin Media UI automation
Feature: Jukin Media UI Automation 

  #Scenario to cover the flow of Login Functionality	
  @JukinMedia
  Scenario: Login to the application to view the success message
    Given User launches the Jukin Media application
    When User enters "quality" as username and "Test1ng" as the password
    And Click on Login button
    Then User navigates to the Login success page
    
    
  #Scenario to check the Incorrect email/password combination
  @JukinMedia
  Scenario: To check the Incorrect email/password combination
    Given User launches the Jukin Media application
    When User enters "abcd" as username and "Test1ng" as the password 
    And Click on Login button
    Then Incorrect email password combination message will be shown to the user
    
    
  #Scenario to cover the flow of Forgot Password Functionality	
  @JukinMedia
  Scenario: To check the Forgot Password Functionality
    Given User launches the Jukin Media application
    When User clicks on Forgot Password button
    Then User navigates to the forgot password page
    When User enters "test@gmail.com" as email in the field
    And Clicks on Submit button on Forgot password page
    Then Password Reset Successful popup will display
    
    
  #Scenario to check the invalid email functionality in Forgot password page	
  @JukinMedia
  Scenario: To check the invalid email message on Forgot Password Page
    Given User launches the Jukin Media application
    When User clicks on Forgot Password button
    Then User navigates to the forgot password page
    When User enters "test2@.com" as email in the field
    And Clicks on Submit button on Forgot password page
    Then Invalid email message will display on the forgot password page
    
    
  #Scenario to cover the flow of Registration Functionality	
  @JukinMedia
  Scenario: To check the Registration Functionality
    Given User launches the Jukin Media application
    When User clicks on Register button
    Then User navigates to the Register page
    When User enters "test3@gmail.com" as email and "Test@1234" as Password in the fields
    And Clicks on Submit button on Registration page
    Then User navigates to the registration success page
    
    
  #Scenario to check the invalid email functionality on Registration page	
  @JukinMedia
  Scenario: To check the invalid email message on Registration Page
    Given User launches the Jukin Media application
    When User clicks on Register button
    Then User navigates to the Register page
    When User enters "test4@.gov" as email and "Test@123456" as Password in the fields
    And Clicks on Submit button on Registration page
    Then Invalid email message will display on the register page
    
    
  #Scenario to check the invalid password confirmation functionality on Registration page	
  @JukinMedia
  Scenario: To check the invalid password confirmation message on Registration Page
    Given User launches the Jukin Media application
    When User clicks on Register button
    Then User navigates to the Register page
    When User enters "test5@gmail.com" as email and "aabbcc123" as Password in the fields and blank in confirm password
    And Clicks on Submit button on Registration page
    Then Invalid password confirmation message will display on the register page
    
    
  #Scenario to check the Fill out all fields message on Registration page	
  @JukinMedia
  Scenario: To check the invalid password confirmation message on Registration Page
    Given User launches the Jukin Media application
    When User clicks on Register button
    Then User navigates to the Register page
    When User enters "test5@gmail.com" as email and blank in the Password and Confirm password fields
    And Clicks on Submit button on Registration page
    Then Fill out all fields message will display on the register page
    
    