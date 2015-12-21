package co.uk.sainsbury.web.util;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebDriverHandlerTest {

	WebDriverHandler handler = new WebDriverHandler();
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() {
		handler.getDriver().close();
	}
	@Test
	public void testWebDriverHandler() {
		Assert.assertNotNull(handler.getDriver());
		
	}

}
