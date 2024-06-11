package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	public WebElement username;

	@FindBy(id="password")
	public WebElement password;

	@FindBy(id="Login")
	public WebElement loginButton;

	@FindBy(xpath="//div[@id='error']")
	public WebElement loginErrorMessage;

	@FindBy(id="rememberUn")
	public WebElement rememberMe;

	@FindBy(xpath="//div[@id='userNav']")
	public WebElement userNavButton;

	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement logoutButton;

	//Username field after logging out in login page
	@FindBy(id="idcard-identity")
	public WebElement rememberUsername;

	@FindBy(xpath="//a[@id='forgot_password_link']")
	public WebElement forgotPasswordlink;

	@FindBy(xpath="//input[@id='un']")
	public WebElement forgotUsername;

	@FindBy (xpath="//input[@id='continue']")
	public WebElement continueButton;

	@FindBy(xpath="//div[@class='message']//p")
	public WebElement resetMessage;


	@FindBy (xpath="//div[@id='error']")
	public WebElement loginErrorElement;

	public boolean enterUsername(String username) {

		boolean usernameEntered=false;
		this.username.clear();
		this.username.sendKeys(username);

		if(this.username.getAttribute("value").equals(username)) {
			usernameEntered=true;
			logger.info("Username is entered successfully");
		}
		return usernameEntered;
	}
	public boolean enterPassword(String password) {

		boolean passwordEntered=false;
		this.password.clear();
		this.password.sendKeys(password);

		if(this.password.getAttribute("value").equals(password)) {
			passwordEntered=true;
			logger.info("Password is entered successfully");
		}
		return passwordEntered;
	}
	public boolean verifyHomePage(WebDriver driver) {
		boolean verifiedHomePage=false;
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Home"));

		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Home")) {
			verifiedHomePage=true;
		}
		return verifiedHomePage;
	}

	public boolean clearPassword() {
		boolean passwordCleared=false;

		this.password.clear();

		if(this.password.getAttribute("value").equals("")) {
			passwordCleared=true;
			logger.info("Password field is cleared");
		}
		return passwordCleared;
	}

	public boolean verifyLoginError() {
		boolean loginError=false;
		String actualErrorMessage=loginErrorMessage.getText();
		String expectedErrorMessage="Please enter your password.";
		if(actualErrorMessage.equals(expectedErrorMessage)) {
			loginError=true;
		}

		return loginError;
	}


	public boolean logintoSFDC(String email, String passWord, WebDriver driver) throws InterruptedException {
		logger.info("Logging in to application");
		boolean verifiedLogin=false;
		username.clear();
		username.sendKeys(email);
		password.clear();
		password.sendKeys(passWord);
		loginButton.click();
		logger.info("Should be signed in to application");
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Home"));

		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Home")) {
			verifiedLogin=true;
		}
		return verifiedLogin;
	}
	public boolean rememberMe() throws InterruptedException {
		boolean remembermeSelected=false;

		if(!rememberMe.isSelected()) {
			rememberMe.click();
			remembermeSelected=true;
			logger.info("Remember me is clicked");
		}

		return remembermeSelected;
	}

	public boolean logout(WebDriver driver) throws InterruptedException {
		//Thread.sleep(2000);
		boolean successLogout=false;
		userNavButton.click();
		logger.info("Usermenu is clicked");
		Thread.sleep(2000);
		logoutButton.click();
		logger.info("User is logged out");
		Thread.sleep(4000);
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Login")) {
			successLogout=true;
		}
		return successLogout;
	}
	public boolean verifyLogout(WebDriver driver) throws InterruptedException {
		//Thread.sleep(2000);
		boolean successLogout=false;
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Login"));
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Login")) {
			successLogout=true;
		}
		return successLogout;
	}

	public boolean verifyUsernameRetained(String actualUsername) {
		boolean usernameRetained=false;
		String unameTxtbox=rememberUsername.getText();
		if(unameTxtbox.equals(actualUsername)) {
			usernameRetained=true;
		}
		return usernameRetained;
	}
	public boolean forgotPassword(WebDriver driver) {
		boolean forgotPasswordClicked=false;
		if(driver.getTitle().contains("Forgot Your Password")) {
			forgotPasswordClicked=true;
		}
		return forgotPasswordClicked;
	}
	public boolean verifyResetMessage() {
		boolean resettingMessage=false;
		/*	if(this.forgotUsername.getAttribute("value").equals(forgotUname)) {
			usernameEntered=true;
			logger.info("Username for forgot password page is entered successfully");
		}  */
		String forgotMessage="We’ve sent you an email with a link to finish resetting your password.";

		if(this.resetMessage.getText().contains(forgotMessage)) {
			resettingMessage=true;
		}
		return resettingMessage;
	}
	public boolean verifyForgotPasswordB(WebDriver driver) {
		boolean loginError=false;
		String actualErrorMessage=loginErrorMessage.getText();
		String expectedErrorMessage="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(actualErrorMessage.equals(expectedErrorMessage)) {
			loginError=true;
		}
		return loginError;
	}
	

}
