Feature: Login into the application

Scenario Outline: Validation login - Happy Path
    Given Inicialize the browser with chrome
    And Navigate to "http://qaclickacademy.com/" site
    And If modal presents click on close
    And Click on Login link in home page to land on Secure sign in Page
    When User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    
Examples:
|	username 				|	password	|
|	test99@gmail.com		|	123456		|
|	laster123@gmail.com		|	123456		|

