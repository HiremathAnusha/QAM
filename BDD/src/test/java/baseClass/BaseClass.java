package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import inTrustBusinessComponents.InTrustDeploymentManagerComp;
import inTrustReporting.ExtentManagerAssociateFunctions;
import inTrustReporting.ExtentManger;
import inTrustReporting.ReadPropertyFileData;
import inTrustReporting.ReusableLibrary;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;

public class BaseClass {

	public static WindowsDriver driver;
	public static ExtentTest childTest;
	public static ExtentTest parentTest;
	protected static boolean nextsteptobeSkipped = false;
	protected Logger logEvent = Logger.getLogger(getClass().getSimpleName());
	protected static ReadPropertyFileData dataReadFromPropertyFile = new ReadPropertyFileData();
	protected static InTrustDeploymentManagerComp inTrustDeploymentManagerComp;
	public static String suiteName;
	public static File reportDirectoryCheck;
	public static ExtentReports extent;
	public static String scenarioName;
	public static ExtentHtmlReporter htmlReporter;

	
	//Initialize Windows Driver
	public WindowsDriver getApplication(String application) {
		System.out.println("******Inside Windows Driver Selection");
		try {
			if (application.equalsIgnoreCase("IDM")) {
				System.out.println("*******Inside IDM*****");
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app",
						"C:\\Program Files (x86)\\Quest\\InTrust\\Manager\\InTrustUI\\Quest.InTrustUI.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
			} else if (application.equalsIgnoreCase("IM")) {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app",
						"C:\\Program Files (x86)\\Quest\\InTrust\\Manager\\Quest InTrust Manager.msc");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
			} else if (application.equalsIgnoreCase("IRV")) {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app", "C:\\Program Files (x86)\\Quest\\InTrust\\Repository Viewer\\new_RV.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			inTrustDeploymentManagerComp = new InTrustDeploymentManagerComp(driver);
			// System.exit(0);
		}
		return driver;
	}

	
	//Method to print results status on reports
	public void getResult(String stepName, String status) throws IOException {
		if (status.equalsIgnoreCase("Fail")) {
			childTest.log(Status.FAIL,
					MarkupHelper.createLabel("Step:- '" + stepName + "' FAILED due to below issues:", ExtentColor.RED));
			childTest.log(Status.FAIL, Arrays.toString((new Throwable()).getStackTrace()));
			childTest.log(Status.FAIL,
					"Snapshot below: " + "<a href='"
							+ getScreenshotWhereRequired(ReusableLibrary.stpNmeScrnshtCreatn(stepName)) + "'>" + "</a>",
					MediaEntityBuilder.createScreenCaptureFromPath(
							getScreenshotWhereRequired(ReusableLibrary.stpNmeScrnshtCreatn(stepName))).build());
		} else if (status.equalsIgnoreCase("Pass")) {
			childTest.log(Status.PASS, MarkupHelper.createLabel("Step:- '" + stepName + "' PASSED", ExtentColor.GREEN));
			// childTest.log(Status.PASS, Arrays.toString((new
			// Throwable()).getStackTrace()));
			childTest.log(Status.PASS,
					"Snapshot below: " + "<a href='"
							+ getScreenshotWhereRequired(ReusableLibrary.stpNmeScrnshtCreatn(stepName)) + "'>" + "</a>",
					MediaEntityBuilder.createScreenCaptureFromPath(
							getScreenshotWhereRequired(ReusableLibrary.stpNmeScrnshtCreatn(stepName))).build());
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel(
							"Step:- '" + stepName + "' Test Case SKIPPED because the previous step failed",
							ExtentColor.ORANGE));
			childTest.log(Status.SKIP, Arrays.toString((new Throwable()).getStackTrace()));
		}

	}

	
	//Take Screenshot
	public String getScreenshotWhereRequired(String testName) {
		String path = null;
		String directoryPath = System.setProperty("user.dir", "\\Screenshots");
		TakesScreenshot ts = (TakesScreenshot) driver;
		if (driver instanceof TakesScreenshot) {
			File directoryExistence = createDirectory(directoryPath + "//Screenshots//" + testName);
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			path = directoryExistence + "\\screenshot_" + getCurrentDateandTime() + ".jpg";
			File destination = new File(path);
			try {
				Files.deleteIfExists(Paths.get("path"));
				FileUtils.copyFile(srcFile, destination);
			} catch (IOException e) {
			}
		} else {

		}
		return path;

	}

	
	//Method to create directory
	public File createDirectory(String directoryName) {
		File directoryfortheDay = new File(directoryName);
		if (!directoryfortheDay.exists()) {
			// logEvent.info("Directory creation takes place for Reports" +
			// directoryfortheDay);
			directoryfortheDay.mkdir();
			// System.out.println("**************Created************");
		} else {
			// logEvent.info(directoryfortheDay+ " already created directory");
			// System.out.println("**************Already Created************");
			/**
			 * Do nothing
			 */
		}
		return directoryfortheDay;
	}

	
	//Date and Time Method
	static String getCurrentDateandTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss a");
		Date date = new Date();
		String dateString = dateFormat.format(date);
		return dateString;
	}

	
	//implicit wait
	public void hardWait(int n) {
		int waitTime = (Integer.parseInt(dataReadFromPropertyFile.readData("maxintegertimeout"))) / 10;
		try {
			for (int i = 1; i <= waitTime; i++)
				driver.manage().timeouts().implicitlyWait(10 * i, TimeUnit.SECONDS);

		} catch (Exception e) {
		}
	}

	
	// waits 
	public void stopFlow(int n) {
		try {
			for (int i = 1; i <= n; i++) {
				Thread.sleep(1000 * i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
