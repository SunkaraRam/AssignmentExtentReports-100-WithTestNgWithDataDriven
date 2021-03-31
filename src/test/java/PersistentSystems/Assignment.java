package PersistentSystems;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import SunkaraRam.Assignment.DataPass;

public class Assignment extends DataPass {

	public Assignment() throws Throwable {
		super();	
		}

	private String RunTimemethodName = "NaviD";
	

	@Parameters({ "brw" })
	@BeforeMethod
	public void launch(String brw) {
		
		
   SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
		   
	dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("IST"));	
	   
	   String date = dateTimeInGMT.format(new Date());
	   
//	   String pdate = date.replaceAll(" ", "_");
	   
	   String dateR = date.replaceAll("-", "");
	   
	   String dateS = dateR.replaceAll(" ","");
	   
	   String  dateT=RunTimemethodName+"_"+dateS.substring(0, 16).replace(":", "");
	    
	   String datee="charan"+date;
	   
	   System.out.println(dateT);
	   
	   String path = "F:\\Assignments\\Assignment\\TestOutput\\"+dateT+".html";

	   report = new ExtentHtmlReporter(path);
	   report.config().setDocumentTitle("Automation Test Report");
	   report.config().setReportName("RAmSunkara");
	   report.config().setTheme(Theme.STANDARD);
	   report.start();
	
		extent = new ExtentReports();
		
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Amezon");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		test = extent.createTest("Verify Test one");

	   

   
   
			if (brw.equalsIgnoreCase("chrome")) {
				
		
				System.setProperty("webdriver.chrome.driver", "F:\\ChromeDrivers\\v89\\chromedriver.exe");
		
				driver = new ChromeDriver();

				driver.manage().deleteAllCookies();
				
				test.log(Status.INFO," Deleting All cookies in ChromeDriver");
				
				driver.manage().window().maximize();
				
				test.log(Status.INFO," Maximizing Chrome Browser");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				test.log(Status.INFO," Launching Url in ChromeBrowser");

				
			}
		
		if (brw.equalsIgnoreCase("ff")) {
			
//			dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("IST"));	
//			   
//			   String date = dateTimeInGMT.format(new Date());
//			   
////			   String pdate = date.replaceAll(" ", "_");
//			   
//			   String dateR = date.replaceAll("-", "");
//			   
//			   String dateS = dateR.replaceAll(" ","");
//			   
//			   String  dateT=RunTimemethodName+"_"+dateS.substring(0, 16).replace(":", "");
//			    
//			   String datee="charan"+date;
//			   
//			   System.out.println(dateT);
//			   
//			   String path = "F:\\Assignments\\Assignment\\TestOutput\\"+dateT+".html";
//		
//			   report = new ExtentHtmlReporter(path);
//			   report.config().setDocumentTitle("Automation Test Report");
//			   report.config().setReportName("RAmSunkara");
//			   report.config().setTheme(Theme.STANDARD);
//			   report.start();
//			
//				extent = new ExtentReports();
//				
//				extent.attachReporter(report);
//				extent.setSystemInfo("Application", "Amezon");
//				extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//				extent.setSystemInfo("User Name", System.getProperty("user.name"));
//				test = extent.createTest("Verify Test one");
//		
			
			System.setProperty("webdriver.gecho.driver", "F:\\ChromeDrivers\\gecko\\v29\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			driver.manage().deleteAllCookies();
			
			
			
			test=extent.createTest("Deleting All cookies in FireFox");
			
			driver.manage().window().maximize();
			
			test=extent.createTest("Maximizing Firefox Browser");
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			test=extent.createTest("Launching Url in Fire Fox");
			
			
		}
				
	}

	int navigationCount =1;
	
	@Test(dataProvider = "getData")
	public void NaviD(String url) throws InterruptedException {
		
		driver.navigate().to(url);
		
		//Thread.sleep(3000);
		
		String data = driver.getCurrentUrl();
		
		if (url.toLowerCase().contains(data.toLowerCase())) {

//			test.log(Status.PASS, );
			test.pass("User is navigated successfully to "+ url);
			
		}
		
		else {
			
			test.fail("User is NOT navigated to "+ url);
			//test.log(Status.FAIL,"User is NOT navigated to "+ url );
			
		}
		
		test.log(Status.INFO," Navigation count is increasing here");
		
		
		navigationCount++;
		
		
	}
	
	
	@DataProvider(name="getData")
	public Object[] getData() {
		
		Object[] obj = new Object[3];
		
		obj[0]="https://www.flipkart.com/";
		obj[1]="https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		obj[2]="https://www.ebay.com/";
//		obj[4]="ram4";
//		obj[5]="ram5";
//		obj[6]="ram6";
//		obj[7]="ram7";
//		obj[8]="ram8";
//		obj[9]="ram9";
//		obj[10]="ram10";
//		
		return obj;
		
		
	}
	
	@AfterMethod
	public void close() {
		
		test.info("Browser closed successfully");
		
		extent.flush();
		
		driver.quit();
		
		System.out.println("Navigation Count from Two Browsers :  "  + navigationCount);
		
	}
	
}
