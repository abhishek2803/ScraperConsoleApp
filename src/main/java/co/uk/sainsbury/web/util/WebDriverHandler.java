package co.uk.sainsbury.web.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/***
 * Single point of contact to manage Web driver. This driver is a shared and will quit when JVM quits
 * @author ABHISHEK
 *
 */
public class WebDriverHandler extends EventFiringWebDriver {

	
	private static final WebDriver driver = new WebDriverFactory().create();

    public WebDriverHandler() {
        super(driver);
    }

	public static WebDriver getDriver() {
		return driver;
	}
 
   }
