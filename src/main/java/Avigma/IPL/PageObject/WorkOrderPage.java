package Avigma.IPL.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class WorkOrderPage extends AbstractComponent {
	WebDriver driver;

	public WorkOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//Task 1 In office result tab 
	@FindBy(className = "overlay")
	WebElement Spinner;

	@FindBy(xpath = "/html/body/app-root/div/ng-component/app-header-client-result/div/div[2]/div[1]/ul/li[1]/b")
	WebElement IPLNumber;

	@FindBy(xpath = "//a[.='Office Results ']")
	WebElement OfficeResutBtn;

	@FindBy(xpath = "//div[@class=\"ng-tns-c164-3 ng-star-inserted\"]")
	WebElement OfficeSpinner;

	@FindBy(xpath = "//span[.='Select']")
	WebElement Tasklist;

	@FindBy(xpath = "//li[@index=\"15\"]")
	WebElement TaskOption;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement Quantity;

	@FindBy(xpath = "//select[@class='form-control form-control-sm p-0 ng-pristine ng-valid ng-touched']")
	WebElement UOM;

	@FindBy(xpath = "//select/option[.=' CYD ']")
	WebElement UOMOption;


	@FindBy(css = "tbody tr[type='Bid'] td:nth-child(5) div:nth-child(1) input:nth-child(1)")
	WebElement ContractorTotal;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/div[1]/textarea[1]")
	WebElement CommentBox;

	@FindBy(xpath = "//label[@for='damageBid0']")
	WebElement damageBid;

	@FindBy(xpath = "//div[@id='home2']//button[1]")
	WebElement AddBtn;

	// Task in office result tab
	@FindBy(xpath = "//li[@index=\"10\"]")
	WebElement Task2Option;

	@FindBy(xpath = "//label[@for='violationBid1']")
	WebElement violationBid1;

	@FindBy(xpath = "//div[@id='home2']//button[2]")
	WebElement BidSaveBtn;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
	WebElement QuantityTask2;

	@FindBy(xpath = "//button[.='Close..']")
	WebElement Closebtn;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/div[1]/textarea[1]")
	WebElement Comment2;

	@FindBy(xpath = "//table[@class=\"result-table table col-11.5 mt-1 mb-1\"]")
	WebElement BidTaskDetails;

	// Checking the bid task details from office result tab and field result tab
	@FindBy(xpath = "//a[.='Field Results ']")
	WebElement FieldResultBtn;

	@FindBy(xpath = "//div[@class='ng-tns-c164-9 ng-star-inserted']")
	WebElement SpinnerOnFieldResults;

	@FindBy(xpath = "//table[@class=\"result-table table col-11.5 mt-1 mb-1\"]")
	WebElement FieldResultDetails;

	@FindBy(xpath = "//div[@id='home2']//button[2]")
	WebElement BidSaveBtn2;

	@FindBy(xpath = "//a[.=' Work Orders ']")
	WebElement workorderBtn;

	// Instructions Task

	public String GrabIPL() {
		String IPLNum = IPLNumber.getText();
		String[] IPLNumSplit = IPLNum.split("#");
		String IPLActual = IPLNumSplit[1].trim();
		System.out.println(IPLActual);
		return IPLActual;

	}

	public void WorkOrderBtn() {
		workorderBtn.click();
	}

	public void CreateBidTask1() {
		Actions action = new Actions(driver);
		action.scrollToElement(Tasklist);
		Tasklist.click();

	}

	public void CreateBidTask2(String quantity) {
		TaskOption.click();
		Quantity.clear();
		Quantity.sendKeys(quantity);
		// UOM.click();
		// UOMOption.click();
		// ContractorPrice.sendKeys(contractorprice);
		// ContractorTotal.sendKeys(contractortotal);

	}

	public void CreateBidTask3(String comment) {
		CommentBox.sendKeys(comment);
		damageBid.click();
		Actions action = new Actions(driver);
		action.moveToElement(AddBtn);

	}

	public void AddNewTask(String quantity, String comment) {
		AddBtn.click();
		Tasklist.click();
		Task2Option.click();
		QuantityTask2.clear();
		QuantityTask2.sendKeys(quantity);
		Comment2.sendKeys(comment);
		violationBid1.click();
		Actions action = new Actions(driver);
		action.moveToElement(BidSaveBtn);
		BidSaveBtn.click();

	}

	public void OfficeResultTaskDetails() {
		Closebtn.click();
	}

	public String GrabTaskDetails() {
		String TaskDetails = BidTaskDetails.getText();
		// System.out.println(TaskDetails);
		// Need to wait to grab the text
		return TaskDetails;

	}

	public void FieldResultTab() {
		FieldResultBtn.click();

	}

	private void waitForTextToMatch(final WebElement FieldResultDetails, final String TaskDetails) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return FieldResultDetails.getText().equals(TaskDetails);
			}
		});
	}

	public void FieldResultBidTask1(String TaskDetails) {
		waitForTextToMatch(FieldResultDetails, TaskDetails);

		String FieldResultBidTaskDetails = FieldResultDetails.getText();
		if (TaskDetails.equals(FieldResultBidTaskDetails)) {
			System.out.println("Task details match between Office Result and Field Result.");
		} else {
			System.out.println("Task details do not match between Office Result and Field Result.");
		}
		Assert.assertEquals(TaskDetails, FieldResultBidTaskDetails);
		// ACTUAL, EXPECTED

	}

	@FindBy(xpath = "//kendo-editor[@id='myFrame']")
	WebElement iframeElement1;

	@FindBy(xpath = "//*[@id='myFrame']/div/iframe")
	WebElement iframeElement2;

	@FindBy(xpath = "/html/body/div")
	WebElement CommentInstru;

	@FindBy(xpath = "//button[starts-with(text(),' Save ')]")
	WebElement InsCommentSaveBtn;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement Continue;

	@FindBy(css = "body > app-root:nth-child(1) > div:nth-child(2) > ng-component:nth-child(2) > div:nth-child(2) > ng-component:nth-child(2) > div:nth-child(1) > div:nth-child(1) > app-ipl-app-work-order-details-tabs:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")
	WebElement TaskTab;

	@FindBy(xpath = "//select[@id=\"TaskType\"]")
	List<WebElement> taskTypeElements;

	@FindBy(xpath = "//div/kendo-dropdownlist/span[@role=\"listbox\"]")
	List<WebElement> taskTypeNames;
	
	@FindBy(xpath = "//input[@type='number' and @placeholder='Enter Qty']")
	List<WebElement> BidTaskQnt;
	
	@FindBy(xpath = "//textarea[contains(@style,'width: 100%;')]")
	List<WebElement> BidTaskComments;
	
	@FindBy(xpath = "//input[@placeholder=\" Enter Contractor Price\"]")
	List<WebElement> ContractorPrice;
	
	@FindBy(xpath = "//input[@placeholder=\"Contractor Price\"]")
	List<WebElement> TotalContractorPrice;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter Client Price\"]")
	List<WebElement> ClientPrice;
    
	@FindBy(xpath = "//input[@placeholder=\"Client Price\"]")
	List<WebElement> ClientTotal;
	
	@FindBy(xpath = "//textarea[contains(@style,'width: 100%;')]")
	List<WebElement> Comments;

	
	
	@FindBy(xpath = "//li[@index=\"20\"]")
	WebElement TaskNameOpt;

	@FindBy(xpath = "//input[@placeholder='Enter Qty']")
	List<WebElement> TaskQnt;

	@FindBy(xpath = "//textarea[contains(@style,'width: 100%;')]")
	List<WebElement> TaskComment;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[1]/i[1]")
	WebElement AddTask;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[2]")
	WebElement SaveBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
	WebElement CloseBtn;
	
	@FindBy(xpath = "//select[contains(@id,'TaskType')]")
	List<WebElement> InsTaskType;

	@FindBy(xpath = "//div/kendo-dropdownlist/span[@role=\"listbox\"]")
	List<WebElement> InsTaskName;
	
	@FindBy(xpath = "//input[@placeholder='Enter Qty']")
	List<WebElement> InsQnt;
	
	@FindBy(xpath = "//input[@placeholder=\" Enter Contractor Price\"]")
	List<WebElement> InsContractorPrice;
	
	@FindBy(xpath = "//input[@placeholder=\"Contractor Price\"]")
	List<WebElement> InsTotalContractorPrice;

	@FindBy(xpath = "//input[@placeholder=\"Enter Client Price\"]")
	List<WebElement> InsClientPrice;

	@FindBy(xpath = "//input[@placeholder=\"Client Price\"]")
	List<WebElement> InsClientTotal;
	
	@FindBy(xpath = "//textarea[contains(@style,'width: 100%;')]")
	List<WebElement> InsComments;
	
	@FindBy(xpath = "//a[.='Invoice ']")
	WebElement InvoiceTab;

	  List<WebElement> InstructionallElements = new ArrayList<>();
	    String Instructiontask = "";

	    List<String> instructionTabList = new ArrayList<>();

	    List<WebElement> InvoiceAllElements = new ArrayList<>();
	    String Invoicetask = "";

	    List<String> invoiceTabList = new ArrayList<>();
	    List<String> commonTasks = new ArrayList<>();

    @FindBy(xpath = "//span[@role=\"listbox\"]")
	List<WebElement> InvoiceTaskName;
    
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[2]/input[1]")
   	List<WebElement> InvoiceQnt;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[3]/div[1]/input[1]")
	List<WebElement> InvoiceContractorPrice;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-table[1]/div[1]/div[1]/table[1]/tr/td[4]/div[1]/input[1]")
	List<WebElement> InvoiceTotalContractorPrice;

    @FindBy(xpath = "//textarea[@placeholder='Enter Comments']")
	List<WebElement> InvoiceComments;
    


	public void AddInstructionComment(String comment) {
		Actions action = new Actions(driver);
		action.scrollToElement(iframeElement1);

	}

	public void AddInstruComment(String comment) {
		Actions action = new Actions(driver);
		driver.switchTo().frame(iframeElement2);
		CommentInstru.sendKeys(comment);
		driver.switchTo().defaultContent();
		action.scrollToElement(InsCommentSaveBtn);
		InsCommentSaveBtn.click();

	}

	public void CloseBtn() {
		// driver.switchTo().frame(IframeContinue);
		Continue.click();

	}

	public void TaskTabClick() {
		Actions action = new Actions(driver);
		action.scrollToElement(TaskTab);
		TaskTab.click();

	}
	public void AddTaks() {
	
		AddTask.click();

	}
	public void CheckTaskTypeEmptyBid( ) {
		for (WebElement taskTypeElement : taskTypeElements) {
			Select dropdown = new Select(taskTypeElement);
			String SelectedOption = dropdown.getFirstSelectedOption().getText();
		if (SelectedOption.equals("Select"))
		{
			dropdown.selectByVisibleText("Bid");
		} else
			
		{
            System.out.println("Selected option: " + SelectedOption);

		
		}
		 }
	}
	
	public void CheckTaskNameEmptyBid( ) {
		
		for (int i=0; i< taskTypeNames.size(); i++)
	    	for (WebElement taskTypeName : taskTypeNames) {
				String SelectedOption = taskTypeName.getText();
			if (SelectedOption.equals("Select"))
			{
				taskTypeName.click();
		        WebElement TaskNameOpt = driver.findElement(By.xpath("//li[@index=\"20\"]"));
		        TaskNameOpt.click();
			} else
				
			{
	            System.out.println("Selected option: " + SelectedOption);

			}
		}
	}
	
	public void BidQnt() {
        WebElement lastQuntityField = null;

        // Iterate over each element in the list
        for (WebElement currentTextbox : BidTaskQnt) {
            // Check if the current textbox is interactable
            if (currentTextbox.isDisplayed()) {
                // Update the last interactable textbox
            	lastQuntityField = currentTextbox;
            	
            }
        }
        if (lastQuntityField != null) {
            	lastQuntityField.clear();
            	lastQuntityField.sendKeys("10");
            }
	}
	
	public void InsTabTaskComment( ) {
    WebElement lastCommentField = null;

    // Iterate over each element in the list
    for (WebElement currentTextbox : BidTaskComments) {
        // Check if the current textbox is interactable
        if (currentTextbox.isDisplayed()) {
            // Update the last interactable textbox
        	lastCommentField = currentTextbox;
        	
        }
    }
    if (lastCommentField != null) {
    	lastCommentField.sendKeys("Task Created Successfully");
    }
        }
	
	public void CheckTaskTypeEmptyCompletion( ) {
		for (WebElement taskTypeElement : taskTypeElements) {
			Select dropdown = new Select(taskTypeElement);
			String SelectedOption = dropdown.getFirstSelectedOption().getText();
		if (SelectedOption.equals("Select"))
		{
			dropdown.selectByVisibleText("Completion");
		} else
			
		{
            System.out.println("Selected option: " + SelectedOption);

		
		}
		 }
	}
	
	public void CheckTaskNameEmptyCompletion( ) {
		
		for (int i=0; i< taskTypeNames.size(); i++)
	    	for (WebElement taskTypeName : taskTypeNames) {
				String SelectedOption = taskTypeName.getText();
			if (SelectedOption.equals("Select"))
			{
				taskTypeName.click();
		        WebElement TaskNameOpt = driver.findElement(By.xpath("//li[@index=\"15\"]"));
		        TaskNameOpt.click();
			} else
				
			{
	            System.out.println("Selected option: " + SelectedOption);

			}
		}
	}
	

	public void CheckTaskTypeEmptyInspection( ) {
		for (WebElement taskTypeElement : taskTypeElements) {
			Select dropdown = new Select(taskTypeElement);
			String SelectedOption = dropdown.getFirstSelectedOption().getText();
		if (SelectedOption.equals("Select"))
		{
			dropdown.selectByVisibleText("Inspection");
		} else
			
		{
            System.out.println("Selected option: " + SelectedOption);

		
		}
		 }
	}
	
	public void CheckTaskNameEmptyInspection( ) {
		
		for (int i=0; i< taskTypeNames.size(); i++)
	    	for (WebElement taskTypeName : taskTypeNames) {
				String SelectedOption = taskTypeName.getText();
			if (SelectedOption.equals("Select"))
			{
				taskTypeName.click();
		        WebElement TaskNameOpt = driver.findElement(By.xpath("//li[@index=\"9\"]"));
		        TaskNameOpt.click();
			} else
				
			{
	            System.out.println("Selected option: " + SelectedOption);

			}
		}
	}
	
	public void SaveInstructionTask( ) {
		SaveBtn.click();
	}
	public void CloseInstructionTask( ) {
		CloseBtn.click();
	}
	
	public void CollectTasksInstruction( ) {
		InstructionallElements.addAll(InsTaskType);
		InstructionallElements.addAll(InsTaskName);
		InstructionallElements.addAll(InsQnt);
		InstructionallElements.addAll(InsContractorPrice);
		InstructionallElements.addAll(InsTotalContractorPrice);
		InstructionallElements.addAll(InsClientPrice);
		InstructionallElements.addAll(InsClientTotal);
		InstructionallElements.addAll(InsComments);
		
		
		 int size = InsTaskType.size();
		    for (int i = 0; i < size; i++) {
		    	
		        String taskName = InsTaskName.get(i).getText();
		        String qnt = InsQnt.get(i).getAttribute("value");
		        String contractorPrice = InsContractorPrice.get(i).getAttribute("value");
		        String totalContractorPrice = InsTotalContractorPrice.get(i).getAttribute("value");
		        String comments = InsComments.get(i).getAttribute("value");
		        String[] lineArray = { taskName, qnt, contractorPrice, totalContractorPrice, comments };
				if (!taskName.isEmpty()) {
					Instructiontask = String.join(", ", lineArray).trim();
					instructionTabList.add(Instructiontask);	
					System.out.println(instructionTabList);
					}
		}
			
		InvoiceTab.click();
		
	
	}
	public void CollectTasksInvoice( ) {
		InvoiceAllElements.addAll(InvoiceTaskName);
		InvoiceAllElements.addAll(InvoiceQnt);
		InvoiceAllElements.addAll(InvoiceTotalContractorPrice);
		InvoiceAllElements.addAll(InvoiceContractorPrice);
		InvoiceAllElements.addAll(InvoiceComments);
        System.out.println(" ");
        System.out.println(InvoiceAllElements);
        
		int size1 = InvoiceTaskName.size();
	    for (int i1 = 0; i1 < size1; i1++) {
	    	String taskName1 = "";
			String qnt1 = "";
			String contractorPrice1 = "";
			String totalContractorPrice1 = "";
			String clientPrice1 = "";
			String clientTotal1 = "";
			String comments1 = "";
	    	
			if (i1 < InvoiceTaskName.size())
				taskName1 = InvoiceTaskName.get(i1).getText();
			if (i1 < InvoiceQnt.size())
				qnt1 = InvoiceQnt.get(i1).getAttribute("value");
			if (i1 < InvoiceContractorPrice.size())
				contractorPrice1 = InvoiceContractorPrice.get(i1).getAttribute("value");
			if (i1 < InvoiceTotalContractorPrice.size())
				totalContractorPrice1 = InvoiceTotalContractorPrice.get(i1).getAttribute("value");
			if (i1 < InvoiceComments.size())
				comments1 = InvoiceComments.get(i1).getAttribute("value");

	    	String[] line1Array = { taskName1, qnt1, contractorPrice1, totalContractorPrice1, comments1 };
	        if (!taskName1.isEmpty()) {
	            Invoicetask = String.join(", ", line1Array).trim();
	            invoiceTabList.add(Invoicetask);
				System.out.println(invoiceTabList);

			}
		}
	    
	    for (String task : instructionTabList) {
            if (invoiceTabList.contains(task)) {
                commonTasks.add(task);
            }
        }
        System.out.println("Common tasks between Instruction and invoice tab:");
        for (String commonTask : commonTasks) {
            //System.out.println(commonTask);
            Assert.assertTrue(false);
          
        }
	}
		
}

