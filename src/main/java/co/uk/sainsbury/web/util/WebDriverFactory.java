package co.uk.sainsbury.web.util;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/***
 * WebDirver Factory class to create a new WebDriver
 * 
 * @author ABHISHEK
 * 
 */
public class WebDriverFactory {

	public EventFiringWebDriver create() {
		FirefoxDriver firefoxDriver = new FirefoxDriver();
		return new EventFiringWebDriver(firefoxDriver);
	}

}
