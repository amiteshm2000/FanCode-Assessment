
Feature: User Login Feature

    
Scenario: All the users of City `FanCode` should have more than half of their todos task completed.
Given User has the todo tasks
And User belongs to the city FanCode
Then User Completed task percentage should be greater than 50%


  #In order to access the application
  #As a registered user
  #I want to log in with my username and password
#
  #Scenario: Successful Login with Valid Credentials
    #Given I am on the login page
    #When I enter valid username "user1" and password "password1"
    #Then I should see the dashboard page
#
  #Scenario Outline: Login Attempts with Different Credentials
    #Given I am on the login page
    #When I enter username "<username>" and password "<password>"
    #Then I should see an error message "<errorMessage>"
#
  #Examples:
    #| username       | password       | errorMessage                  |
    #| invalidUser1   | wrongPassword1 | Invalid username or password   |

