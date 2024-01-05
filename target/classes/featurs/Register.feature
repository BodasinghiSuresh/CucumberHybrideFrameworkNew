Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to register account page
When User enters the details into below fields
|firstName     |Bodasinghi                 |
|lastName      |Suresh                     |
|Telephone     |9632634579                 |
|password      |123456789                  |
And User selects private policy
And User clicks on continue button
Then User account should get created sucessfully


Scenario: User creates an account with all fields 
Given User navigates to register account page
When User enters the details into below fields
|firstName     |Bodasinghi                 |
|lastName      |Suresh                     |
|Telephone     |9632634579                 |
|password      |123456789                  |
And User yes for newsletter
And User selects private policy
And User clicks on continue button
Then User account should get created sucessfully


Scenario: User creates a duplicate account 
Given User navigates to register account page
When User enters the details into below fields with duplecate email
|firstName     |Bodasinghi                 |
|lastName      |Suresh                     |
|email         |bodasinghisuresh@gmail.com |
|Telephone     |9632634579                 |
|password      |9550362600                  |
And User yes for newsletter
And User selects private policy
And User clicks on continue button
Then User should get a proper warning about duplicate email


Scenario: User creates an account without filling any details
Given User navigates to register account page
When User dont enter any details into fields
And User clicks on continue button
Then User should get a proper warning messages for every mandatory field 









