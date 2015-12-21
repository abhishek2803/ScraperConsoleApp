package co.uk.sainsbury;


import co.uk.sainsbury.web.constant.ApplicationConstants;
import co.uk.sainsbury.web.service.Scraper;
import co.uk.sainsbury.web.service.impl.ProductListWebpageScraper;

/**
 * Main class to run the application
 * @author ABHISHEK
 *
 */

public class ScraperApp 
{
	
	public static void main(String[] args)  {		
		Scraper<String> productListWebpageScraper = new ProductListWebpageScraper();
		System.out.println("Request recieved ! In progress, Please wait.... ");
		System.out.println(productListWebpageScraper.scrape(ApplicationConstants.PRODUCT_LIST_URL));
		System.out.println("Request Processing Over.");
	}
}
