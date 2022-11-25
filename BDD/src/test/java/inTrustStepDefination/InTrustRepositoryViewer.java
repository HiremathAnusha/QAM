package inTrustStepDefination;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import baseClass.BaseClass;
import inTrustReporting.StepDetails;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.When;

public class InTrustRepositoryViewer extends BaseClass {

	Random ran = new Random();
	int random = ran.nextInt(100);

	@When("^Initialize \"([^\"]*)\" and User Open the InTrust Repository Viewer$")
	public void User_Open_InTrust_Repository_Viewer(String app) throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		System.out.println(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app", "C:\\Program Files (x86)\\Quest\\InTrust\\Repository Viewer\\new_RV.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
				// inTrustDeploymentManagerComp.setUp();
				// Assert.assertEquals(driver.findElementByName("_New...").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper.createLabel("Opened the InTrust Repository Viewer successfully",
						ExtentColor.GREEN));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		}
	}

	@When("^User Open the InTrust Repository Viewer$")
	public void User_Open_the_InTrust_Repository_Viewer() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app", "C:\\Program Files (x86)\\Quest\\InTrust\\Repository Viewer\\new_RV.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
				childTest.log(Status.PASS, MarkupHelper.createLabel("Opened the InTrust Repository Viewer successfully",
						ExtentColor.GREEN));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository creation", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}
	
	@When("^User Open the repository to and click on go to analyse the results$")
	public void User_Open_the_repo_to_analyse_the_results() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app", "C:\\Program Files (x86)\\Quest\\InTrust\\Repository Viewer\\new_RV.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
				// inTrustDeploymentManagerComp.setUp();
				// Assert.assertEquals(driver.findElementByName("_New...").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper.createLabel("Opened the InTrust Repository Viewer successfully",
						ExtentColor.GREEN));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository creation", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

}
