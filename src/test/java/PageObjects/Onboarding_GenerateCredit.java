package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;


public class Onboarding_GenerateCredit extends BasePage {

	public Onboarding_GenerateCredit(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//p[contains(text(),'Get Started')])[2]")
	WebElement getStarted_generateCredit;
	
	@FindBy(xpath="//button[normalize-space()='SAVE & GO BACK']")
	WebElement saveAndGoBackButton;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement continueButton;
	By contButton=By.xpath("//button[normalize-space()='Continue']");
	
	@FindBy(css="input[name='ssn']") 
	WebElement socialSecurityNumber;

	@FindBy(xpath="//button[normalize-space()='NEXT']")
	WebElement nextButton;
	
	@FindBy(css="div[id*='arr-id-0']")
	List<WebElement> radioButtons;
	
//	@FindBy(css="label[class*=arr-radio-label]")
//	List<WebElement> answers;
//	By ans=By.cssSelector("label[class*=arr-radio-label]"); //
	
	@FindBy(css="array-authentication-kba[appkey='0DDE0E09-E247-424B-9D6D-D374202183D9']")
	WebElement shadowHost;
	
//	@FindBy(css="label[class*=arr-radio-label]")
//	List<WebElement> shadowElements_Answers;
//	By ans=By.cssSelector("label[class*=arr-radio-label]");
	
	
	@FindBy(tagName="iframe")
	WebElement iFrame;
	
	public void click_getStarted() {
		getStarted_generateCredit.click();
	}

	public void clickContinue() {

		waitElementsClickable(contButton);
		//continueButton.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", continueButton);
		
	}
	
	public void input_SocialSecurityNumber() {
		socialSecurityNumber.sendKeys(Keys.ARROW_UP);
		socialSecurityNumber.sendKeys("123456789");

	}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public void printAnswers() throws InterruptedException {
		//waitElementsVisibile(ans);
		Thread.sleep(4000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		SearchContext shadowRoot = (SearchContext) jsExecutor.executeScript("return arguments[0].shadowRoot;", shadowHost);
		List<WebElement> shadowElements_Answers = shadowRoot.findElements(By.cssSelector("label[class*=arr-radio-label]"));
		List<WebElement> shadowElements_Radio = shadowRoot.findElements(By.cssSelector("div[data-test-id='radio-button-container'] div[id*='arr-id-0']"));

		
		List<String> textList = new ArrayList<String>();
		
        //List<WebElement> GroupList = driver.findElements(By.xpath("(//ABC)"));

        for ( WebElement element: shadowElements_Answers) {
            	textList.add(element.getText());
            	
        
        for (String text : textList) {
        	{
        		if(text.equals("5518")||text.equals("MORRISON MAHONEY MILLER")||text.equals("Ford F100 Pickup")||text.equals("Maggies Flowers & Gift")) {
        			for( WebElement ele : shadowElements_Radio) {
                    	ele.click();
                    	
        	        }
        		}
        		if(text.equals("NONE OF THE ABOVE/DOES NOT APPLY")) {
        			for( WebElement ele : shadowElements_Radio) {
                    	ele.click();
                    	
        	        }
        		}
        	}
        }
        }
       System.out.println(textList);
		
	}

}