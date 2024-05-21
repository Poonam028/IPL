package Avigma.IPL.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testui.ipreservationlive.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//Sign in
		driver.findElement(By.id("emailaddress")).sendKeys("mike123");
		driver.findElement(By.id("password")).sendKeys("Work2021!");
		driver.findElement(By.id("client_viewdetail_1")).click();

//Dash board
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Close']")));
		driver.findElement(By.xpath("//button[.='Close']")).click();

		WebDriverWait WorkOrderWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WorkOrderWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[.=' Work Orders ']")));
		WebElement workorder = driver.findElement(By.xpath("//a[.=' Work Orders ']"));
		workorder.click();
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[.=' No records available. ']")));
		Thread.sleep(5000);
		// WebElement IPL = driver.findElement(
		// By.xpath("//td[@id='k-grid5-r1c6']//input[@class='k-textbox ng-pristine
		// ng-valid ng-touched']"));
		// WebElement Contractor = driver.findElement(By
		// .xpath("//*[@id=\"k-grid0-r1c6\"]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input"));
		Actions action = new Actions(driver);
		// action.moveToElement(IPL).clickAndHold().moveByOffset(200,
		// 0).release().perform();
		// WorkOrderWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		// "//*[@id=\"k-grid5-r1c6\"]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")));
		Thread.sleep(12000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/kendo-grid[1]/div[1]/div[1]/div[2]/table[1]/thead[1]/tr[2]/td[8]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]"))
				.sendKeys("201082");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(.,'Run Filter')]")).click();
		WebDriverWait WorkOrderWait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WorkOrderWait1.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ng-tns-c164-1 ng-star-inserted']")));
		// action.moveToElement(driver.findElement(By.xpath("//tr/td[@id='k-grid0-r2c1']/div/a")));
		Thread.sleep(12000);

		driver.findElement(By.xpath("//div[@class='row ng-star-inserted']//a[@title='view Records']")).click();
		// WorkOrderWait1.until(ExpectedConditions
		// .visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ng-tns-c164-10
		// ng-star-inserted']")));
		Thread.sleep(12000);
	//	String IP2L = driver.findElement(By.xpath("//body//app-root//app-header-client-result//li[1]")).getText();
	//	System.out.println(IP2L);

		WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"myFrame\"]"));
		action.scrollToElement(iframeElement);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"myFrame\"]/div/iframe")));
		WebElement Comment = driver.findElement(By.xpath("/html/body/div"));

		action.scrollToElement(Comment);
		Comment.sendKeys("Automation testing comment"); // Thread.sleep(9000);
		driver.switchTo().defaultContent();

		Thread.sleep(5000);
		WebElement Save = driver.findElement(By.xpath("//button[.=' Save ']"));
		action.moveToElement(Save);
		Save.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.xpath("//a[.='Task']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[.=' Add Task']")).click();
		List<WebElement> taskTypeElements = driver.findElements(By.xpath("//select[@id=\"TaskType\"]"));

		for (WebElement taskTypeElement : taskTypeElements) {
			Select dropdown = new Select(taskTypeElement);
			String SelectedOption = dropdown.getFirstSelectedOption().getText();
			if (SelectedOption.equals("Select")) {
				dropdown.selectByVisibleText("Bid");
			} else

			{
				System.out.println("Selected option: " + SelectedOption);

			}
		}
		List<WebElement> taskTypeNames = driver.findElements(By.xpath("//span[contains(text(),'Select')]"));
		for (WebElement taskTypeName : taskTypeNames) {
			String SelectedOption = taskTypeName.getText();
			if (SelectedOption.equals("Select")) {
				taskTypeName.click();
				WebElement TaskNameOpt = driver.findElement(By.xpath("//li[@index=\"20\"]"));
				TaskNameOpt.click();
			} else

			{
				System.out.println("Selected option: " + SelectedOption);

			}
		}

		List<WebElement> TaskType = driver.findElements(By.xpath("//select[contains(@id,'TaskType')]"));
		List<WebElement> TaskName = driver.findElements(By.xpath("//div/kendo-dropdownlist/span[@role=\"listbox\"]"));
		List<WebElement> Qnt = driver.findElements(By.xpath("//input[@placeholder='Enter Qty']"));
		List<WebElement> ContractorPrice = driver
				.findElements(By.xpath("//input[@placeholder=\" Enter Contractor Price\"]"));
		System.out.println(ContractorPrice);
		List<WebElement> TotalContractorPrice = driver
				.findElements(By.xpath("//input[@placeholder=\"Contractor Price\"]"));
		List<WebElement> ClientPrice = driver.findElements(By.xpath("//input[@placeholder=\"Enter Client Price\"]"));

		List<WebElement> ClientTotal = driver.findElements(By.xpath("//input[@placeholder=\"Client Price\"]"));
		List<WebElement> Comments = driver.findElements(By.xpath("//textarea[contains(@style,'width: 100%;')]"));

		List<WebElement> allElements = new ArrayList<>();

		allElements.addAll(TaskType);
		allElements.addAll(TaskName);
		allElements.addAll(Qnt);
		allElements.addAll(ContractorPrice);
		allElements.addAll(TotalContractorPrice);
		allElements.addAll(ClientPrice);
		allElements.addAll(ClientTotal);
		allElements.addAll(Comments);

		String line = "";
        List<String> instructionTabList = new ArrayList<>();

		int size = TaskType.size();
		for (int i = 0; i < size; i++) {
			// WebElement taskTypeElement = TaskType.get(i);
			// Select select = new Select(taskTypeElement);
			// WebElement selectedOption = select.getFirstSelectedOption();
			// String taskType = selectedOption.getText();
			String taskName = TaskName.get(i).getText();
			String qnt = Qnt.get(i).getAttribute("value");
			String contractorPrice = ContractorPrice.get(i).getAttribute("value");
			String totalContractorPrice = TotalContractorPrice.get(i).getAttribute("value");
			// String clientPrice = ClientPrice.get(i).getAttribute("value");
			// String clientTotal = ClientTotal.get(i).getAttribute("value");
			String comments = Comments.get(i).getAttribute("value");

			// Concatenate all values together
			String[] lineArray = { taskName, qnt, contractorPrice, totalContractorPrice, comments };
			if (!taskName.isEmpty()) {
				line = String.join(", ", lineArray).trim();
				instructionTabList.add(line);
				System.out.println(instructionTabList); // Debugging output
			}
		}
		String line1 = "";
		driver.findElement(By.xpath("//a[.='Invoice ']")).click();
		Thread.sleep(8000);
		List<WebElement> TaskName1 = driver.findElements(By.xpath("//span[@role=\"listbox\"]"));
		List<WebElement> Qnt1 = driver.findElements(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[2]/input[1]"));
		List<WebElement> ContractorPrice1 = driver.findElements(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[3]/div[1]/input[1]"));
		List<WebElement> TotalContractorPrice1 = driver.findElements(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[4]/div[1]/input[1]"));
		List<WebElement> Comments1 = driver.findElements(By.xpath("//textarea[@placeholder='Enter Comments']"));
        List<String> invoiceTabList = new ArrayList<>();

		List<WebElement> allElements1 = new ArrayList<>();
		allElements1.addAll(TaskName1);
		allElements1.addAll(Qnt1);
		allElements1.addAll(ContractorPrice1);
		allElements1.addAll(TotalContractorPrice1);
		allElements1.addAll(Comments1);


		int size1 = TaskName1.size(); // Assuming all lists have the same size
		for (int i1 = 0; i1 < size1; i1++) {
			String taskName1 = "";
			String qnt1 = "";
			String contractorPrice1 = "";
			String totalContractorPrice1 = "";
			String clientPrice1 = "";
			String clientTotal1 = "";
			String comments1 = "";

			// Handle null or empty values
			if (i1 < TaskName1.size())
				taskName1 = TaskName1.get(i1).getText();
			if (i1 < Qnt1.size())
				qnt1 = Qnt1.get(i1).getAttribute("value");
			if (i1 < ContractorPrice1.size())
				contractorPrice1 = ContractorPrice1.get(i1).getAttribute("value");
			if (i1 < TotalContractorPrice1.size())
				totalContractorPrice1 = TotalContractorPrice1.get(i1).getAttribute("value");
			if (i1 < Comments1.size())
				comments1 = Comments1.get(i1).getAttribute("value");

			String[] line1Array = { taskName1, qnt1, contractorPrice1, totalContractorPrice1, comments1 };
			if (!taskName1.isEmpty()) {
				line1 = String.join(", ", line1Array).trim();
				invoiceTabList.add(line1);

				System.out.println(invoiceTabList);

		}
	
			} 
		List<String> commonTasks = new ArrayList<>();
	        for (String task : instructionTabList) {
	            if (invoiceTabList.contains(task)) {
	                commonTasks.add(task);
	            }
	        }
	        System.out.println("Common tasks between both pages:");
	        for (String commonTask : commonTasks) {
	            System.out.println(commonTask);
	        }
	}
	
}


/*
 * 
 * List<WebElement> TaskName1 =
 * driver.findElements(By.xpath("//td/div/kendo-dropdownlist/span"));
 * List<WebElement> Qnt1 =
 * driver.findElements(By.xpath("//td[@style='width: 5%;']")); List<WebElement>
 * ContractorPrice1 = driver.findElements(By.xpath(
 * "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[4]/div[1]/input"
 * )); List<WebElement> TotalContractorPrice1 = driver.findElements(By.xpath(
 * "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[5]/div[1]/input[1]"
 * )); List<WebElement> ClientPrice1 = driver.findElements(By.xpath(
 * "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[6]/div[1]/input[1]"
 * ));
 * 
 * List<WebElement> ClientTotal1 = driver.findElements(By.xpath(
 * "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[7]/div[1]/input[1]"
 * )); List<WebElement> Comments1 =
 * driver.findElements(By.xpath("//td/div/div/textarea"));
 * 
 * List<WebElement> allElements1 = new ArrayList<>();
 * allElements1.addAll(TaskName1); allElements1.addAll(Qnt1);
 * allElements1.addAll(ContractorPrice1);
 * allElements1.addAll(TotalContractorPrice1);
 * allElements1.addAll(ClientPrice1); allElements1.addAll(ClientTotal1);
 * allElements1.addAll(Comments1);
 * 
 * int size6 = ClientPrice1.size(); System.out.println("Size of ClientPrice1: "
 * + size6);
 * 
 * int size5 = ClientTotal1.size(); System.out.println("Size of ClientTotal1: "
 * + size5);
 * 
 * int size4 = ContractorPrice1.size();
 * System.out.println("Size of ContractorPrice1: " + size4);
 * 
 * int size3 = TotalContractorPrice1.size();
 * System.out.println("Size of TotalContractorPrice1: " + size3);
 * 
 * int size2 = Qnt1.size(); System.out.println("Size of Qnt1: " + size2);
 * 
 * 
 * int commentsSize = Comments1.size(); // Get the size of the Comments1 list
 * System.out.println("Size of commentsSize: " + commentsSize); int size1 =
 * TaskName1.size(); // Assuming all lists have the same size for (int i1 = 0;
 * i1 < size1; i1++) { String taskName1 = ""; String qnt1 = ""; String
 * contractorPrice1 = ""; String totalContractorPrice1 = ""; String clientPrice1
 * = ""; String clientTotal1 = ""; String comments1 = "";
 * 
 * 
 * // Handle null or empty values if (i1 < TaskName1.size()) taskName1 =
 * TaskName1.get(i1).getText(); if (i1 < Qnt1.size()) qnt1 =
 * Qnt1.get(i1).getAttribute("value"); if (i1 < ContractorPrice1.size())
 * contractorPrice1 = ContractorPrice1.get(i1).getAttribute("value"); if (i1 <
 * TotalContractorPrice1.size()) totalContractorPrice1 =
 * TotalContractorPrice1.get(i1).getAttribute("value"); if (i1 <
 * ClientPrice1.size()) clientPrice1 =
 * ClientPrice1.get(i1).getAttribute("value"); if (i1 < ClientTotal1.size())
 * clientTotal1 = ClientTotal1.get(i1).getAttribute("value"); if (i1 <
 * Comments1.size()) comments1 = Comments1.get(i1).getAttribute("value");
 * 
 * String[] line1 = { taskName1, qnt1, contractorPrice1, totalContractorPrice1,
 * clientPrice1, clientTotal1, comments1};
 * 
 * 
 * System.out.println(String.join(", ", line1));
 * 
 * // Compare line and line1 if (line.equals(String.join(", ", line1))) { //
 * Print the common task System.out.println("Common Task: " + taskName1); } else
 * { System.out.println("No");
 * 
 * }
 */
