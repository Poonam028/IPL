package Avigma.IPL.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;

	}

	public void Wait(By findby) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	
	public void InvisibilityOfSpinner(By findby) {
		WebDriverWait SpinnerWait = new WebDriverWait(driver, Duration.ofSeconds(80));
		SpinnerWait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	
	public void OfficeBtnClickableWait(By locator, int maxRetries ) {
		int retries = 0;
		while (retries<maxRetries) {
			try {
				
				WebDriverWait OfficeBtnWait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement element = OfficeBtnWait.until(ExpectedConditions.elementToBeClickable(locator));
	            element.click();
	            break;

		    }  catch (WebDriverException e) {
	            // Handle interception or other issues
	            System.out.println("Element click intercepted. Retrying...");
	            retries++;
		    }
	}
	}
	
	public void SpinnerInvisibility(By findby) {
		WebDriverWait BidTaskEle = new WebDriverWait(driver, Duration.ofSeconds(30));
		BidTaskEle.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		
	}
	public void SpinnerInvisibility1(By findby) {
		WebDriverWait BidTaskEle = new WebDriverWait(driver, Duration.ofSeconds(50));
		BidTaskEle.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	public void VisibilityOfCloseBtnAfterAddBidTask(By findby) {
		WebDriverWait BidTaskEle = new WebDriverWait(driver, Duration.ofSeconds(30));
		BidTaskEle.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	
	public void VisibilityOfBidTaskDetails(By findby) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Wait.until(ExpectedConditions.presenceOfElementLocated(findby));
		
	}
	public void VisibilityOfElement(By findby) {
		WebDriverWait BidTaskEle = new WebDriverWait(driver, Duration.ofSeconds(90));
		BidTaskEle.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));
	}
	
	public void ElementToBeClickable(By findby) {
		WebDriverWait ElementToBeClickable = new WebDriverWait(driver, Duration.ofSeconds(80));
		ElementToBeClickable.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby));

}
	
	public void AddTaskWait(By locator, int maxRetries) {
		int retries = 0;
		while (retries < maxRetries){
		try	{
		WebDriverWait TaskTabWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = TaskTabWait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        break;
		} catch (WebDriverException e) {
            // Handle interception or other issues
            retries++;
		}
	}
}
}