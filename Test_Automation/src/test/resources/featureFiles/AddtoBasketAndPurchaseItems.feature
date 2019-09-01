@regression
Feature: purchase item

	Scenario: Adding to bakset and purchase
	  Given I am on My Store form
  	  When I login as registered user email "rtqdl@kqhuh.com" and password "jonnyhiles"
  	  Then I should be able to login successfully
  	  When I add first item to the cart from the dresses section
  	  And Proceed to checkout with the default delivery address
  	  And I accept the terms and conditions for Shipping
  	  And select payment method as "Bank-wire payment"
  	  And I confirm my order
  	  Then I should see my order is created successfully

	Scenario: Adding items using quick view to bakset and change size, color and purchase
		Given I am on My Store form
		When I login as registered user email "rtqdl@kqhuh.com" and password "jonnyhiles"
		Then I should be able to login successfully
		When I add first item to the cart from the summer dresses section
		And Proceed to checkout with the default delivery address
		And I accept the terms and conditions for Shipping
		And select payment method as "Bank-wire payment"
		And I confirm my order
		Then I should see my order is created successfully

  Scenario: Login Unsuccessfully
  	Given I am on My Store form
  	When I login with unregistered user email "Robert@Smith.com" and password "RobertSmith"
  	Then I should throw Authentication failed error



  	
    	
  	