@Amazon
Feature: Test Amazon Search Functionality

@Cart
Scenario Outline: As a customer, I want to see if the third option on the second page is available for purchase and can be added to the cart.
Given the user navigates to www.amazon.com
And Searches for <product>
And navigates to the second page
And selects the third item
Then the user is able to add it to the cart

Examples:
    | product     | 
    | Alexa       |
    | PlayStation |

