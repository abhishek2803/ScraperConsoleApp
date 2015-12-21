package co.uk.sainsbury.web.service;

/**
 * Load and parse a given Url and return object T
 * @author ABHISHEK
 *
 * @param <T> - return type object
 */
public interface Scraper<T> {

	public T scrape(String url);
}
