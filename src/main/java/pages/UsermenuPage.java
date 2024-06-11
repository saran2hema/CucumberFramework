package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class UsermenuPage extends LoginPage {

	public UsermenuPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//div[@id='userNav']")
	public WebElement usermenuDropdown;

	@FindBy (xpath="//div[@id='userNav-menuItems']/a[1]")
	public WebElement myprofile;

	@FindBy (xpath="//div[@id='userNav-menuItems']/a[2]")
	public WebElement mysettings;

	@FindBy (xpath="//div[@id='userNav-menuItems']/a[3]")
	public WebElement devloperConsole;

	@FindBy (xpath="//div[@id='userNav-menuItems']/a[4]")
	public WebElement switcExperience;

	@FindBy (id="PersonalInfo")
	public WebElement personal;

	@FindBy (xpath="//div[@class='setupLeaf']/a[@id='LoginHistory_font']")
	public WebElement loginHistory;

	@FindBy (xpath="//div[@class='pShowMore']/a")
	public WebElement downloadLoginHistory;

	//@FindBy (xpath="//div[@id='userNav-menuItems']/a[5]")
	//public WebElement logout;
	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath="//select[@id='p4']")
	public WebElement customDropdownElm;


	@FindBy(xpath="//select[@id='duel_select_0']")
	public WebElement AvailableDropdownElm;

	@FindBy(xpath = "//*[@id=\"p4\"]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	//WebElement logoutElement=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/a[5]"));
	//String logout=logoutElement.getText();


	public boolean selectUsermenu() {
		boolean usermenuSelected=false;

		if(usermenuDropdown.isDisplayed()) {
			usermenuDropdown.click();
			usermenuSelected=true;
		}
		else {
			System.out.println("Usermenu is not displayed");
		}
		return usermenuSelected;
	}
	public boolean click(WebElement button) {
		boolean buttonClicked=false;
		if(button.isEnabled()) {
			button.click();
			logger.info(button+" is clicked");
			buttonClicked=true;
		}
		return buttonClicked;
	}
	public boolean selectUserMenuOption(WebDriver driver, String option) {
		boolean isOptionVerified = false;
		logger.debug("Selecting an user menu option: "+option);
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (WaitUtils.waitForElement(driver, userMenuOption)) {
			logger.debug(option+" was visible");
			userMenuOption.click();
			logger.debug(option+" was clicked");
			isOptionVerified = true;
		} else {
			System.out.println(option + " Option is not visible");
			logger.debug(option+" Could not be selected");
		}
		return isOptionVerified;
	}
	public boolean verifyUserMenu() {
		boolean usermenuVerified=false;
		String myprofileText=myprofile.getText();
		String mysettingsText=mysettings.getText();
		String developerConsoleTxt=devloperConsole.getText();
		String switcExperienceTxt=switcExperience.getText();
		String logoutText=logoutButton.getText();

		if(myprofileText.equals("My Profile") && mysettingsText.equals("My Settings") &&  developerConsoleTxt.equals("Developer Console") &&
				switcExperienceTxt.equals("Switch to Lightning Experience") && logoutText.equals("Logout")) {
			System.out.println("All usermenu options are as expected");
			usermenuVerified=true;
		}
		return usermenuVerified;
	}

	public boolean verifyPersonal() {
		boolean personalLinkVerified=false;
		personal.click();

		loginHistory.click();

		if(logindisplay.isDisplayed()) {
			personalLinkVerified=true;
			downloadLoginHistory.click();
		}
		else {
			logger.debug(logindisplay+" Issue in login history getting displayed");
			logger.debug(loginHistory+ " unable to verify download login history");
		}

		return personalLinkVerified;
	}
	public boolean verifyDisplayLayout() throws InterruptedException {
		boolean verifiedDisplayLayoutlink=false;
		if (DisplayLayoutlink.isDisplayed())
		{
			DisplayLayoutlink.click();
			CustomizedTab.click();

			//select Custom App dropdown

			Select customTabDropdown=new Select(customApp);
			customTabDropdown.selectByVisibleText("Salesforce Chatter");

			//select Reports in Available tabs duel_select_0
			Select availableTabDropdown=new Select(Availabletab);
			availableTabDropdown.selectByVisibleText("Reports");
			//click Add image(right arrow) //a[@id='duel_select_0_right']
			Add.click();

			//click Save
			save.click();
			Thread.sleep(5000);
			verifiedDisplayLayoutlink=true;
		}else {
			logger.debug(DisplayLayoutlink+"Issue in Display & Layout link");

		}
		return verifiedDisplayLayoutlink;
	}
	public boolean verifyEmailLink(String emailname, String emailAddress, WebDriver driver) throws InterruptedException {
		boolean verifiedEmaillink=false;
		//Email link
		Emaillink.click();
		//My email settings EmailSettings_font
		MyEmailSettings.click();
		//Enter email name
		Emailname.clear();
		Emailname.sendKeys(emailname);

		Emailaddress.clear();
		Emailaddress.sendKeys(emailAddress);
		//check Auto BCC radio button
		BCCradiobutton.click();


		//Click Save
		try {
			System.out.println("testing save button");
			Saveonemail.click();
			verifiedEmaillink=true;
			Alert alert = driver.switchTo().alert();
			//System.out.println("Alert text: " + alert.getText());
			alert.accept();

		}
		catch (Exception e) {
			System.out.println("Exception occured-->"+e);
		}

		return verifiedEmaillink;
	}
	public boolean verifyCalendar(WebDriver driver) throws InterruptedException {
		boolean verifiedCalendar=false;

		//Calendar& Reminders link
		CalendarAndReminders.click();
		//Activity reminders Reminders_font
		ActivityRemainder.click();
		Thread.sleep(5000);
		//click Open a reminder button
		OpenaTestRemainder.click();
		//Thread.sleep(5000);
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			driver.switchTo().window(handle);
		}
		String title=driver.getTitle();
		if(title.contains("Reminder")) {
			driver.switchTo().defaultContent();
			verifiedCalendar=true;
			//driver.quit();
		}
		return verifiedCalendar;
	}
	public boolean verifyDeveloperConsole(WebDriver driver,String title) {
		boolean verifiedDeveloperConsole=false;
		if(devloperConsole.isDisplayed()) {
			devloperConsole.click();	
		}

		Set<String> winhandles=driver.getWindowHandles();
		for(String handle:winhandles) {
			driver.switchTo().window(handle);
		}
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains(title)) {
			verifiedDeveloperConsole=true;
			//driver.close();
		}

		
		return verifiedDeveloperConsole;		
	}
	public boolean verifyLogout(WebDriver driver) throws InterruptedException {
		boolean successLogout=false;

		//Thread.sleep(2000);
		if(logoutButton.isDisplayed())
		{logoutButton.click();
		logger.info("User is logged out");
		}
		//Thread.sleep(4000);

		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Login"));

		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Login")) {
			successLogout=true;
		}
		return successLogout;
	}

}
