package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;

public class Onboarding_PersonalInfo extends BasePage {

	public Onboarding_PersonalInfo(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//p[contains(text(),'Get Started')])[1]")
	WebElement getStarted_personalInfo;
	
	@FindBy(css = "input[class='filepond--browser']")
	WebElement uploadImage;
	
	//@FindBy(css="input[class*=MuiInput]")
	@FindBy(xpath="//button[@aria-label='Choose date']")
	WebElement dob;
	
	@FindBy(xpath="//button[normalize-space()='1']")
	WebElement selectDate;
	
	@FindBy(css="input[name='street']")
	WebElement enterAddress;
	
	@FindBy(xpath="//div[normalize-space()='Anapuni Loop, Lahaina, HI, USA']")
	WebElement selectAddress;
	By selectAdd=By.xpath("//div[normalize-space()='Anapuni Loop, Lahaina, HI, USA']");
	
	@FindBy(css="input[name='apartment']") 
	WebElement enterApartment;
	
	@FindBy(xpath="//button[normalize-space()='Save & Go Back']")
	WebElement saveAndGoBackButton;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continueButton;
	By contButton=By.xpath("//button[normalize-space()='Continue']");
	
	@FindBy(xpath="//span[normalize-space()='Veteran']") 
	WebElement militaryService_Option;

	@FindBy(xpath="//span[normalize-space()='$1,001 - $2,000']")
	WebElement rentOption;
	
	@FindBy(xpath="//span[normalize-space()='Better Schools']")
	WebElement buyHomeOption;
	
	@FindBy(name="housePriceGoal")
	WebElement homeGoalAmount;//input amount
	
	@FindBy(css="button[aria-haspopup='listbox']")
	WebElement purchaseHomeDropdown;
	
	@FindBy(css="li[role='option']:nth-child(2)")
	WebElement selectHomeOption;
	
	@FindBy(xpath="//input[@name='locationSearch']")
	WebElement searchLocation;
	
	@FindBy(xpath="//div[normalize-space()='New York Mills, NY, USA']")
	WebElement selectLocation;
	
	@FindBy(name="phone")
	WebElement inputPhone;
	
	@FindBy(xpath="//button[normalize-space()='Complete']")
	WebElement complete;
	
	
	@FindBy(tagName="iframe")
	WebElement iFrame;
	
	public void click_getStarted() throws InterruptedException {
		Thread.sleep(3000);
		getStarted_personalInfo.click();
	}
	public void uploadProfileIcon() {
		uploadImage.sendKeys(System.getProperty("user.dir")+ "//Files//download.jpeg");
	}
	
	public void inputDOB() {
		//dob.clear();
		dob.click();
		selectDate.click();
	}
	
	public void inputAddress() throws InterruptedException {
		enterAddress.clear();
		enterAddress.sendKeys("ana");
		waitElements(selectAdd);
		selectAddress.click();
		enterApartment.sendKeys("k16");
		
	}
	public void clickContinue() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//js.executeScript("scrollBy(0, 4500)"); 
		waitElementsClickable(contButton);
		//continueButton.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", continueButton);
	}
	
	public void select_MilitaryServiceOption() {
		militaryService_Option.click();
		continueButton.click();
	}
	
	public void select_RentOption() {
		rentOption.click();
		continueButton.click();
	}
	
	public void select_buyHomeOption() {
		buyHomeOption.click();
		continueButton.click();
	}
	
	public void select_HomeGoal() {
		homeGoalAmount.clear();
		homeGoalAmount.sendKeys("123456");
		continueButton.click();
	}
	
	public void select_TimelineForHome() throws InterruptedException {
		purchaseHomeDropdown.click();
		Thread.sleep(3000);
		selectHomeOption.click();
		continueButton.click();	
	}
	
	public void select_homeAddressToBuy() throws InterruptedException {
		searchLocation.sendKeys("NewYork");
		Thread.sleep(3000);
		selectLocation.click();
		Thread.sleep(3000);
		continueButton.click();	
		
	}
	
	public void add_Contact() {
		inputPhone.sendKeys("9875678903");
		complete.click();
	}

}