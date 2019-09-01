package com.sr2.pages;

import com.sr2.test.configutils.ConfigUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyStorePortalPage {
	
private WebDriver driver;
public String email;
	
	@FindBy(id="depositpaid")
    private WebElement depositPaid;	
	
	@FindBy(css=".login")
    private WebElement signIn;
	
	@FindBy(id="email_create")
    private WebElement emailCreate;
		
	@FindBy(id="SubmitCreate")
    private WebElement createAnAccount;
	
	@FindBy(id="id_gender1")
    private WebElement titleMr;
	
	@FindBy(id="id_gender2")
    private WebElement titleMrs;
	
	@FindBy(id="customer_firstname")
    private WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
    private WebElement custLastName;
	
	@FindBy(id="email")
    private WebElement emailAddress;	

	@FindBy(id="passwd")
    private WebElement passwordField;
	
	@FindBy(id="firstname")
    private WebElement firstNameConfirm;

	@FindBy(id="lastname")
    private WebElement lastNameConfirm;
	
	@FindBy(id="address1")
    private WebElement AddressLine1;
	
	@FindBy(id="city")
    private WebElement city;
	
	@FindBy(id="id_state")
    private WebElement state;
	
	@FindBy(id="postcode")
    private WebElement postCode;
	
	@FindBy(id="id_country")
    private WebElement country;
	
	@FindBy(id="phone_mobile")
    private WebElement mobilePhone;
	
	@FindBy(id="alias")
    private WebElement addressAlias;
	
	@FindBy(id="submitAccount")
    private WebElement RegisterButton;
	
	@FindBy(css=".logo.img-responsive")
    private WebElement yourLogoImage;
	
	@FindBy(css=".info-account")
    private WebElement welcomeToYourAccount;

	@FindBy(css=".logout")
    private WebElement logOut;
	
	@FindBy(id="SubmitLogin")
    private WebElement submitLogin;
	
	@FindBy(xpath=".//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesButton;
	
	@FindBy(xpath=".//*[@id='categories_block_left']/div/ul/li[1]/a")
    private WebElement casualDressesOption;
		
	@FindBy(css=".product_list.grid.row>li:nth-child(1)>div>div.right-block>h5>a")
	private WebElement productItemInCasualDresses;
	
	@FindBy(css="p#add_to_cart>.exclusive")
    private WebElement addToCartButton;

	@FindBy(css="h2 .ajax_cart_product_txt")
    private WebElement ItemInYourCartMessage;
	
	@FindBy(css=".btn.btn-default.button.button-medium>span")
	private WebElement proceedToCheckOutAfterAddingCart;
	
	@FindBy(css=".button.btn.btn-default.standard-checkout.button-medium>span")
	private WebElement proceedToCheckOutWithDeliveryAddress1;
	
	@FindBy(css="p.cart_navigation.clearfix>.button.btn.btn-default.button-medium")
	private WebElement proceedToCheckOutWithDeliveryAddress2;
	
	@FindBy(css="#cgv")
	private WebElement acceptTermsOfService;
	
	@FindBy(css=".button.btn.btn-default.standard-checkout.button-medium")
	private WebElement proceedToCheckOutInShipping;
	
	@FindBy(css=".bankwire")
	private WebElement selectBankWirePaymentOption;
	
	@FindBy(css="p#cart_navigation>.button.btn.btn-default.button-medium")
	private WebElement confirmOrderButton;
	
	@FindBy(css=".box")
	private WebElement MyStoreOrderCompleteMessage;
	
	@FindBy(css=".alert.alert-danger")
	private WebElement loginFailedError;

	@FindBy(css="li.ajax_block_product:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(3) > span:nth-child(1)")
	private WebElement quickViewIcon;

	@FindBy(xpath=".//*[@id='categories_block_left']/div/ul/li[3]/a")
	private WebElement summerDressesOption;

	@FindBy(id="group_1")
	private WebElement sizeDropDown;


	public MyStorePortalPage(WebDriver driver){
		 ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
	     PageFactory.initElements(finder, this);
		 this.driver = driver;
	}
	
	public void gotoHomePage() {
		driver.get(ConfigUtils.getWebEndPoint());
	}

	public void clickOnSignInButton(){
		signIn.click();
	}
	
	public String enterEmailAddress(){
		String emailfirstPart = RandomStringUtils.randomAlphabetic(5).toLowerCase(); 
		String emailSecPart = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String email = emailfirstPart+"@"+ emailSecPart+ ".com";
		emailCreate.sendKeys(email);
		return email;
	}
	
	public void clickOnCreateAnAccountButton(){
		createAnAccount.click();
	}
			
	public void selectTitle(String title){
		if(title.toLowerCase().contains("mrs.")){
			titleMrs.click();
		}else{
			titleMr.click();
		}
	}	
	
	public void enterCustFirstName(String firstName){
		custFirstName.sendKeys(firstName);
	}
	
	public void enterCustLastName(String lastName){
		custLastName.sendKeys(lastName);
	}
	
	public boolean isEmailAddressPresent(){
		boolean emailFlag = false;
		String email = emailAddress.getAttribute("value");
		if(email!=null){
			emailFlag = true;
		}
		return emailFlag;		
	}
	
	public void enterPassword(String passwrd){
		passwordField.sendKeys(passwrd);
	}
	
	public String isFirstNamePresent(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 String fname= (String) js.executeScript("return window.jQuery('#firstname').val()");
		 return fname;
	}
	
	public String isLastNamePresent(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 String lname= (String) js.executeScript("return window.jQuery('#lastname').val()");
		 return lname;		
	}
	
	public void enterAddressLine1(String addressLine1){
		AddressLine1.sendKeys(addressLine1);
	}
	
	public void enterCity(String cityName){
		city.sendKeys(cityName);
	}
	
	public void enterState(String stateName){
		state.sendKeys(stateName);
	}
	
	public void selectState(String countryVal){
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText(countryVal);
	}	
	
	public void enterPostCode(String postCodeNo){
		postCode.sendKeys(postCodeNo);
	}
	
	public void selectCountry(String countryVal){
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText(countryVal);
	}	
	
	public void enterMobilePhone(String mobileNo){
		mobilePhone.sendKeys(mobileNo);
	}
	
	public String isAddressAliasPresent(){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 String address= (String) js.executeScript("return window.jQuery('#alias').val()");
		 return address;
	}
		
	public boolean isYourLogoImageDisplayed(){
		return yourLogoImage.isDisplayed();		
	}	
	
	public void clickOnRegisterButton(){
		RegisterButton.click();
	}
	
	public String welcomeToYourAccountSuccesfulMessage(){
		return welcomeToYourAccount.getText();
	}
	
	public void clickOnLogoutOption(){
		logOut.click();
	}

	public void enterRegisterEmailAddress(String email_id) {
		emailAddress.clear();
		emailAddress.sendKeys(email_id);
	}

	public void enterRegisteredUserPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
		
	}

	public void clickOnSignForLogin() {
		submitLogin.click();
	}

	public void clickOnDressesOption() {
		dressesButton.click();
	}

	public void clickOnCasualDressesOption() {
		casualDressesOption.click();
	}
	
	public void selectFirstProductFromCasualDressesItem() {
		productItemInCasualDresses.click();
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(By.cssSelector("p#add_to_cart>.exclusive")).click();
		swithBackToMain();
	}
	
	public String checkItemInYourCartMessage() throws Throwable{
		SwithToActiveElement();
		Thread.sleep(2000);
		return ItemInYourCartMessage.getText();
	}
	
	public void clickonProceedToCheckOutAfterAddingCart() {
		proceedToCheckOutAfterAddingCart.click();
	}
	
	public void clickonproceedToCheckOutWithDeliveryAddress() {
		proceedToCheckOutWithDeliveryAddress1.click();
	}
	
	public void clickonproceedToCheckOutWithDefaultDeliveryAddress() {
		proceedToCheckOutWithDeliveryAddress2.click();
	}
	
	public void selectAcceptTermOfService() {
		acceptTermsOfService.click();
	}
	
	public void clickOnProceedToCheckOutInShipping() {
		proceedToCheckOutInShipping.click();
	}
	
	public void clickOnBankWirePayOption() {
		selectBankWirePaymentOption.click();
	}
	
	public void clickOnConfirmOrderButton() {
		confirmOrderButton.click();
	}
	
	public String OrderCompleteMessage(){
		return MyStoreOrderCompleteMessage.getText();
	}
	
	public void SwithToActiveElement(){
		driver.switchTo().activeElement();
	}
	
	public String loginFailError()  {
		waitForElementVisible(".alert.alert-danger",5);
		return loginFailedError.getText();
	}

	public void clickOnQuickViewFirstProductFromSummerDressesItem() {

		waitForElementVisible("li.ajax_block_product:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a:nth-child(3)>span:nth-child(1)", 10);
		WebElement quickView1 = driver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a:nth-child(3)>span:nth-child(1)"));
		waitForElementVisible("li.ajax_block_product:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a:nth-child(3)>span:nth-child(1)",10);
		quickView1.click();
	}

	public void clickOnSummerDressesOption() {
		summerDressesOption.click();
	}

	public void selectItemSize(String sizeVal){
		swithToIFrame();
		Select dropdown = new Select(sizeDropDown);
		dropdown.selectByVisibleText(sizeVal);
	}

	public void clickOnColorOfItem(String colorVal) {
		summerDressesOption.click();
	}

	public void mouseOverToClickQuickViewText(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement quickView = driver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>a:nth-child(3)>span:nth-child(1)"));

		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);";

		js.executeScript(javaScript,quickView);
	}

	public void swithToIFrame(){
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id, 'fancybox-frame')]")));
	}

	public void swithBackToMain(){
		driver.switchTo().defaultContent();
	}


	public void selectBlackColor() throws InterruptedException {
		waitForElementVisible("#color_11", 10);
		driver.findElement(By.cssSelector("#color_11")).click();
	}

	public String getSelectedColor() {
		String colorname=driver.findElement(By.cssSelector("fieldset>div>ul>li[class='selected']")).getAttribute("title");
		return colorname;
	}

	public void waitForElementVisible(String elementLocator, int timesecs){
		WebElement element = (new WebDriverWait(driver, timesecs))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementLocator)));
	}

}
