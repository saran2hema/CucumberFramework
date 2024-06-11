Feature: Login feature

Background:
Given user launched sfdc login page

Scenario: TC01 Login Error Message - 1
When user enters valid username
And user clears password
And user clicks Login button
Then user should see the appropriate error message1

Scenario: TC02 Login to SFDC
When user enters valid username
And user enters valid password
And user clicks Login button
Then user should see the Home page

Scenario: TC03 Test the remember username check box
When user enters valid username
And user enters valid password
And user selects remember me
And user clicks Login button
Then user should see the Home page
When user selects usermenu and clicks Logout
Then user should see Login page with username and remember username selected

Scenario: TC04 Test Forgot Password 4A
When user clicks forgot password link
Then user should see salesforce forgot password page
When user enters username in forgot password page and clicks continue button
Then user should see password reset message page

Scenario: TC05 Forgot Password 4B
When user enters invalid username
And user enters invalid password
And user clicks Login button
Then user should see the appropriate error message2




