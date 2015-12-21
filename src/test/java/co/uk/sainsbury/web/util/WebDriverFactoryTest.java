package co.uk.sainsbury.web.util;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactoryTest {

	WebDriverFactory factory = new WebDriverFactory();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() throws Exception {
		EventFiringWebDriver driver = null;
		try{
		driver = factory.create();
		Assert.assertNotNull(driver);
		}
		finally{
			driver.quit();	
		}
		
	}

}
