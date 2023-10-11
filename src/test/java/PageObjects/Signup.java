package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Signup extends BasePage {

	public Signup(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Create an account']")
	WebElement createAnAccount;
	
	@FindBy(css = "input[name='email']")
	WebElement email;	

	@FindBy(css = "button[type='submit']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@type='number'][1]")
	WebElement otpInput;
	By otp = By.xpath("//input[@type='number'][1]");
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[normalize-space()='CREATE YOUR ACCOUNT']")
	WebElement createAccount;
	
	@FindBy(xpath="//button[text()='Agree to terms']")
	WebElement agreeAndTerms;
	
	@FindBy(xpath="//h1[normalize-space()='Congratulations!']")
	WebElement signupCompleteMessage;
	
	
	
	
	public void clickCreateAccount() {
		//createAnAccount.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", createAnAccount);
	}
	
	public void inputEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void inputOtp(String otpValues) throws AWTException {
		waitElements(otp);
		
		Actions actions = new Actions(driver);
		otpInput.sendKeys("12345");
		actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("v");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
		
	}
	
	public void inputFirstName(String userfirstName) {
		firstName.sendKeys(userfirstName);
	}
	
	public void inputLastName(String userlastName) {
		lastName.sendKeys(userlastName);
	}
	
	public void inputPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void confirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}
	
	public void accountCreate() {
		createAccount.click();
	}
	
	public void clickAgreeandTerms() {
		agreeAndTerms.click();
	}
	
	public void verifyCompleteSignup() {
		String actualTitle=signupCompleteMessage.getText();
		System.out.println(actualTitle);
		String expectedTitle="Congratulations!";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	public void clearInput() {
		firstName.clear();
		lastName.clear();
		password.clear();
		confirmPassword.clear();
	}
}
