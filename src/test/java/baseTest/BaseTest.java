package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static Properties login= new Properties();
	public static Properties config = new Properties();
	  
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;
	
	public static WebDriverWait wait;
	
	@BeforeSuite
public void setUp() throws FileNotFoundException , InterruptedException{
		
	 if (driver == null) {
			// getting data from config
			fis = new FileInputStream(
			  System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			try {
				config.load(fis);
			} 
				
				catch (IOException e) {
				    logger.error("Failed to load properties file", e);
				    throw new RuntimeException("Properties file could not be loaded");
			}

			// getting data from login
			fis1 = new FileInputStream(
			  System.getProperty("user.dir") + "\\src\\test\\resources\\login.properties");
			try {
				login.load(fis1);
			} catch (IOException e) {
			    logger.error("Failed to load properties file", e);
			    throw new RuntimeException("Properties file could not be loaded");
			}
			

		}
		if (config.getProperty("Browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser loaded successfully");
		} else if (config.getProperty("Browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (config.getProperty("Browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(config.getProperty("Base_url"));
		System.out.println("Base_url: " + config.getProperty("Base_url"));
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

   
}
	@BeforeClass
	public static void startTest()
	{
		 String reportPath = System.getProperty("user.dir") + "\\reports\\extent-report.html";
	        sparkReporter = new ExtentSparkReporter(reportPath);
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Tester", "Mahima Kumari");
	        extent.setSystemInfo("Browser", config.getProperty("Browser"));
		
	}
 @AfterSuite
 public void teardown()
 {
	 if(driver!=null)
	 {
		 driver.quit();
		 logger.info("Browser closed");
		   extent.flush();
	 }
 }
}


