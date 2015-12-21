package co.uk.sainsbury.web.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverHelperTest {
	
	private WebDriverHelper helper = new WebDriverHelper();
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = helper.getDriver();
	}

	@Test
	public void testGetDriverReturnsAnInstance() {
		Assert.assertNotNull(driver);
	}

	@Test
	public void testGetDriverReturnsTheSameInstance() {
		Assert.assertNotNull(driver);
		WebDriver driver2 = helper.getDriver();
		Assert.assertSame(driver, driver2);
	}

	
	
	@Test
	public void testNavigateBrowserTo() {
		helper.navigateBrowserTo("http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-white-flesh-nectarines--ripe---ready-x4");
		Assert.assertNotNull(helper.getDriver().getCurrentUrl());
	}

	@Test
	public void testIsDriverAlive() {
		Assert.assertTrue(helper.isDriverAlive());
	}

}
