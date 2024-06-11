package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class CreateAccountPage extends UsermenuPage{
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Account_Tab")
	public WebElement accountTab;
	
	@FindBy(className="mruText")
	public WebElement accountName;
	
	@FindBy(id="userNavLabel")
	public WebElement userLabel;
	
	//New link
	@FindBy(xpath="//input[@title='New']")
	public WebElement newButton;
	
	@FindBy(xpath="//input[@id='acc2']")
	public WebElement newAccountNameElement;
	
	@FindBy(xpath="//select[@id='00Nak0000011eZY']")
	public WebElement customerPriority;
	
	@FindBy(id="acc6")
	public WebElement typeElement;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']/input[@title='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath="//h2[@class='topName']")
	public WebElement topAccountname;
	
	//View
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	public WebElement createNewViewlink;
	
	@FindBy(xpath="//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath="//input[@id='devname']")
	public WebElement viewUniqueName;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']/table//input[@class='btn primary']")
	public WebElement save;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement editLink;
	
	//Edit  view
	@FindBy(xpath="//select[@title='View:']")
	public WebElement viewList;
	
	@FindBy(xpath="//select[@id='fcol1']")
	public WebElement filter;
	
	@FindBy(xpath="//select[@id='fop1']")
	public WebElement operator;
	
	@FindBy(xpath="//input[@id='fval1']")
	public WebElement valueField;
	
	@FindBy(xpath="//select[@id='colselector_select_0']")
	public WebElement display;
	
	@FindBy(xpath="//a[@id='colselector_select_0_right']/img[@class='rightArrowIcon']")
	public WebElement rightArrow;
	
	@FindBy(xpath="//div[@title='Last Activity']")
	public WebElement lastActivity;
	
	public boolean selectTab(WebDriver driver,String option) {
		boolean optionSelected=false;
		logger.debug("Selecting an option Tab in HomePAge: "+option);
		WebElement OptionTab = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (WaitUtils.waitForElement(driver, OptionTab)) {
			logger.debug(option+" was visible");
			OptionTab.click();
			logger.debug(option+" was clicked");
			optionSelected = true;
		} else {
			System.out.println(option + " Option is not visible");
			logger.debug(option+" Could not be selected");
		}
		return optionSelected;
	}
	public boolean verifyAccountPage(WebDriver driver,String expectedTitle, String username) {
		boolean verifiedAccountPage=false;
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Account"));
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.contains(expectedTitle)) {
			if(userLabel.getText().equals(username))
				verifiedAccountPage=true;
			logger.debug("Account Page was verified");
		}
		return verifiedAccountPage;
	}
	
	public boolean verifynewAccount(WebDriver driver,String dataAccountname) throws InterruptedException {
		boolean verifiedNewAccount=false;

		//click New button
		if(newButton.isDisplayed()) {
			newButton.click();
		}
		
		//Thread.sleep(2000);
		//enter New account name
		newAccountNameElement.sendKeys(dataAccountname);
		//Thread.sleep(1000);

		//select dropdown for Type Technology Partner
		Select typeDropdown=new Select(typeElement);
		typeDropdown.selectByVisibleText("Technology Partner");

		//Choose high Customer priority dropdown
		Select priority=new Select(customerPriority);
		priority.selectByValue("High");

		//save button on bottom
		saveButton.click();

		//verify if account name is added

		String newAccountName=topAccountname.getText();
		if(newAccountName.equals(dataAccountname)) {
			verifiedNewAccount=true;
			logger.debug("Account name added is verified successfully");
		}
		else {
			logger.debug("Account name added is not verified succesfully");
		}
		return verifiedNewAccount;
	}
	
	public boolean verifyCreateNewView(WebDriver driver, String dataViewName,String dataUniqueViewName) {
		boolean verifiedCreateView=false;
		
		if(createNewViewlink.isDisplayed()) {
			createNewViewlink.click();
		}
		//Viewname
		viewName.sendKeys(dataViewName);

		//Unique view name
		viewUniqueName.click();
		viewUniqueName.clear();
		//Thread.sleep(1000);
		viewUniqueName.sendKeys(dataUniqueViewName);

		//Click Save on bottom
		if(save.isDisplayed())
		{
			save.click();
		}
		else {
			logger.debug("Issue in save button");
		}

		//verify the view created
		Select selectViewlist=new Select(viewList);

		System.out.println(selectViewlist.getAllSelectedOptions().getFirst().getText().equals(dataViewName));

		if(selectViewlist.getAllSelectedOptions().getFirst().getText().equals(dataViewName)) {
			logger.debug("Verifying new view created");
			verifiedCreateView=true;
		}
		else {
			logger.debug("Failed to Verify new view created");
		}
		
		return verifiedCreateView;
	}
	public boolean verifyEditview(WebDriver driver,String dataViewName) {
		boolean verifiedEditView=false;
		
		Select selectViewlist=new Select(viewList);
		selectViewlist.selectByVisibleText(dataViewName);
		//Thread.sleep(3000);
		//click Edit

		editLink.click();
		//Thread.sleep(3000);

		//Edit view name
		String vname="Editviewtest";
		viewName.sendKeys(vname);

		//Unique view name
		//Thread.sleep(1000);
		viewUniqueName.sendKeys("");

		//Select Account name filter
		Select selectfilter=new Select(filter);
		selectfilter.selectByVisibleText("Account Name");

		//Select operator filter
		Select selectOperator=new Select(operator);
		selectOperator.selectByVisibleText("contains");

		//Send value for Value field
		valueField.sendKeys("a");

		//Select last Activity to display
		Select selectdisplay=new Select(display);
		selectdisplay.selectByVisibleText("Last Activity");

		//click right arrow to add
		rightArrow.click();

		//Click save on bottom
		save.click();

		//verify the view is updated
		Select editviewlist=new Select(viewList);

		System.out.println(editviewlist.getAllSelectedOptions().getFirst().getText().equals(vname));
		//WebElement lastActivityElm=driver.findElement(By.xpath("//div[@title='Last Activity']"));

		if((editviewlist.getAllSelectedOptions().getFirst().getText().equals(vname)) && lastActivity.isDisplayed())
		{
			verifiedEditView=true;
		}
	
		return verifiedEditView;

	}
	

}
