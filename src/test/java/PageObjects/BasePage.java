package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		}
	
	public void waitElements(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findBy));
	}
	
	public void waitElementsClickable(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void waitElementsClickableVisibility(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(7));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitElementsVisibility(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(9));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitElementsVisibile(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(9));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitElementsInvisibile(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(9));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitElementsPresence(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(9));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	
	public void fluentWaitt(By findBy) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));

	}

}
