package inTrustStepDefination;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import baseClass.BaseClass;
import inTrustReporting.ExtentManagerAssociateFunctions;
import inTrustReporting.ExtentManger;
import inTrustReporting.ReusableLibrary;
import inTrustReporting.StepDetails;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;

public class InTrustDeploymentManagerSteps extends BaseClass {

	Random ran = new Random();
	int random = ran.nextInt(100);
	private static boolean initialized = false;

	@Before
	public static void setUpFile(Scenario scenario) throws Exception {
		if (!initialized) {
			// Init context. Run just once before first scenario starts
			suiteName = ReusableLibrary.featrNmeReportCreatn(scenario.getName());
			reportDirectoryCheck = ExtentManagerAssociateFunctions.createDirectory(System.getProperty("user.dir")
					+ "/Reports/Reports__" + ExtentManagerAssociateFunctions.getCurrentDate());
			String fileName = reportDirectoryCheck + "\\" + suiteName + "__"
					+ ExtentManagerAssociateFunctions.getCurrentDateandTime() + ".html";
			extent = ExtentManger.createInstance(fileName);
			System.out.println("*******Extent Report Starts*******");
			extent.setSystemInfo("InTrust", "Regression Testing");
			extent.setSystemInfo("Creator", "InTrust Automation Team");
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					extent.flush();
				}
			});
			initialized = true;
		}
		scenarioName = ReusableLibrary.scenarioNameforTData(scenario.getName());
		parentTest = extent.createTest(scenario.getName());
