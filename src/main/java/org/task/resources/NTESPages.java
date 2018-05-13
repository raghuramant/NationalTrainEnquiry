package org.task.resources;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NTESPages extends Utilities {
	// Actions act = new Actions(driver);
	public static void navToTrainBetweenStationAndSearching(String fromStation, String toStation) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='navbar']/ul/li[4]/a")).click();

		driver.findElement(By.id("jFromStationInput")).sendKeys(fromStation, Keys.DOWN, Keys.ENTER);
		driver.findElement(By.id("jToStationInput")).sendKeys(toStation, Keys.DOWN, Keys.ENTER);
		driver.findElement(By.name("find")).click();

	}

	public static void retrieveTrainNo(String time) {
		int requiredDataCell = 0, requiredDataRow = 0;
		WebElement tbody = driver.findElement(By.xpath("//table[4]/tbody"));
		List<WebElement> tr = tbody.findElements(By.tagName("tr"));
		List<WebElement> tdata;
		for (int i = 0; i < tr.size(); i++) {
			tdata = tr.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < tdata.size(); j++) {
				// System.out.println("i = "+i+" j "+j+" "+
				// tdata.get(j).getText());
				// System.out.println(tdata.get(j).getText());
				if (tdata.get(j).getText().contains(time)) {
					requiredDataCell = j;
					requiredDataRow = i - 1;
					System.out.println("The train Number and Name : "
							+ tr.get(requiredDataRow).findElements(By.tagName("td")).get(0).getText() + " starts at "
							+ time);

				}
			}

		}
		// System.out.println(tr.get(requiredDataRow).getText());
		//System.out.println("The train Number and Name : "
		//		+ tr.get(requiredDataRow).findElements(By.tagName("td")).get(0).getText() + " starts at " + time);

	}
}
