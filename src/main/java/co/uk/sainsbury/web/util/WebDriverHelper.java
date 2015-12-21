package co.uk.sainsbury.web.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	private static final int TIME_OUT_IN_SECONDS = 30;

	private static WebDriver driver;

	public WebDriver getDriver() {
		if (isDriverAlive())
			return driver;
		try {
			driver = new WebDriverHandler();
			return driver;
		} catch (Exception e) {
			System.err.println("Failed to create driver instance."
					+ e.getMessage());
		}
		return null;
	}

	
	public void navigateBrowserTo(String url) {
		getDriver().get(url);
	}
	
	public boolean isDriverAlive() {
		return driver != null;
	}

}
