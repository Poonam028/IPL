package Avigma.IPL.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Avigma.IPL.AbstractComponents.AbstractComponent;

import Avigma.IPL.PageObject.CreateWorkOrderPage;
import Avigma.IPL.PageObject.DashboardPage;
import Avigma.IPL.PageObject.LoginPage;
import Avigma.IPL.PageObject.WorkOrderList;
import Avigma.IPL.PageObject.WorkOrderPage;
import Avigma.IPL.TestComponents.BaseTest;

public class WorkOrderCreate extends BaseTest {

	@Test
	public void CreateWorkOrder() throws IOException {
		LoginPage loginPage = launchApplication();
		DashboardPage dashboardPage = loginPage.LoginApplication("mike123", "Work2021!");
		dashboardPage.Wait(By.xpath("//button[.='Close']"));
		dashboardPage.DashboardPopUp();
		dashboardPage.Wait(By.xpath("//a[.=' Work Orders ']"));
		dashboardPage.hoverOverWorkOrdersLink();
		dashboardPage.createWorkOrder();
		CreateWorkOrderPage createWorkOrderPage = new CreateWorkOrderPage(driver);
		createWorkOrderPage.VisibilityOfElement(By.xpath("//input[@id='jgffhgfhfg']"));
		createWorkOrderPage.Wait(By.xpath("//input[@placeholder=\"Enter Order Number...\"]"));
		createWorkOrderPage.CreateWorkOrder("12121212");
		createWorkOrderPage.Wait(By.xpath("//li[@role=\"option\"][5]"));
		createWorkOrderPage.AddWorkOrderDetails1();
		createWorkOrderPage.Wait(By.xpath("//li[@index=\"3\"]"));
		createWorkOrderPage.AddWorkOrderDetails2();
		// createWorkOrderPage.WaitAddress(By.cssSelector("//textarea[@placeholder=\"Enter
		// Address\"]"));
		createWorkOrderPage.AddWorkOrderDetails3("123 Main Street, Anytown, USA 12345", "NV");
		createWorkOrderPage.Wait(By.xpath("//li[@index=\"0\"]"));
		createWorkOrderPage.AddWorkOrderDetails4();
		createWorkOrderPage.Wait(By.xpath("//li[@index=\"4\"]"));
		createWorkOrderPage.AddWorkOrderDetails5();
		createWorkOrderPage
				.Wait(By.xpath("//label[contains(.,'Zip')]/following::input[@placeholder=\"Enter zip...\"]"));
		createWorkOrderPage.AddWorkOrderDetails6("555555", "Poonam sawant", "Mumbai");
		createWorkOrderPage.Wait(By.xpath("//div[@aria-label='Tuesday, July 16, 2024']"));
		createWorkOrderPage.AddWorkOrderDetails7();
		createWorkOrderPage.Wait(By.xpath("//button[.='Close..']"));
		createWorkOrderPage.SaveWorkOrder();

	}

	@Test
	public void OfficeResultBidAddTasks() throws InterruptedException {
		WorkOrderPage workOrderPage = new WorkOrderPage(driver);
		WorkOrderList workOrderList = new WorkOrderList(driver);

		workOrderPage.InvisibilityOfSpinner(By.className("overlay"));
		workOrderPage.OfficeBtnClickableWait(By.xpath("//a[.='Office Results ']"), 2);
		workOrderPage.SpinnerInvisibility(By.xpath("//div[@class=\"ng-tns-c164-3 ng-star-inserted\"]"));
		
		workOrderPage.CreateBidTask1();
		workOrderPage.CreateBidTask2("10");
		workOrderPage.CreateBidTask3("Learning Automation TESTING");
		workOrderPage.AddNewTask("12", "Added two tasks");
		workOrderPage.VisibilityOfCloseBtnAfterAddBidTask(By.xpath("//button[.='Close..']"));
		workOrderPage.OfficeResultTaskDetails();
		workOrderPage.VisibilityOfBidTaskDetails(By.xpath("//table[@class=\"result-table table col-11.5 mt-1 mb-1\"]"));
		workOrderPage.GrabTaskDetails();
		String TaskDetails = workOrderPage.GrabTaskDetails();

		workOrderPage.FieldResultTab();

		workOrderPage.SpinnerInvisibility1(By.xpath("//div[@class='ng-tns-c164-9 ng-star-inserted']"));
		workOrderPage.FieldResultBidTask1(TaskDetails);
		workOrderPage.VisibilityOfElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/app-header-client-result[1]/div[1]/div[2]/div[1]/ul[1]/li[1]"));
		workOrderPage.VisibilityOfElement(By.xpath("/html/body/app-root/div/ng-component/app-header-client-result/div/div[2]/div[1]/ul/li[1]/b"));
		
        String iplValue = workOrderPage.GrabIPL();

		workOrderPage.InvisibilityOfSpinner(By.cssSelector("body > app-root > div > ng-component > div > ng-component > app-property-history > div > ngx-spinner > div"));
		workOrderPage.Wait(By.xpath("//a[.=' Work Orders ']"));
		workOrderPage.WorkOrderBtn();
		
		workOrderList.VisibilityOfElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/kendo-grid[1]/div[1]/div[1]/div[2]/table[1]/thead[1]/tr[2]/td[8]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]"));
        workOrderList.IPLActualFromWorkOrderPage(iplValue);
		workOrderList.FilterWorkOrder("123 Main Street, Anytown, USA 12345");
		workOrderList.SpinnerInvisibility1(By.cssSelector("body > app-root > div > ng-component > div > div > ngx-spinner > div"));
		workOrderList.VisibilityOfElement(By.xpath("//div/a[.='     View ']"));
		workOrderList.ViewWorkOrder();