//		parentTest.assignCategory(ReusableLibrary.categoryConfirm(scenario.getId(), scenario.getName()));
		parentTest.assignCategory(ReusableLibrary.categoryConfirm(scenario.getName()));
	}

	@After
	public void teardown() {
		System.out.println("Close browser");
		driver.quit();
	}

	@When("^Initialize \"([^\"]*)\" and User Open the InTrust Deployment Manager$")
	public void User_Open_InTrust_Deployement_Manager(String app) throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		System.out.println(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app",
						"C:\\Program Files (x86)\\Quest\\InTrust\\Manager\\InTrustUI\\Quest.InTrustUI.exe");
				dcap.setCapability("platformname", "Windows");
				dcap.setCapability("ms:waitForAppLaunch", "25");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
				// inTrustDeploymentManagerComp.setUp();
				Assert.assertEquals(driver.findElementByName("Welcome to Quest InTrust").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Opened the InTrust Deployement Manager successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Failed to Open InTrust Deployement Manager", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to Open InTrust Deployement Manager", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User open the project folder location for the latest build$")
	public void User_Open_the_project_folder_location() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		System.out.println(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				DesiredCapabilities dcap = new DesiredCapabilities();
				dcap.setCapability("app", "C:\\InTrust\\InTrust\\Suite\\AeCDSuiteLauncher.exe");
				dcap.setCapability("ms:waitForAppLaunch", "80");
				driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), dcap);
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Opened the autorun successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Failed to Opened the autorun successfully", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to Opened the autorun successfully", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User click next to proceed the installation$")
	public void User_click_next_to_proceed_the_installation() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		System.out.println(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Next >").click();
				stopFlow(2);
				driver.findElementByName("Next >").click();
				stopFlow(5);
				driver.findElementByName("Proceed to _Installation Wizard").click();
				stopFlow(5);
				driver.findElementByName("Install >").click();
				// Assert.assertEquals(driver.findElementByName("_New...").isDisplayed(), true);
				logEvent.error("Clicked Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Opened the InTrust Deployement Manager successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Failed to Open InTrust Deployement Manager", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to Open InTrust Deployement Manager", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select Install Navigation and install InTrust extented suite$")
	public void User_Select_Install_Navigation_and_install_extended_suite() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		System.out.println(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				System.out.println("*******Installation**************88888");
				driver.findElementByName("Next >").click();
				driver.findElementByName("Install").click();
				driver.findElementByName("Install").click();
				logEvent.error("Clicked Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Opened the InTrust Deployement Manager successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Failed to Open InTrust Deployement Manager", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to Open InTrust Deployement Manager", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on New button on top left corner to create the window collection with agent installed$")
	public void User_Click_on_New_Button_to_create_window_collection_with_agent() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		// inTrustDeploymentManagerComp.newWindowCollection();
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(1).click();
				driver.findElementByName("_New...").click();
				driver.findElementByName("Windows Collection").click();
				Assert.assertEquals(driver.findElementByAccessibilityId("CollectionName").isDisplayed(), true);
				logEvent.error("Clicked Successfully");
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"Selected Windows collection with agent installation successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper
						.createLabel("Failed to Select Windows collection with agent installation", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper
					.createLabel("Skipped to Select Windows collection with agent installation", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on New button on top left corner to create the window collection without agent installed$")
	public void User_Click_on_New_Button_to_create_window_collection_without_agent() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(1).click();
				driver.findElementByName("_New...").click();
				driver.findElementByName("Windows Collection").click();
				Assert.assertEquals(driver.findElementByAccessibilityId("CollectionName").isDisplayed(), true);
				logEvent.error("Clicked Successfully");
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"Selected Windows collection without agent installation successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper
						.createLabel("Not Selected Windows collection without agent installation", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Windows collection without agent installation",
					ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click collection tab$")
	public void User_Click_on_collection_tab() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		// inTrustDeploymentManagerComp.newWindowCollection();
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(1).click();
				Assert.assertEquals(driver.findElementByName("Computers by collection").isDisplayed(), true);
				logEvent.error("Reached on Collection tab successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Reached on Collection tab successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Failed to click on Collection tab", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to click on Collection tab", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Enter Name and Description and click Next$")
	public void User_Enter_Name_and_Description() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				driver.findElementByAccessibilityId("CollectionName").clear();
				driver.findElementByAccessibilityId("CollectionName").sendKeys("MyCollection" + random);
				driver.findElementByName("_Next >").click();
				driver.findElementByName("Install agents automatically").click();
				Assert.assertEquals(driver.findElementByName("_Add").isDisplayed(), true);
				logEvent.error("Entered Name and Description Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Entered Name and Description Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Not Entered Name and Description Successfully", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped Entered Name and Description Successfully", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Enter Name and Description and click Next to proceed forward$")
	public void User_Enter_Name_and_Description_and_next_to_proceed_forward() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				driver.findElementByAccessibilityId("CollectionName").clear();
				driver.findElementByAccessibilityId("CollectionName").sendKeys("MyCollection");
				driver.findElementByName("_Next >").click();
				driver.findElementByName("Install agents automatically").click();
				Assert.assertEquals(driver.findElementByName("_Add").isDisplayed(), true);
				logEvent.error("Entered Name and Description Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Entered Name and Description Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Not Entered Name and Description Successfully", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped Entered Name and Description Successfully", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Enter Name and Description and click Next to proceed$")
	public void User_Enter_Name_and_Description_to_proceed() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				driver.findElementByAccessibilityId("CollectionName").clear();
				driver.findElementByAccessibilityId("CollectionName").sendKeys("MyCollection" + random);
				driver.findElementByName("_Next >").click();
				Assert.assertEquals(driver.findElementByName("_Add").isDisplayed(), true);
				logEvent.error("Entered Name and Description Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Entered Name and Description Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Not Entered Name and Description", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped Entered Name and Description Successfully", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select Domain by clicking on Add then Domain and Select Domains$")
	public void User_Select_Domain() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.selectDomain();
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByName("_Add")).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
						.build().perform();
				driver.findElementByAccessibilityId("PickDomains").click();
				driver.findElementByName("questlab.com").click();
				driver.findElementByName("OK").click();
				driver.findElementByName("_Next >").click();
				Assert.assertEquals(driver.findElementByName("Data Sources and Repository").isDisplayed(), true);
				logEvent.error("Selected Domains Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Selected Domains Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Not Selected domain", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Domain selection", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select Computer by clicking on Add then Computer and Select Computers$")
	public void User_Select_Computer() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.selectDomain();
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByName("_Add")).click()
						.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).build().perform();
				stopFlow(2);
				driver.findElementByName("Type computer name:").click();
				driver.findElementByAccessibilityId("ComputerName").sendKeys("vjlabintr01");
				driver.findElementByName("OK").click();
				stopFlow(2);
				driver.findElementByName("_Next >").click();
				Assert.assertEquals(driver.findElementByName("Data Sources and Repository").isDisplayed(), true);
				logEvent.error("Selected Computers Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Selected Computers Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Not entered computer details", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Computer Selection", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select Data Source, Repository, Server and click Next$")
	public void User_select_datasource_repo_and_server() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.selectDatSourceRepoServer();
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByName("Windows Application Log")).click().sendKeys(Keys.SPACE)
						.keyDown(Keys.LEFT_CONTROL).sendKeys(Keys.END).keyUp(Keys.LEFT_CONTROL).build().perform();
				action.moveToElement(driver.findElementByName("Windows System Log")).click().sendKeys(Keys.SPACE)
						.build().perform();
				driver.findElementByName("_Next >").click();
				Assert.assertEquals(driver.findElementByName("A new collection will be created").isDisplayed(), true);
				logEvent.error("Selected Data Source Repository and Server Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Selected Data Source Repository and Server Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Not entered data source and repo", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped data source and repo", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on Finish button$")
	public void User_click_on_finish_button() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Finish").click();
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Window Collection is created successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Window Collection is created successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Window Collection is not created", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Window Collection Creataion skipped", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on the refresh button and wait to validate the Computer Status$")
	public void User_click_on_refresh_button() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("_Refresh").click();
				stopFlow(2);
				driver.findElementByName("_Refresh").click();
				stopFlow(2);
				driver.findElementByName("_Refresh").click();
//			stopFlow(2);
//			driver.findElementByName("_Refresh").click();
//			stopFlow(4);
				Assert.assertEquals(driver.findElementByName("Collecting").isDisplayed(), true);
				logEvent.error("Window Collection is created successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Validatd the Computer status as collecting successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Not validated Computer Status", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Validation", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select the collection to edit$")
	public void User_Select_the_collection_to_edit() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("MyCollection").click();
				stopFlow(1);
				driver.findElementByName("Edit").click();
				stopFlow(1);
				driver.findElementByName("_Next>").click();
				driver.findElementByName("_Next>").click();
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByName("Windows PowerShell Log")).click().sendKeys(Keys.SPACE)
						.keyDown(Keys.LEFT_CONTROL).sendKeys(Keys.END).keyUp(Keys.LEFT_CONTROL).build().perform();
				driver.findElementByName("_Next>").click();
				driver.findElementByName("Finish").click();
				stopFlow(2);
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Edited the selected Collection successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Edited the selected Collection successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to edit the selected Collection", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped edit collection", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User go to search folder and select Computers not in collection$")
	public void User_go_to_search_folder_and_select_computers_not_in_collection() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				driver.findElementByName("Computers not in a collection").click();
				driver.findElementByName("Installed").click();
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Selected computers not in collection Successfully");
				childTest.log(Status.PASS, MarkupHelper.createLabel("Selected computers not in collection Successfully",
						ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to select computers not in collection", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to select computers not in collection", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select the server and add that to collection$")
	public void User_select_the_server_abd_that_to_collection() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Add to collection...").click();
				driver.findElementByName("MyCollection").click();
				driver.findElementByName("Add").click();
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Selected computers added in collection Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Selected computers added in collection Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper
						.createLabel("Unable to select computers not added in collection", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped to select computers not added in collection",
					ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Select the collection and select the computer to remove from collection$")
	public void User_select_collection_and_select_the_computer_to_remove_from_collection() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("MyCollection").click();
				driver.findElementByName("Remove from collection").click();
				driver.findElementByName("Yes").click();
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Selected computers is removed from collection Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Selected computers is removed from collection Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to remove computers from collection", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to remove computers from collection", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User select the computer and select option to install agent manually$")
	public void User_select_computer_and_select_option_to_install_agent_manaully() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Collecting").click();
				driver.findElementByName("Install agent").click();
				driver.findElementByName("Yes").click();
				Assert.assertEquals(driver.findElementByName("_Refresh").isDisplayed(), true);
				logEvent.error("Agent installed manually in collection Successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Agent installed manually in collection Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to install agent manually", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to install agent manually", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on storage to create the new repository$")
	public void User_Click_on_storage_to_create_the_new_repository() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(2).click();
				driver.findElementByName("_New").click();
				Assert.assertEquals(driver.findElementByAccessibilityId("RepositoryName").isDisplayed(), true);
				logEvent.error("Clicked on new Repository Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Clicked on new Repository Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to create new repo", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped creation of new repo", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Enter Name of the repository and provide the repository location$")
	public void User_Enter_Name_of_repo_and_provide_location() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				// inTrustDeploymentManagerComp.nameAndDescription();
				driver.findElementByAccessibilityId("RepositoryName").clear();
				driver.findElementByAccessibilityId("RepositoryName").sendKeys("myRepo" + random);
				driver.findElementByAccessibilityId("RepositoryFolder").sendKeys("C:\\myRepo" + random);
				Assert.assertEquals(driver.findElementByName("OK").isDisplayed(), true);
				logEvent.error("Provided Repository details Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Provided Repository details Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Not Entered Name and repo", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped Entered Name and location repo", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on Ok button and repository got created$")
	public void User_Click_ok_buton_repo_got_created() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("OK").click();
				stopFlow(2);
				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				logEvent.error("Repository created Successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Repository created Successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to create repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped Repository creation", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on storage to delete the repository$")
	public void User_select_the_repo_to_delete() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(2).click();
				driver.findElementByAccessibilityId("myRepo").click();
				stopFlow(2);
				Assert.assertEquals(driver.findElementByName("_Delete").isDisplayed(), true);
				logEvent.error("Selected Repository to delete");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Selected Repository to delete", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to delete repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped to delete repo", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on storage tab$")
	public void User_click_on_storage_tab() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(2).click();
				Assert.assertEquals(driver.findElementByName("_Delete").isDisplayed(), true);
				logEvent.error("Clicked on th storage tab");
				childTest.log(Status.PASS, MarkupHelper.createLabel("Clicked on th storage tab", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to Clicked on th storage tab", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped to Clicked on th storage tab", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^Selected repository gets deleted$")
	public void Selected_repository_gets_deleted() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("_Delete").click();
				driver.findElementByAccessibilityId("1").click();
				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				logEvent.error("Repository deleted successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Repository deleted successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to delete repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository deletion", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on storage to enable the forwarding option$")
	public void User_click_on_storage_to_enable_the_forwading_option() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(2).click();
				driver.findElementByName("Edit").click();
				driver.findElementByName("Enable forwarding").click();
				logEvent.error("Enable the forwarding option successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Enable the forwarding option successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to Enable the forwarding option", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped Enable the forwarding option", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User provided all the details and enable forwarding$")
	public void User_provided_all_the_details_and_enable_forwading() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByName("TCP")).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
						.build().perform();
				driver.findElementByName("UDP").click();
				driver.findElementByName("OK").sendKeys("127.0.0.1");
				driver.findElementByName("Apply").click();
				driver.findElementByName("_Delete").click();
				driver.findElementByAccessibilityId("1").click();
				logEvent.error("Repository deleted successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Repository deleted successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to delete repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository deletion", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Click on Collection tab to create the Syslog collection$")
	public void User_click_on_collection_tab_to_create_the_syslog_collection() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("_Delete").click();
				driver.findElementByAccessibilityId("1").click();
				logEvent.error("Repository deleted successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Repository deleted successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to delete repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository deletion", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Provide the syslog collection name and repository$")
	public void User_Provide_the_syslog_collection_name_and_repository() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("_Delete").click();
				driver.findElementByAccessibilityId("1").click();
				Assert.assertEquals(driver.findElementByName("_Next >").isDisplayed(), true);
				logEvent.error("Repository deleted successfully");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("Repository deleted successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to delete repository", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped repository deletion", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User verify all the links available on HomePage$")
	public void User_verify_all_the_links_avaialable_on_HomePage() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("specify the InTrust server or organization").click();
				stopFlow(1);
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						" 'specify the InTrust server or organization' link is working fine", ExtentColor.GREEN));
				driver.findElementByName("Cancel").click();
				driver.findElementByName("Collections").click();
				childTest.log(Status.PASS,
						MarkupHelper.createLabel(" 'Collections' link is working fine", ExtentColor.GREEN));
				List<WebElement> list = driver.findElementsByName("Quest.InTrustUI.ViewModels.Anchor");
				list.get(0).click();
				driver.findElementByName("Storage").click();
				list.get(0).click();
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("'Storage' link is working fine", ExtentColor.GREEN));
				driver.findElementByName("Help").click();
				stopFlow(2);
				childTest.log(Status.PASS, MarkupHelper.createLabel("'Help' link is working fine", ExtentColor.GREEN));
				Assert.assertEquals(driver.findElementByName("Help").isDisplayed(), true);
				logEvent.error("All the specified links are working fine");
				childTest.log(Status.PASS,
						MarkupHelper.createLabel("All the specified links are working fine", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel("Unable to verify links", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP, MarkupHelper.createLabel("Skipped verify links", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Go to the search folder and verfiy all the available folders$")
	public void User_go_to_the_search_folder_and_verify_all_the_available_folders() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Computers by collection").click();
				stopFlow(1);
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"'Computers by collection' folder is present with spefiied computers", ExtentColor.GREEN));
				driver.findElementByName("Computers not in a collection").click();
				childTest.log(Status.PASS,
						MarkupHelper.createLabel(
								" 'Computers not in a collection' folder is present with spefiied computers",
								ExtentColor.GREEN));
				driver.findElementByName("Syslog devices by collection").click();
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"'Syslog devices by collection' folder is present with spefiied computers", ExtentColor.GREEN));
				driver.findElementByName("Syslog devices not in a collection").click();
				stopFlow(2);
				childTest.log(Status.PASS,
						MarkupHelper.createLabel(
								"'Syslog devices not in a collection' folder is present with spefiied computers",
								ExtentColor.GREEN));
				Assert.assertEquals(driver.findElementByName("Syslog devices not in a collection").isDisplayed(), true);
				logEvent.error("Verified all the search folder functionality successfully");
				childTest.log(Status.PASS, MarkupHelper
						.createLabel("Verified all the search folder functionality successfully", ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL,
						MarkupHelper.createLabel("Unable to verify search folder functionality", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped verify search folder functionality", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Verify Name, Description & UNC Path under General section$")
	public void User_Verify_Name_Descrption_UNC_Path() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("General").isDisplayed();
				driver.findElementByName("_Name:").isDisplayed();
				driver.findElementByName("Default InTrust Audit Repository").isDisplayed();
				logEvent.info("Name is present under General Section");

				driver.findElementByName("_Description:").isDisplayed();
				driver.findElementByName(
						"A repository is a compressed file system-based storage used for long-term audit data retention. Pre-defined audit policies use the default Repository. You can create any number of your own Repositories")
						.isDisplayed();
				logEvent.info("Description is present under General Section");
				driver.findElementByName("UNC path to the repository _folder:").isDisplayed();
				driver.findElementByName("\\vjlabintr01\\InTrustRepository\\Default").isDisplayed();
				logEvent.info("UNC Path is present under General Section");
				stopFlow(1);
				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				childTest.log(Status.PASS,
						MarkupHelper.createLabel(
								"Verified Name, Description and UNC Path under General section successfully",
								ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel(
						"Unable to verify Name, descroption and path folder functionality", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped verify name folder functionality", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

	@When("^User Verify Managed by this InTrust Server & To access the repository use fields under Security section$")
	public void User_Verify_under_Security_Section() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Security").isDisplayed();
				driver.findElementByName("Managed by this InTrust server:").isDisplayed();
				driver.findElementByName("vjlabintr01").isDisplayed();
				logEvent.info("Verified Managed by this InTrust Server");

				driver.findElementByName("To access the repository, use").isDisplayed();
				driver.findElementByName("InTrust server account").isDisplayed();
				logEvent.info("Verified To access the repository use fields");
				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"Verified Managed by this InTrust Server & To access the repository use fields under Security section successfully",
						ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel(
						"Unable to verify Name, descroption and path folder functionality", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped verify name folder functionality", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}
	
	@When("^User Click on Edit to Enable Cleanup under Daily Cleanup section$")
	public void User_click_on_edit_to_enable_cleanup_under_daily_cleanup_section() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				driver.findElementByName("Security").isDisplayed();
				driver.findElementByName("Managed by this InTrust server:").isDisplayed();
				driver.findElementByName("vjlabintr01").isDisplayed();
				logEvent.info("Verified Managed by this InTrust Server");

				driver.findElementByName("To access the repository, use").isDisplayed();
				driver.findElementByName("InTrust server account").isDisplayed();
				logEvent.info("Verified To access the repository use fields");
				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"Verified Managed by this InTrust Server & To access the repository use fields under Security section successfully",
						ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel(
						"Unable to verify Name, descroption and path folder functionality", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped verify name folder functionality", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}
	
	@When("^User Select value in fields Keep repository data for and Start daily cleanup at and click Apply")
	public void User_select_value_in_fields_keep_repository_data_for_and_start_cleanup_at_and_click_apply() throws Exception {
		childTest = parentTest.createNode(StepDetails.stepName);
		if (!nextsteptobeSkipped) {
			try {
				hardWait(1);
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElementByClassName("ComboBox")).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
				.build().perform();
				driver.findElementByName("Day").click();
				driver.findElementByClassName("XamMaskedEditor").sendKeys("01:00 AM");
				driver.findElementByName("Apply").click();
				logEvent.info("Provided the values in fields respectively");

				Assert.assertEquals(driver.findElementByName("Default InTrust Audit Repository").isDisplayed(), true);
				childTest.log(Status.PASS, MarkupHelper.createLabel(
						"Selected value in fields Keep repository data for and Started daily cleanup at and click Apply successfully",
						ExtentColor.GREEN));
				// getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Passed"));
			} catch (NoSuchElementException e) {
				childTest.log(Status.FAIL, MarkupHelper.createLabel(
						"Unable to verify Name, descroption and path folder functionality", ExtentColor.RED));
				getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Failed"));
				nextsteptobeSkipped = true;
			}
		} else {
			childTest.log(Status.SKIP,
					MarkupHelper.createLabel("Skipped verify name folder functionality", ExtentColor.ORANGE));
			getResult(StepDetails.stepName, dataReadFromPropertyFile.readData("Skipped"));
		}

	}

}
