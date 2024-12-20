package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;
	static Properties p;

	public static void readproperty() throws IOException {
		p = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\configuration.properties");
		p.load(f);
	}

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browservalue) {
		if (browservalue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browservalue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {

		readproperty();

		driver.get(p.getProperty("Base_url"));
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void afterMethod() {
		// if (itr.getStatus() == ITestResult.FAILURE) {
		// ScreenShotClass.takeScreenShot(driver, itr.getName());
		// }

		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("*********Test Execution Completed******");
	}

	@BeforeSuite(alwaysRun = true)
	  public void createReport(final ITestContext testContext) {
			extentReport.ExtentManager.createInstance();
		}
}