		workOrderPage.AddInstructionComment("Test comment");
		workOrderPage.Wait(By.xpath("//*[@id='myFrame']/div/iframe"));
		workOrderPage.AddInstruComment("Test comment");
		workOrderPage.VisibilityOfElement(By.xpath("//button[text()='Continue']"));
		workOrderPage.CloseBtn();
		workOrderPage.TaskTabClick();
		workOrderPage.AddTaskWait(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]"), 2);
		workOrderPage.Wait(By.xpath("//select[@id=\"TaskType\"]"));
		workOrderPage.CheckTaskTypeEmptyBid(); 
		workOrderPage.Wait(By.xpath("//span[contains(text(),'Select')]"));
		workOrderPage.CheckTaskNameEmptyBid();
		workOrderPage.Wait(By.xpath("//input[@type='number' and @placeholder='Enter Qty']"));
		workOrderPage.BidQnt();
		workOrderPage.Wait(By.xpath("//textarea[contains(@style,'width: 100%;')]"));
		workOrderPage.InsTabTaskComment();
		workOrderPage.ElementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]"));
		workOrderPage.AddTaskWait(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]"), 2);
		workOrderPage.Wait(By.xpath("//select[@id=\"TaskType\"]"));
		workOrderPage.CheckTaskTypeEmptyCompletion();
		workOrderPage.Wait(By.xpath("//span[contains(text(),'Select')]"));
		workOrderPage.CheckTaskNameEmptyCompletion();
		workOrderPage.Wait(By.xpath("//input[@type='number' and @placeholder='Enter Qty']"));
		workOrderPage.BidQnt();
		workOrderPage.Wait(By.xpath("//textarea[contains(@style,'width: 100%;')]"));
		workOrderPage.InsTabTaskComment();
		workOrderPage.ElementToBeClickable(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]"));
		workOrderPage.AddTaskWait(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]"), 2);
		workOrderPage.Wait(By.xpath("//select[@id=\"TaskType\"]"));
		workOrderPage.CheckTaskTypeEmptyInspection();
		workOrderPage.Wait(By.xpath("//span[contains(text(),'Select')]"));
		workOrderPage.CheckTaskNameEmptyInspection();
		workOrderPage.Wait(By.xpath("//input[@type='number' and @placeholder='Enter Qty']"));
		workOrderPage.BidQnt();
		workOrderPage.Wait(By.xpath("//textarea[contains(@style,'width: 100%;')]"));
		workOrderPage.InsTabTaskComment();
		workOrderPage.SaveInstructionTask();
		workOrderPage.Wait(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/button[1]"));
		workOrderPage.CloseInstructionTask();
		workOrderPage.CollectTasksInstruction();
		workOrderPage.SpinnerInvisibility1(By.xpath("//div[@class=\"overlay ng-tns-c164-7 ng-trigger ng-trigger-fadeIn ng-star-inserted\"]"));
		workOrderPage.Wait(By.xpath("//span[@role=\"listbox\"]"));
		workOrderPage.CollectTasksInvoice();
	}

	
}
