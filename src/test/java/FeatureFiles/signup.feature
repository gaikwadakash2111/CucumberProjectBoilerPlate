Feature: Salesforce SignUp Functionality

@smoketest
Scenario: To verify sign up by entering partial data
Given I am a user opening home page of Salesforce web application
And I click on Try For Free button
Then I verify sign up page is displayed
When I enter the name "akshay"
And I enter the surname "meena"
And I enter the email address "akshaymeena123@gmail.com"
And I select the employee from dropdown
And I click on signup button
Then I validate that the error message should displayed
