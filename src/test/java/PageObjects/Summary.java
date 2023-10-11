package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class Summary extends BasePage {

	public Summary(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()='Select Journey']")
	WebElement selectJoureyButton;

	@FindBy(xpath = "//button[normalize-space()='START AS A BUILDER']")
	WebElement startAsABuilderButton;

	@FindBy(xpath = "//button[normalize-space()='START AS A DESIGNER']")
	WebElement startAsADesignerButton;

	@FindBy(xpath = "//button[normalize-space()='ADD SAVINGS']")
	WebElement addSavingsButton;

	//@FindBy(xpath = "//span[text()='Add savings']") //
	@FindBy(xpath = "//span[@class='ml-2 tracking-wide']")
	WebElement addSavingsInner;

	@FindBy(xpath = "//button[@id='headlessui-listbox-button-:r6:']")
	WebElement selectCategoryButton;

	@FindBy(xpath = "//ul[@id='headlessui-listbox-options-:rv:']/li[2]")
	WebElement selectCategoryOptions;

	@FindBy(xpath = "input[name='amount']")
	WebElement inputAmount;

	@FindBy(xpath = "//button[normalize-space()='Add downpayment']")
	WebElement addDownPaymentButton;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/span[2]/div/button")
	WebElement crossButton;

	public void clickSelectJourney() {
		selectJoureyButton.click();
	}

	public void clickBuilder() {
		startAsABuilderButton.click();
	}

	public void clickDesigner() {
		startAsADesignerButton.click();
	}

	public void clickAddSavings() throws InterruptedException {
			
		Thread.sleep(2000);
		addSavingsButton.click();
		Thread.sleep(2000);
		//crossButton.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", crossButton);
		addSavingsInner.click();
	}

	public void chooseCategory() {
		selectCategoryButton.click();
		selectCategoryOptions.click();

	}

	public void addAmount() {
		inputAmount.sendKeys("12345677");
	}

	public void addDownpayment() {
		addDownPaymentButton.click();

	}
}
 
