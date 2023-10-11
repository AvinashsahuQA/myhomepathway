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

public class Onboarding_BankAccount extends BasePage {

	public Onboarding_BankAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//p[contains(text(),'Get Started')])[3]")
	WebElement getStarted_linkAccount;
	
	@FindBy(xpath = "//button[text()='Add Account']")
	WebElement addAccount;
	//put wait
	@FindBy(css="button[role='button']")
	WebElement agreeButton;
	By selectAgree=By.cssSelector("button[role='button']");
	
	@FindBy(id="aut-ins_127989")
	WebElement selectInstitution;
	
	@FindBy(css="button[role='button']")
	WebElement continueToLogin;
	
	@FindBy(id="username")
	WebElement userName_plaid;
	
	@FindBy(id="password")
	WebElement password_plaid;
	
	@FindBy(id="submit-credentials")
	WebElement signIn_plaid;
	
	@FindBy(id="submit-device")
	WebElement getCodeButton_plaid;
	
	@FindBy(id="code")
	WebElement enterCode;

	@FindBy(id="submit-code")
	WebElement submitButton;
	
	@FindBy(xpath="//label[@for='account_0']//input[@type='checkbox']")
	WebElement plaidChecking_Checkbox;
	
	@FindBy(id="name")
	WebElement additionalInfo;
	
	@FindBy(id="account-number")
	WebElement additionalInfo1;
	
	@FindBy(id="submit-accounts")
	WebElement continueButton;
	
	@FindBy(id="terms")
	WebElement terms_and_Conditions;
	
	@FindBy(id="submit-confirmation")//
	WebElement connectAccountInfo;
	
	@FindBy(css="button[id='aut-button']")//submit-confirmation
	WebElement continueAgain;
	By selectContinueAgain=By.cssSelector("button[id='aut-button']");
	
	@FindBy(css="button[id='aut-button']")
	WebElement contAccount;
	
	@FindBy(id="click-to-continue-wrapper")
	WebElement completeAccountButton;
	
	
	@FindBy(css="iframe[id*='plaid-link-iframe']")
	WebElement iFrameElement;
	
	public void click_getStarted() throws InterruptedException {
		Thread.sleep(3000);
		getStarted_linkAccount.click();
	}
	public void click_AddAccount() {
		addAccount.click();
	}
	
	public void clickAgree() throws InterruptedException {
		
		//agreeButton.click();
		driver.switchTo().frame(iFrameElement);
		waitElementsClickable(selectAgree);
		//fluentWait(selectAgree);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agreeButton);
	}
	
	public void click_selectInstitution() throws InterruptedException {
		Thread.sleep(3000);
		selectInstitution.click();
	}
	public void click_continueToLogin() throws InterruptedException {
		Thread.sleep(3000);
		continueToLogin.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next()) {
			continue;
			}
			driver = driver.switchTo().window(it.next());// switch to new window
		/*String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);*/
		//
		userName_plaid.sendKeys("user_good");
		Thread.sleep(3000);
		password_plaid.sendKeys("pass_good");
		Thread.sleep(3000);
		signIn_plaid.click();
		Thread.sleep(3000);
		getCodeButton_plaid.click();
		Thread.sleep(3000);
		enterCode.sendKeys("1111111");
		Thread.sleep(3000);
		submitButton.click();
		Thread.sleep(3000);
		plaidChecking_Checkbox.click();
		Thread.sleep(3000);
		additionalInfo.click();
		Thread.sleep(3000);
		additionalInfo1.click();
		Thread.sleep(3000);
		continueButton.click();
		Thread.sleep(3000);
		terms_and_Conditions.click();
		Thread.sleep(4000);
		connectAccountInfo.click();
		Thread.sleep(4000);
		
		}
		
		driver.switchTo().window(currentWindow);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
//		waitElementsPresence(By.id("a11y-title"));
		String text=driver.findElement(By.cssSelector("h1[id='a11y-title']")).getText();
		System.out.println(text);
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", continueAgain);
	}
	
	
	/*public void inputUsernamePlaid() {
		userName_plaid.sendKeys("user_good");
	}
	public void inputPasswordPlaid() {
		password_plaid.sendKeys("pass_good");
	}
	public void click_SigninPlaid(){
		signIn_plaid.click();
	}
	public void click_getCode(){
		getCodeButton_plaid.click();
	}
	public void enterCode(){
		enterCode.sendKeys("1111111");
	}
	public void click_submitCode(){
		submitButton.click();
	}
	public void click_plaidChecking_Checkbox(){
		plaidChecking_Checkbox.click();
	}
	public void click_additionalInfo_Checkbox(){
		additionalInfo.click();
	}
	public void click_additionalInfo1_Checkbox(){
		additionalInfo1.click();
	}
	public void clickContinue(){
		continueButton.click();
	}
	public void termsConditions_Checkbox(){
		terms_and_Conditions.click();
	}
	public void click_connectAccount() throws InterruptedException {	
		connectAccountInfo.click();
		Thread.sleep(3000);
		continueAgain.click();
	}*/
	
	public void click_finishAccount() {
		contAccount.click();
	}
	
	public void complete_Account() {
		completeAccountButton.click();
	}

	
	
	

}