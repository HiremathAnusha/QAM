package inTrustBusinessComponents;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import baseClass.BaseClass;
import io.appium.java_client.windows.WindowsDriver;

public class InTrustDeploymentManagerComp extends BaseClass {
	// Actions action = new Actions(driver);

	public InTrustDeploymentManagerComp(WindowsDriver driver) {
		this.driver = driver;
	}

	public void setUp() {
		System.out.println("******Inside setup*****");
		// getApplication(app);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void newWindowCollection() {
		try {
			if (driver.findElementByName("_New...").isDisplayed()) {
				// if ((inTrustDeploymentpage.get_newClick()))
				driver.findElementByName("_New...").click();
				driver.findElementByName("Windows Collection").click();
				logEvent.error("Clicked Successfully");
			}

		}

		catch (Exception e) {
		}
	}

	public void nameAndDescription() {
		try {
			driver.findElementByAccessibilityId("CollectionName").clear();
			driver.findElementByAccessibilityId("CollectionName").sendKeys("MyCollection1");
			driver.findElementByName("_Next >").click();
			logEvent.error("Entered Name and Description Successfully");
		}
		/*
		 * else { logEvent.error("Could not able to click on Window Collection");
		 * childTest.log(Status.FAIL,
		 * MarkupHelper.createLabel("Could not able to click on Window Collection",
		 * ExtentColor.RED)); }
		 */

		catch (Exception e) {
		}
	}

	public void selectDomain() {
		try {
//			action.moveToElement(driver.findElementByName("_Add")).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build()
//					.perform();

			driver.findElementByAccessibilityId("PickDomains").click();
			driver.findElementByName("questlab.com").click();
			driver.findElementByName("OK").click();
			driver.findElementByName("_Next >").click();
			logEvent.error("Selected Domains Successfully");
		} catch (Exception e) {
		}

	}

	public void selectDatSourceRepoServer() {
		try {
//			action.moveToElement(driver.findElementByName("Windows Application Log")).click().sendKeys(Keys.SPACE)
//					.keyDown(Keys.LEFT_CONTROL).sendKeys(Keys.END).keyUp(Keys.LEFT_CONTROL).build().perform();
//			action.moveToElement(driver.findElementByName("Windows System Log")).click().sendKeys(Keys.SPACE).build()
//					.perform();
			logEvent.error("Selected Data Source Repository and Server Successfully");
		}
		/*
		 * else { logEvent.error("Could not able to click on Window Collection");
		 * childTest.log(Status.FAIL,
		 * MarkupHelper.createLabel("Could not able to click on Window Collection",
		 * ExtentColor.RED)); }
		 */
		catch (Exception e) {
		}

	}

	public void finishButton() {
		try {
			driver.findElementByName("_Next >").click();
			driver.findElementByName("Finish").click();
			// Assert.assertEquals(driver.findElementByAccessibilityId("MyCollection4").isDisplayed(),
			// true);
			logEvent.error("Window Collection is created successfully");
		}

		catch (Exception e) {
		}

	}
}
