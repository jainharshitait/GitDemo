Feature: Application login

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://rahulshettyacademy.com" site
And click on login link in home page to land on secure sign in page
When User login into application with <username> and <password> 
Then verify that user is successfuly logged in

Examples:
|username                           |password       |
|harshita.jain.sweetz@gmail.com     |harshita@9     |
|cdc@gmai.com                       |123456          |

