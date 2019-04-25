Feature: Login to Application

Scenario: User logs into home page with valid credentials

Given User is on the login page
When User enters username into username input field
And User enters password into password field
And User clicks submitt button
Then User is directed to Get Started Page

