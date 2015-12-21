package co.uk.sainsbury.web.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import co.uk.sainsbury.web.data.ProductData;

public class ProductWebpageScraperTest {

	private ProductWebpageScraper scraper = new ProductWebpageScraper();
	private static final String URL = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-white-flesh-nectarines--ripe---ready-x4";
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
	driver = scraper.getWebDriverHelper().getDriver();
	}
	@After
	public void tearDown() {
	
	}
	@Test
	public void parseProductDetailsReturnsTitle() {
		ProductData productData = scraper.parseProductDetails(URL);
		Assert.assertNotNull(productData);
		Assert.assertEquals("Sainsbury's White Flesh Nectarines, Ripe & Ready x4", productData.getTitle());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void parseProductDetailsReturnsException(){
		scraper.parseProductDetails(null);
	}

}
