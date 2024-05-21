package Avigma.IPL.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class WorkOrderList extends AbstractComponent {
	WebDriver driver;

	public WorkOrderList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[.=' No records available. ']")
	WebElement Norecords;

	@FindBy(xpath = "//div[@class='k-grid-aria-root']")
	WebElement WorkOrderList;
	
	@FindBy(xpath = "/html/body/app-root/div/ng-component/app-header-client-result/div/div[2]/div[1]/ul/li[1]/b")
	WebElement IPLNumber;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/kendo-grid[1]/div[1]/div[1]/div[2]/table[1]/thead[1]/tr[2]/td[8]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]")
	WebElement IPL;

	@FindBy(xpath = "/html/body/app-root/div/ng-component/div/div/div[2]/div/div/div/div[2]/div/kendo-grid/div/div/div[2]/table/thead/tr[2]/td[2]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")
	WebElement Address;

	@FindBy(xpath = "//button[starts-with(text(),'Run Filter')]")
	WebElement RunFilter;

	@FindBy(xpath = "//div[@class=\"overlay ng-tns-c164-0 ng-trigger ng-trigger-fadeIn ng-star-inserted\"]")
	WebElement SpinnerOfFilter;

	@FindBy(xpath = "//div/a[.='     View ']")
	WebElement ViewWorkOrder;
	
	
	public void IPLActualFromWorkOrderPage(String IPLActual) {
		IPL.sendKeys(IPLActual);
	}
	
	public void FilterWorkOrder(String address) {
		Address.sendKeys(address);
		//IPL.sendKeys(IPLnumber);
		RunFilter.click();

	}

	public void ViewWorkOrder() {
		ViewWorkOrder.click();
	}

	
	}
