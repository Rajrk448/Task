package org.cts.test.login;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		WebElement btnClose = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		btnClose.click();

		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys("iphone 12", Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement prdIphone = driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 (Black, 128 GB)']"));
		prdIphone.click();

		String par = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();

		for (String x : all) {
			if (!par.equals(x))
			{
				driver.switchTo().window(x);

			}

		}

		WebElement findElement = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		findElement.click();
	}
}