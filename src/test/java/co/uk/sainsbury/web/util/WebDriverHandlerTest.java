package co.uk.sainsbury.web.util;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverHandlerTest {

	private WebDriverHandler handler = new WebDriverHandler();
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = handler.getDriver();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testWebDriverHandler() {
		Assert.assertNotNull(driver);

	}

}
