package Avigma.IPL.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="emailaddress")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;

	@FindBy(id="client_viewdetail_1")
	WebElement SubmitButton;
	
	public void goTo() {
		driver.get("https://testui.ipreservationlive.com/admin/login");

	}
	
	public DashboardPage LoginApplication(String email, String password ) {
		Username.sendKeys(email);
		Password.sendKeys(password);
		SubmitButton.click();
		return new DashboardPage(driver);
	}
	
	
}
