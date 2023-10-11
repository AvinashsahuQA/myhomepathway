package PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;

public class Onboarding_AddIncome extends BasePage {

	public Onboarding_AddIncome(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//p[contains(text(),'Get Started')])[4]")
	WebElement getStarted_addIncome;
	
	@FindBy(xpath = "//button[normalize-space()='Add Provider']")
	WebElement addProvider;
	//put wait
	@FindBy(css="button[role='button']")
	WebElement agreeButton;
	By selectAgree=By.cssSelector("button[role='button']");
	
	@FindBy(css="button[role='button']")
	WebElement verifyInstantlyButton;
	
	@FindBy(css="div[class*='horizontalInstitution'] button[type='button']")
	WebElement payrollProvider;
	
	@FindBy(id="aut-input-0")
	WebElement userName_plaid;
	
	@FindBy(id="aut-input-1")
	WebElement password_plaid;
	
	@FindBy(id="aut-button")
	WebElement submitButton;
	
	@FindBy(css="li[id='aut-selection-0'] input[type='radio']")
	WebElement plaidEmployeeRadio;
	
	@FindBy(css="button[role='button']")
	WebElement continueButton;

	@FindBy(id="aut-button")
	WebElement allowButton;
	
	@FindBy(css="button[role='button']")
	WebElement continueAgainButton;//
	
	@FindBy(xpath="//button[normalize-space()='Complete']")
	WebElement completeButton;
	
	@FindBy(css="iframe[id*='plaid-link-iframe']")
	WebElement iFrameElement;
	
	public void click_getStarted() throws InterruptedException {
		Thread.sleep(3000);
		getStarted_addIncome.click();
	}
	public void click_addProvider() {
		addProvider.click();
	}
	
	public void clickAgree() throws InterruptedException {
		
		//agreeButton.click();
		driver.switchTo().frame(iFrameElement);
		waitElementsClickable(selectAgree);
		//fluentWait(selectAgree);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agreeButton);
	}
	
	public void click_verifyInstantlyButton() throws InterruptedException {
		Thread.sleep(3000);
		verifyInstantlyButton.click();
	}
	
	
	public void add_payrollProvider() throws InterruptedException {
		Thread.sleep(3000);
		payrollProvider.click();
	}
	public void plaidLogin() {
		userName_plaid.sendKeys("user_good");
		password_plaid.sendKeys("pass_good");
	}
	public void click_submitButton(){
		submitButton.click();
	}
	public void click_plaidEmployee_Radio() throws InterruptedException{
		Thread.sleep(3000);
		//plaidEmployeeRadio.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", plaidEmployeeRadio);
	}
	public void click_continueButton(){
		continueButton.click();
	}
	public void click_allowButton() throws InterruptedException{
		Thread.sleep(3000);
		allowButton.click();
	}
	
	public void click_ContinueAgain() throws InterruptedException {
		Thread.sleep(3000);
		continueAgainButton.click();
		
	}
	public void switchfromIframe() {
		driver.switchTo().defaultContent();
	}
	public void click_CompleteButton() throws InterruptedException {
		Thread.sleep(3000);
		completeButton.click();
	}

	
	
	

}