Feature: Login functionality

Scenario Outline: LOgin with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User has entered valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username                          | password    |
|bodasinghisuresh@gmail.com				 | 9550362600  |
|bodasinghi1991qa@gmail.com        | 123456789	 |

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address 
And User enters invalid password "123456789" into password field
And User clicks on login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "bodasinghisuresh@gmail.com" into email field
And User enters invalid password "123456789" into password field
And User clicks on login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address 
And User has entered valid password "9550362600" into password field
And User clicks on login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter emil address into email field
When User dont enter password into password field
And User clicks on login button
Then User should get a proper warning message about credentials missmatch






