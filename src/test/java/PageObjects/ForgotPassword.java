package PageObjects;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage {

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a[href='/user/reset-password']")
	WebElement buttonForgotPasword;
	
	@FindBy(css = "input[name='email']")
	WebElement email;
	
	@FindBy(xpath="//button[normalize-space()='SUBMIT']")
	WebElement buttonSubmit;
	
	@FindBy(xpath = "//input[@type='number'][1]")
	WebElement otpInput;
	By otp = By.xpath("//input[@type='number'][1]");
	
	@FindBy(xpath = "//button[normalize-space()='RESET PASSWORD']")
	WebElement buttonResetPassword;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='re-password']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[normalize-space()='SIGN IN']")
	WebElement signIn;
	
	public void click_ForgotPassword() {
		buttonForgotPasword.click();
	}
	
	public void inputEmail(String userEmail) {
			email.sendKeys(userEmail);
	}
	
	public void click_Submit() {
		buttonSubmit.click();
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
	
	public void click_ResetPassword() throws InterruptedException {
		buttonResetPassword.click();
		//Thread.sleep(2000);
	}
	
	public void input_NewPassword(String userNewPassword) {
		password.sendKeys(userNewPassword);
	}
	
	public void confirm_NewPassword(String confirmNewPass) {
		confirmPassword.sendKeys(confirmNewPass);
	}
	public void signIn() {
		signIn.click();
	}

}
