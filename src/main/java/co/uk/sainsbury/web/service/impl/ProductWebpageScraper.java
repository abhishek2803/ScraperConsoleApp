package co.uk.sainsbury.web.service.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import co.uk.sainsbury.web.data.ProductData;
import co.uk.sainsbury.web.util.WebDriverHelper;

import com.google.common.base.Preconditions;
/***
 * Scrape Product Webpage
 * @author ABHISHEK
 *
 */
public class ProductWebpageScraper extends AbstractWebpageScraper {

	private static final String STRING_KB = " kb";
	private static final String UNIT = "/unit";
	private static final String PRODUCT_TITLE = "#content > div.section.productContent > div.pdp > div > div.productTitleDescriptionContainer > h1";
	private static final String PRICE_PER_UNIT = "pricePerUnit";
	private static final String PRODUCT_DESCRIPTION = "productText";
			
	public ProductData parseProductDetails(String url) {
		Preconditions.checkArgument(StringUtils.hasText(url));
		getWebDriverHelper().navigateBrowserTo(url);
		ProductData data = new ProductData();

		// Title
		WebElement title = getWebDriverHelper()
				.getDriver()
				.findElement(
						By.cssSelector(PRODUCT_TITLE));
		data.setTitle(title.getText());
		// size
		int length = getWebDriverHelper().getDriver().getPageSource()
				.getBytes().length;
		data.setSize(String.valueOf(length / 1024) + STRING_KB);
		// unit price
		WebElement unitPrice = getWebDriverHelper().getDriver().findElement(
				By.className(PRICE_PER_UNIT));
		data.setUnitPrice(Double.valueOf(StringUtils.replace(unitPrice
				.getText().substring(1), UNIT, "")));
		// description
		WebElement description = getWebDriverHelper().getDriver().findElement(
				By.className(PRODUCT_DESCRIPTION));
		data.setDescription(description.getText());
		return data;
	}
}
