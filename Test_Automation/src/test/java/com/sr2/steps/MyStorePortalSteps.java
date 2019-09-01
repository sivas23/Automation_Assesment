package com.sr2.steps;

import com.sr2.pages.MyStorePortalPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;


public class MyStorePortalSteps extends CommonSteps {

	
	public MyStorePortalPage registrationPage;
	public static String email_id;
	
	public MyStorePortalSteps(){

		registrationPage = new MyStorePortalPage(driver);
	}
		
	@Given("^I am on My Store form$")
	public void i_am_on_My_Store_form() throws Throwable {
		registrationPage.gotoHomePage();
		assertTrue(registrationPage.isYourLogoImageDisplayed());
	}
	
	@When("^I click on Sign in option$")
	public void i_click_on_Sign_in_option() throws Throwable {
		registrationPage.clickOnSignInButton();
	}

	@Then("^It should allow email to create account$")
	public void it_should_allow_email_to_create_account() throws Throwable {
		email_id=registrationPage.enterEmailAddress();
	}

	@Then("^I click on Create an account button$")
	public void i_click_on_Create_an_account_button() throws Throwable {
		registrationPage.clickOnCreateAnAccountButton();
	}

	@When("^I fill the registration details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_fill_the_registration_details_as_and(String title, String firstName, String lastName, String password, String addressLine1, String city, String state, String postCode, String country, String mobilePhone) throws Throwable {
		registrationPage.selectTitle(title);
		registrationPage.enterCustFirstName(firstName);
		registrationPage.enterCustLastName(lastName);
		registrationPage.enterPassword(password);;
		registrationPage.enterAddressLine1(addressLine1);
		assertEquals(firstName, registrationPage.isFirstNamePresent());
		assertEquals(lastName, registrationPage.isLastNamePresent());
		registrationPage.enterCity(city);
		registrationPage.selectState(state);
		registrationPage.enterPostCode(postCode);
		registrationPage.selectCountry(country);
		registrationPage.enterMobilePhone(mobilePhone);		
		assertEquals("My address", registrationPage.isAddressAliasPresent());
	}
	
	@When("^I click on Register button$")
	public void i_click_on_Register_button() throws Throwable {
		registrationPage.clickOnRegisterButton();
	}

	@Then("^I should login successfully as registered user$")
	public void i_should_login_successfully_as_registered_user() throws Throwable {
	   assertTrue(registrationPage.welcomeToYourAccountSuccesfulMessage().contains("Welcome to your account"));
	   System.out.println("yes");
	}
	
	@Then("^I should logout successfully$")
	public void i_should_logout_successfully() throws Throwable {
		registrationPage.clickOnLogoutOption();
	}
	
	@When("^I login back to my store portal using above created user and password \"([^\"]*)\"$")
	public void i_login_back_to_my_store_portal_using_above_created_user_and_password(String password) throws Throwable {
		registrationPage.clickOnSignInButton();
		registrationPage.enterRegisterEmailAddress(email_id);
		registrationPage.enterRegisteredUserPassword(password);
		registrationPage.clickOnSignForLogin();
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
		assertTrue(registrationPage.welcomeToYourAccountSuccesfulMessage().contains("Welcome to your account"));
	}
	
	@Given("^I login as registered user email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_as_registered_user_email_and_password(String email, String password) throws Throwable {
		registrationPage.clickOnSignInButton();
		registrationPage.enterRegisterEmailAddress(email);
		registrationPage.enterRegisteredUserPassword(password);
		registrationPage.clickOnSignForLogin();
	}

	@When("^I add first item to the cart from the dresses section$")
	public void i_add_first_item_to_the_cart_from_the_dresses_section() throws Throwable {
		registrationPage.clickOnDressesOption();
		registrationPage.clickOnCasualDressesOption();
		registrationPage.selectFirstProductFromCasualDressesItem();
		registrationPage.clickOnAddToCartButton();
		assertTrue(registrationPage.checkItemInYourCartMessage().contains("There is 1 item in your cart."));
		registrationPage.clickonProceedToCheckOutAfterAddingCart();
		registrationPage.clickonproceedToCheckOutWithDeliveryAddress();
		
	}

	@When("^Proceed to checkout with the default delivery address$")
	public void proceed_to_checkout_with_the_default_delivery_address() throws Throwable {
		registrationPage.clickonproceedToCheckOutWithDefaultDeliveryAddress();
	}

	@When("^I accept the terms and conditions for Shipping$")
	public void i_accept_the_terms_and_conditions_for_Shipping() throws Throwable {
		registrationPage.selectAcceptTermOfService();
		registrationPage.clickOnProceedToCheckOutInShipping();
	}

	@When("^select payment method as \"([^\"]*)\"$")
	public void select_payment_method_as(String arg1) throws Throwable {
		registrationPage.clickOnBankWirePayOption();
	}

	@When("^I confirm my order$")
	public void i_confirm_my_order() throws Throwable {
		registrationPage.clickOnConfirmOrderButton();
	}

	@Then("^I should see my order is created successfully$")
	public void i_should_see_my_order_is_created_successfully() throws Throwable {
		assertTrue(registrationPage.OrderCompleteMessage().contains("Your order on My Store is complete."));
	}


	@When("^I login with unregistered user email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_with_unregistered_user_email_and_password(String email, String password) throws Throwable {
		registrationPage.clickOnSignInButton();
		registrationPage.enterRegisterEmailAddress(email);
		registrationPage.enterRegisteredUserPassword(password);
		registrationPage.clickOnSignForLogin();
	}

	
	@Then("^I should throw Authentication failed error$")
	public void i_should_throw_Authentication_failed_error() throws Throwable {
		assertTrue(registrationPage.loginFailError().contains("Authentication failed"));
	}

	@When("^I add first item to the cart from the summer dresses section$")
	public void i_add_first_item_to_the_cart_from_the_summer_dresses_section() throws Throwable {
		registrationPage.clickOnDressesOption();
		registrationPage.clickOnSummerDressesOption();
		registrationPage.mouseOverToClickQuickViewText();
		registrationPage.clickOnQuickViewFirstProductFromSummerDressesItem();
		registrationPage.selectItemSize("M");
		registrationPage.selectBlackColor();
		//assertTrue(registrationPage.getSelectedColor().equals("Black"));
		registrationPage.clickOnAddToCartButton();
		assertTrue(registrationPage.checkItemInYourCartMessage().contains("There is 1 item in your cart."));
		registrationPage.clickonProceedToCheckOutAfterAddingCart();
		registrationPage.clickonproceedToCheckOutWithDeliveryAddress();

	}
	
	

}
