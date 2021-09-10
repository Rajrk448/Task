package org.cts.test.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();

		List<WebElement> tRow = driver.findElements(By.tagName("tr"));

		for (int i = 0; i < tRow.size(); i++) {
			WebElement row = tRow.get(i);
			List<WebElement> tData = row.findElements(By.tagName("td"));

			for (int j = 0; j < tData.size(); j++) {
				WebElement data = tData.get(j);
				String text = data.getText();
				System.out.println(text);
			}

		}
	}
}