package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signin extends BasePage {

	public Signin(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[name='email']")
	WebElement email;
	
	@FindBy(css = "input[name='password']")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	WebElement buttonSignin;
	
	@FindBy(xpath="//button[text()='SIGN OUT']")
	WebElement signOutButton;
	
	public void inputEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	public void inputPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	public void clickSignin() {
		buttonSignin.click();
	}
	public void clearInput() {
		email.clear();
		password.clear();
	}
	
	public void clickSignout() {
		signOutButton.click();
	}
}