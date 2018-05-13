package org.task.webtable;

import java.util.concurrent.TimeUnit;

import org.task.resources.NTESPages;
import org.task.resources.Utilities;

public class MainScript extends Utilities{

	public static void main(String[] args) {
		Utilities.browserOpen("Chrome");
		Utilities.launchURL("https://enquiry.indianrail.gov.in/mntes/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		NTESPages.navToTrainBetweenStationAndSearching("Chennai MAS", "Coimbatore CBE");
		NTESPages.retrieveTrainNo("23:50");
		Utilities.quitBrowser();

	}

}
