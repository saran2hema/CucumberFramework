package stepDefinitions;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import constants.WaitConstants;
import pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;

public class LoginSteps {
	static WebDriver driver;
	static LoginPage lp;

	@Before
	public static void before_or_after_all() {
		// /Users/saran2hema/Downloads/chromedriver-mac-arm64/chromedriver.exe
		//System.setProperty("webdriver.chrome.driver","/Users/saran2hema/Downloads/chromedriver-mac-x64/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		lp=new LoginPage(driver);
	}
	@After
	public static void after_method() {
		driver.close();
	}



	@Given("user launched sfdc login page")
	public void user_launched_sfdc_login_page() throws IOException {
		//driver.get(DataUtils.readLoginTestData("app.url"));
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_DURATION);
	}

	@When("user enters valid username")
	public void user_enters_valid_username() throws IOException {
		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
	}

	@When("user clears password")
	public void user_clears_password() throws IOException {
		lp.password.clear();
	}

	@When("user clicks Login button")
	public void user_clicks_login_button() {
		lp.loginButton.click();
	}

	@Then("user should see the appropriate error message1")
	public void user_should_see_the_appropriate_error_message1() {
		Assert.assertTrue(lp.verifyLoginError(), "TC01_Fail Login Error Message - 1");
		CommonUtils.captureScreenShot(driver);
	}

	@When("user enters valid password")
	public void user_enters_valid_password() throws IOException {
		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
	}


	@Then("user should see the Home page")
	public void user_should_see_the_Home_page() {
		Assert.assertTrue(lp.verifyHomePage(driver), "Fail-Homepage not seen after clicking Login button");
	}

	@When("user selects remember me")
	public void user_selects_remember_me() throws InterruptedException {
		Assert.assertTrue(lp.rememberMe(),"Issue in selecting rememberMe");
	}

	@When("user selects usermenu and clicks Logout")
	public void user_selects_usermenu_and_clicks_Logout() throws InterruptedException {
		lp.userNavButton.click();
		lp.logoutButton.click();

	}


	@Then("user should see Login page with username and remember username selected")
	public void user_should_see_login_page_with_username_and_remember_username_selected() throws InterruptedException, IOException {
		Assert.assertTrue(lp.verifyLogout(driver),"Issue in logout and Home Page not seen");
		Assert.assertTrue(lp.verifyUsernameRetained(DataUtils.readLoginTestData("valid.username")),"TC03-->Fail Valid username not retained");
	}

	@When("user clicks forgot password link")
	public void user_clicks_forgot_password_link() {
		lp.forgotPasswordlink.click();

	}

	@Then("user should see salesforce forgot password page")
	public void user_should_see_salesforce_forgot_password_page() {
		Assert.assertTrue(lp.forgotPassword(driver), "Issue in clicking forgot password link");
	}

	@When("user enters username in forgot password page and clicks continue button")
	public void user_enters_username_in_forgot_password_page_and_clicks_continue_button() throws IOException {
		lp.forgotUsername.sendKeys(DataUtils.readLoginTestData("valid.username"));
		lp.continueButton.click();
	}

	@Then("user should see password reset message page")
	public void user_should_see_password_reset_message_page() {
		Assert.assertTrue(lp.verifyResetMessage(), "TC04_ForgotPasswordA --> Fail");
	}

	@When("user enters invalid username")
	public void user_enters_invalid_username() throws IOException {
		lp.username.sendKeys(DataUtils.readLoginTestData("invalid.username"));
	}

	@When("user enters invalid password")
	public void user_enters_invalid_password() throws IOException {
		lp.password.sendKeys(DataUtils.readLoginTestData("invalid.password"));
	}

	@Then("user should see the appropriate error message2")
	public void user_should_see_the_appropriate_error_message2() {
		Assert.assertTrue(lp.verifyForgotPasswordB(driver), "TC05_ForgotPasswordB --> Fail");
	}

}
