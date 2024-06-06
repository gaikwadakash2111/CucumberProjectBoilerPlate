Feature: Salesforce login functionality

@scenario1
Scenario: to valiadte username textField is enabled
Given I am a user opening home page of Salesforce web application
When I click on usernametextField
Then I validate the UNTF is enabled

@scenario2
Scenario: to validate functionality of login button by entering valid UN and invalid PWD
Given I am a user opening home page of Salesforce web application
And I enter username "admin" and I enter password "admin@123"
And I click on login button
Then Error message should be displayed



