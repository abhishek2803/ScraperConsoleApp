package co.uk.sainsbury.web.service.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.util.StringUtils;

import co.uk.sainsbury.web.constant.ApplicationConstants;
import co.uk.sainsbury.web.data.ProductData;

import com.google.common.base.Preconditions;
/***
 * Scrape Product Webpage
 * @author ABHISHEK
 *
 */
public class ProductWebpageScraper extends AbstractWebpageScraper {

	
			
	public ProductData parseProductDetails(String url) {
		Preconditions.checkArgument(StringUtils.hasText(url));
		getWebDriverHelper().navigateBrowserTo(url);
		ProductData data = new ProductData();

		// Title
		WebElement title = getWebDriverHelper()
				.getDriver()
				.findElement(
						By.cssSelector(ApplicationConstants.PRODUCT_TITLE));
		data.setTitle(title.getText());
		// size
		System.out.println(getWebDriverHelper().getDriver().getPageSource());
		int length = getWebDriverHelper().getDriver().getPageSource()
				.getBytes().length;
		data.setSize(String.valueOf(length / 1024) + ApplicationConstants.STRING_KB);
		// unit price
		WebElement unitPrice = getWebDriverHelper().getDriver().findElement(
				By.className(ApplicationConstants.PRICE_PER_UNIT));
		data.setUnitPrice(Double.valueOf(StringUtils.replace(unitPrice
				.getText().substring(1), ApplicationConstants.UNIT, "")));
		// description
		WebElement description = getWebDriverHelper().getDriver().findElement(
				By.className(ApplicationConstants.PRODUCT_DESCRIPTION));
		data.setDescription(description.getText());
		return data;
	}
}
