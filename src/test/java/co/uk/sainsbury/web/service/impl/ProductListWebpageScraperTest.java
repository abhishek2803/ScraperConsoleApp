package co.uk.sainsbury.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

import co.uk.sainsbury.web.data.ProductData;
import co.uk.sainsbury.web.data.ProductListData;
import co.uk.sainsbury.web.util.WebDriverHelper;

@ContextConfiguration()
@RunWith(JUnit4.class)
public class ProductListWebpageScraperTest {
	public static final String PRODUCT_LIST_URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0";

	private ProductListWebpageScraper productListWebpageScraper = new ProductListWebpageScraper();
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver = productListWebpageScraper.getWebDriverHelper().getDriver();
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testScrape() {
		String jsonProductList = productListWebpageScraper
				.scrape(PRODUCT_LIST_URL);
		Assert.assertNotNull(jsonProductList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseProductListDetails() {
		productListWebpageScraper.scrape(null);
	}

	@Test
	public void testGetWebDriverHelper() {
		
		Assert.assertNotNull(driver);
		
	}

	private ProductListData populateProductData() {
		ProductListData data = new ProductListData();
		List<ProductData> results = new ArrayList<ProductData>();
		ProductData product = new ProductData();
		product.setSize("100");
		product.setDescription("description");
		product.setTitle("title");
		product.setUnitPrice(2.0);
		results.add(product);
		data.setResults(results);
		data.setTotal(10.0);
		return data;
	}
}
