package Avigma.IPL.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Avigma.IPL.PageObject.LoginPage;
import Report.ExtentReporterNG;

public class BaseTest {
	public WebDriver driver;
	ExtentReports extent;

	public WebDriver InitializeDriver() throws IOException 
	{
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalProperties.Properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
	
		if (browserName.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		//driver.get("https://testui.ipreservationlive.com/admin/login");
		
	}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			 driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		  try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            File file = new File(System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png");
	            FileUtils.copyFile(source, file);
	            return file.getAbsolutePath();
	        } catch (IOException e) {
	            // Log the permission denied error
	            System.err.println("Permission denied error occurred while trying to create screenshot:");
	            e.printStackTrace();
	            return null;
	        }
	}
	
	@BeforeTest
	    public void setUp() {
	        extent = ExtentReporterNG.getReportObject();
	    }
	
	public LoginPage launchApplication() throws IOException {
		driver = InitializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
	}

}
