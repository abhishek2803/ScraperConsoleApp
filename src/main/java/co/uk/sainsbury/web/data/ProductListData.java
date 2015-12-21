package co.uk.sainsbury.web.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * Data object to hold Collection of products
 * @author ABHISHEK
 *
 */
public class ProductListData implements Serializable {

	private List<ProductData> results = new ArrayList<ProductData>();
	private Double total;
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<ProductData> getResults() {
		return results;
	}
	public void setResults(List<ProductData> results) {
		this.results = results;
	}
}
