package Avigma.IPL.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class DashboardPage extends AbstractComponent{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) 
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//button[.='Close']")
	WebElement CloseBTN;
	
	@FindBy(xpath = "//a[.=' Work Orders ']")
	WebElement workorder;
	
	@FindBy(xpath = "//span[.='Create Work Order']")
	WebElement createworkorder;
	
	public CreateWorkOrderPage DashboardPopUp() {
	    // Check if the pop-up is displayed
		CloseBTN.click();
		return new CreateWorkOrderPage(driver);

		
	}
	 public void hoverOverWorkOrdersLink() {
		     Actions action = new Actions(driver);
		     action.moveToElement(workorder).perform();
		     
	}
	 public void createWorkOrder() {
		 createworkorder.click();
	 }
	 
	 public void WorkOrderBtn() {
		 workorder.click();
	 }

}