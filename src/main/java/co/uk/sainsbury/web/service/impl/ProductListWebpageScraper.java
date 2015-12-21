package co.uk.sainsbury.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import co.uk.sainsbury.web.constant.ApplicationConstants;
import co.uk.sainsbury.web.data.ProductData;
import co.uk.sainsbury.web.data.ProductListData;
import co.uk.sainsbury.web.service.Scraper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * Scraper for Product Listing Page
 * 
 * @author ABHISHEK
 *
 */
@Component
public class ProductListWebpageScraper extends ProductWebpageScraper
		implements Scraper<String> {

	
	private static final String ID_PRODUCT_LISTER_UL = "//*[@id=\"productLister\"]/ul";
	
	public String scrape(String url) {
		ObjectMapper mapper = new ObjectMapper();
		ProductListData productListDetails = parseProductListDetails(url);
		if(mapper.canSerialize(ProductListData.class)) {
			try {
				return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(productListDetails);
			} catch (JsonProcessingException e) {
				System.out.println("Error processing Json " + e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}
	
	protected ProductListData parseProductListDetails(final String url){
		WebDriver driver = getWebDriverHelper().getDriver();
		getWebDriverHelper().navigateBrowserTo(url);
		//wait until page url gets loaded completely
		WebElement webElement = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath(ID_PRODUCT_LISTER_UL)));
		//look for elements with links
		List<WebElement> webElements = driver.findElements(By.xpath(ApplicationConstants.XPATH_PLP));
		//get the list of links		
		final List<String> productUrls = getAllProductUrls(webElements);
		ProductListData productListData = new ProductListData();
		double totalPrice = 0.0;
		for (String productUrl : productUrls) {
			//load each link and parse product details
			ProductData product = parseProductDetails(productUrl); 
			productListData.getResults().add(product);
			totalPrice += product.getUnitPrice(); 
		}
		       		
		productListData.setTotal(totalPrice);
		return productListData;
	}
	
	private List<String> getAllProductUrls(List<WebElement> findElements) {
		final List<String> allLinks = new ArrayList<String>(findElements.size());
		for (final WebElement webElement : findElements) {
			final String href = webElement.getAttribute(ApplicationConstants.ATTR_HREF);
			if (null != href) {
				allLinks.add(href);
			}
		}
		return allLinks;
	}	

}
