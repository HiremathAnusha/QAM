package inTrustReporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import io.appium.java_client.windows.WindowsElement;

public abstract class ReusableLibrary {
	protected Logger logEvent = Logger.getLogger(getClass().getSimpleName());

	/**
	 * Abstract functions to be declared in child class
	 */

	public abstract void hardWait();

	public abstract boolean explicitWaitforElementClickable(WindowsElement element);

	public abstract boolean explicitWaitforElementVisible(WindowsElement element);

	public abstract void clickObject(WindowsElement element);

	public abstract void selectDatabyVizText(WindowsElement element, String data);

	public abstract void fillData(WindowsElement element, String data);

	public abstract String getScreenshotWhereRequired(String testName);

	public abstract void handleAlert(boolean action);

	public abstract void monthSelectorfromCalendar(String Date, WindowsElement calendarMonthYear,
			WindowsElement calendarMonthSwipeButton);

	public abstract void dateSelector(String exactDate, List<WindowsElement> datetoSelect);

	public abstract void typeStringintoHotelSearchBox(String string, WindowsElement searchBox, String browser);

	public abstract void scrolltoViewWindowsElement(WindowsElement element);

	public abstract void clickElementUsingJavaScript(WindowsElement element);

	public abstract void keyboardAction(CharSequence Key, int keycode);

	/**
	 * Function to return the Current date timestamp as a string
	 * 
	 * @return
	 */
	static String getCurrentDateandTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss a");
		Date date = new Date();
		String dateString = dateFormat.format(date);

		return dateString;
	}

	/**
	 * function to create directory
	 * 
	 * @param directoryName
	 * @return
	 */
	public File createDirectory(String directoryName) {

		File directoryfortheDay = new File(directoryName);

		if (!directoryfortheDay.exists()) {
			directoryfortheDay.mkdir();
		}

		else {
			/**
			 * Do nothing
			 */
		}

		return directoryfortheDay;
	}

	/**
	 * Function to return exact class name to feed into excel for test data finding
	 * 
	 * @param className
	 * @return
	 */

	public String classNameSplit(String className) {

		String actualclass[] = className.split("\\.");
		return actualclass[3];
	}

	/**
	 * Function to return exact class name to feed into excel for test data finding
	 * 
	 * @param className
	 * @return
	 */

	public String testDataSeperator(String globalTestData) {

		String actualTestdata[] = globalTestData.split("#");
		return actualTestdata[1];
	}

	/**
	 * Reg Exp functions to facilitate reporting utilities
	 * 
	 * @param test
	 * @return
	 */

	public static boolean ifStringhasSpace(String test) {
		boolean containSpace = false;
		if (test.contains(" ")) {
			containSpace = true;
		}
		return containSpace;
	}

	public static String scenarioNameforTData(String scenarioName) {
		String revisedScenarioName = null;
		if (scenarioName.contains(" ")) {
			revisedScenarioName = scenarioName.replaceAll("\\s+", "");
		}
		return revisedScenarioName;
	}

	public static String featrNmeReportCreatn(String scenarioID) {
		String featureFolder[] = scenarioID.split("\\;");
		String aclFetrNme = featureFolder[0].replaceAll("-", "_");
		return aclFetrNme;
	}

	public static String stpNmeScrnshtCreatn(String actualStepName) {
		String revisedStepName = null;
		if (actualStepName.contains(" ")) {
			revisedStepName = actualStepName.replace('"', ' ');
		}
		if (revisedStepName.contains(" ")) {
			revisedStepName = revisedStepName.replaceAll("\\s+", "_");
		}
		return revisedStepName;
	}

//	public static String categoryConfirm(String scenarioID, String rawscenarioName) {
//		String featureFolder[] = scenarioID.split("\\;");
//		String aclFetrNme = featureFolder[0].replaceAll("-", " ").toUpperCase();
//		String scenarioName = rawscenarioName.toUpperCase();
//
//		if (aclFetrNme.contains("InTrust")) {
//			if (scenarioName.contains("Deployment")) {
//				return new String("InTrust Deployment Manger");
//			} else if (scenarioName.contains("InTrust Manager")) {
//				return new String("InTrust Manager");
//			} else if (scenarioName.contains("Repository Viewer")) {
//				return new String("InTrust Repository Viewer");
//			} else {
//				return new String("No Category Selected");
//			}
//		}
//		return scenarioName;
//	}

	public static String categoryConfirm(String rawscenarioName) {
		String scenarioName = rawscenarioName.toUpperCase();

		if (scenarioName.contains("InTrust")) {
			if (scenarioName.contains("Deployment")) {
				return new String("InTrust Deployment Manger");
			} else if (scenarioName.contains("InTrust Manager")) {
				return new String("InTrust Manager");
			} else if (scenarioName.contains("Repository Viewer")) {
				return new String("InTrust Repository Viewer");
			} else {
				return new String("No Category Selected");
			}
		}
		return scenarioName;
	}

	protected String getCurrentMonth() {
		Calendar mCalendar = Calendar.getInstance();
		return (mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
	}

	protected String getCurrentYear() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		return String.valueOf(year);
	}

	protected String calenderRangeinUI(int calenderStartIndex) {
		if (calenderStartIndex == 1) {
			return String.valueOf(calenderStartIndex);
		} else {
			return (String.valueOf(calenderStartIndex + (calenderStartIndex - 2)) + ","
					+ String.valueOf(calenderStartIndex + (calenderStartIndex - 1)));
		}

	}

	protected String calenderRangeinEmplUI(int calenderStartIndex) {
		return (String.valueOf(calenderStartIndex + (calenderStartIndex - 2)));
	}

}
