@regression
Feature: Register user login successfully

  Scenario Outline: create new user and verify logout and login back	 
    Given I am on My Store form
    When I click on Sign in option
    Then It should allow email to create account
    And I click on Create an account button
    And I fill the registration details as "<Title>","<FirstName>","<LastName>","<Password>","<AddressLine1>","<City>","<State>","<PostCode>","<Country>" and "<MobilePhone>"
    When I click on Register button
    Then I should login successfully as registered user
    And I should logout successfully
    When I login back to my store portal using above created user and password "<Password>"
    Then I should be able to login successfully

    Examples: 
      | Title | FirstName | LastName | Password   | AddressLine1           | City      | State      | PostCode | Country       | MobilePhone |
      | Mr.   | Jonny     | Hiles    | jonnyhiles | 2850 Reynard Way Apt 7 | San Diego | California | 92103    | United States | 0123456789  |
     