@Amazon
Feature: Test Amazon Search Functionality

@Cart
Scenario Outline: As a customer, I want to see if the third option on the second page is available for purchase and can be added to the cart.
Given The user navigates to www.amazon.com
And searches for <product>
And navigates to the page number 2
And selects the third item
Then the user is able to add it to the cart

Examples:
    | product       | 
    | Alexa         |
    