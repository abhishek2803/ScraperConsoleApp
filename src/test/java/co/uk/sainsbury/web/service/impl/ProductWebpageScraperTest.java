package co.uk.sainsbury.web.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.uk.sainsbury.web.data.ProductData;

public class ProductWebpageScraperTest {

	private ProductWebpageScraper scraper = new ProductWebpageScraper();
	private static final String URL = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-white-flesh-nectarines--ripe---ready-x4";
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() {
		scraper.getWebDriverHelper().getDriver().close();
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
