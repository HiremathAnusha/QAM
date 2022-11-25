package inTrustReporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManagerAssociateFunctions {

	/**
	 * Function to return the Current date as a string
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
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

	public static File createDirectory(String directoryName) {

		File directoryfortheDay = new File(directoryName);

		if (!directoryfortheDay.exists()) {
			directoryfortheDay.mkdir();
		}

		else {
			/**
			 * Do Nothing
			 */
		}

		return directoryfortheDay;
	}

	/**
	 * Function to return the Current date and time
	 * 
	 * @return
	 */
	public static String getCurrentDateandTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss a");
		Date date = new Date();
		String dateString = dateFormat.format(date);

		return dateString;
	}

	/**
	 * Function to check empty folder
	 * 
	 * @return
	 */

	public static boolean checkEmptyFolder(File folderPath) {
		if (folderPath.isDirectory()) {
			if (folderPath.list().length > 0) {

				System.out.println("Directory is not empty!");
				return false;

			} else {

				System.out.println("Directory is empty!");
				return true;

			}
		} else {

			System.out.println("This is not a directory");
			return true;
		}
	}
}
