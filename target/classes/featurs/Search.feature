Feature: Search functionality

Scenario: User searches for valid product 
Given User opens the appliction
When User enters valid product "HP" into Search box field
And User clicks on search button
Then User should get valid product displayed in search results

Scenario: User searches for invalid product
Given User opens the appliction
When User enters invaild product "Honda" Into search box fields 
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the appliction
When User dont enter any product name into search box field
And User clicks on search button
Then User should get a message about no product matching


