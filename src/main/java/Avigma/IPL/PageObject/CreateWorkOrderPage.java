package Avigma.IPL.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class CreateWorkOrderPage extends AbstractComponent {
	WebDriver driver;

	public CreateWorkOrderPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Enter Order Number...\"]")
	WebElement WorkOrder;
	
	@FindBy(xpath = "//input[@id='jgffhgfhfg']")
	WebElement IPLNumber;
	
	@FindBy(id = "inputEmail42")
	WebElement WorkOrderNumber;

	@FindBy(xpath = "//label[.='Client *']/following::span[contains(text(),'Select')]")
	WebElement Client;

	@FindBy(xpath = "//li[@role=\"option\"][5]")
	WebElement ClientOption;

	
	@FindBy(xpath = "//label[.='Work Type *']/following::span[contains(text(),'Select')]")
	WebElement WorkType;

	@FindBy(xpath = "//li[@index=\"4\"]")
	WebElement WorkTypeOption;

	@FindBy(xpath = "//textarea[@placeholder=\"Enter Address\"]")
	WebElement Address;

	@FindBy(xpath = "//label[contains(.,'State')]/following::span[contains(text(),'Select')]")
	WebElement State;

	@FindBy(xpath = "//span[contains(text(),'Select')]/following::input[@tabindex=\"-1\"]")
	WebElement StateSearch;

	@FindBy(xpath = "//li[@index=\"0\"]")
	WebElement StateResult;

	@FindBy(xpath = "//label[.='Contractor ']/following::span[contains(text(),'Select')]")
	WebElement Contractor;

	@FindBy(xpath = "//li[@index=\"4\"]")
	WebElement ContractorOption;

	@FindBy(xpath = "//label[contains(.,'Zip')]/following::input[@placeholder=\"Enter zip...\"]")
	WebElement Zip;

	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//div[1]//button[1]//i[1]")
	WebElement DueDate;
	
	@FindBy(xpath = "//select[@title='Select month']")
	WebElement SelectMonth;

	@FindBy(xpath = "//div[@aria-label='Tuesday, July 16, 2024']")
	WebElement DueDateSelect;

	@FindBy(xpath = "//input[@placeholder='Enter Na..']")
	WebElement Name;

	@FindBy(xpath = "//label[contains(.,'City')]/following::input[@placeholder=\"Enter city...\"]")
	WebElement City;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement SaveButton;

	@FindBy(xpath = "//button[.='Close..']")
	WebElement CloseButton;

	public void CreateWorkOrder(String workordernumber) {
		WorkOrderNumber.sendKeys(workordernumber);
		Client.click();
	}

	public void AddWorkOrderDetails1() {

		ClientOption.click();
		WorkType.click();
	}

	public void AddWorkOrderDetails2() {

		WorkTypeOption.click();

	}
	

	public void AddWorkOrderDetails3(String address, String state) {
		String IPLNum= IPLNumber.getText();
        System.out.println(IPLNum);
		Address.sendKeys(address);
		State.click();
		StateSearch.sendKeys(state);

	}

	public void AddWorkOrderDetails4() {

		StateResult.click();
		Actions action = new Actions(driver);
		action.moveToElement(Contractor).perform();
		Contractor.click();
	}

	public void AddWorkOrderDetails5() {

		ContractorOption.click();

	}

	public void AddWorkOrderDetails6(String zip, String name, String city) {
		Zip.sendKeys(zip);
		Name.sendKeys(name);
		City.sendKeys(city);
		DueDate.click();
		Select select = new Select(SelectMonth);
		select.selectByVisibleText("Jul");

	}

	public void AddWorkOrderDetails7() {
		DueDateSelect.click();
		Actions action = new Actions(driver);
		action.moveToElement(SaveButton).perform();
		SaveButton.click();
	}

	public void SaveWorkOrder() {
		CloseButton.click();

	}
}