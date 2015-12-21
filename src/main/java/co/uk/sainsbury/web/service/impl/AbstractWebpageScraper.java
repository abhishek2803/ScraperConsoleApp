package co.uk.sainsbury.web.service.impl;

import co.uk.sainsbury.web.util.WebDriverHelper;

public abstract class AbstractWebpageScraper {

	private WebDriverHelper webDriverHelper = new WebDriverHelper();
	
	
	public WebDriverHelper getWebDriverHelper() {
		return webDriverHelper;
	}
	
}
