package co.uk.sainsbury;


import co.uk.sainsbury.web.constant.WebConstants;
import co.uk.sainsbury.web.service.Scraper;
import co.uk.sainsbury.web.service.impl.ProductListWebpageScraper;



public class ScraperMain 
{
	
	public static void main(String[] args)  {		
		Scraper<String> productListWebpageScraper = new ProductListWebpageScraper();
		System.out.println("Request recieved ! In progress, Please wait.... ");
		System.out.println(productListWebpageScraper.scrape(WebConstants.PRODUCT_LIST_URL));
		System.out.println("Request Processing Over.");
	}
}
