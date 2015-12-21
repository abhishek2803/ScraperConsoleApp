package co.uk.sainsbury.web.data;

import java.io.Serializable;

/***
 * Data class to hold individual product
 * @author ABHISHEK
 *
 */
public class ProductData implements Serializable {

	private String title;	
	private String size;	
	private Double unitPrice;	
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
