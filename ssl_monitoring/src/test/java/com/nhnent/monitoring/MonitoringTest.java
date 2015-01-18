package com.nhnent.monitoring;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MonitoringTest {
	
	private final String baseUrl = "https://www.ssllabs.com/ssltest/analyze.html?d=";
	
	private WebDriver driver;
	
	private static final int IMPLICITLY_WAIT_SECONDS = 300;
	private static final TimeUnit IMPLICITLY_WAIT_TIMEUNIT = TimeUnit.SECONDS;	

	@Before
	public void setUp()	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, IMPLICITLY_WAIT_TIMEUNIT);
	}
		
	@Test
	public void evaluateURL() {
		driver.get(baseUrl + "bill.hangame.com");
		WebElement rateElement = driver.findElement(By.xpath("//*[@id='rating']"));
		WebElement chartElement = driver.findElement(By.xpath("//*[@id='chart']"));
		System.out.println(rateElement.findElement(By.className("rating_a")).getText());
		List<WebElement> scores = chartElement.findElements(By.cssSelector("div.chartRow"));
		for(WebElement elem : scores) {
			System.out.println(elem.findElement(By.cssSelector("div.chartValue")).getText());
		}
		driver.close();
	}
}
