package model;

import java.util.List;

public class BasketDetail {

	private Integer quantity;
	private List<Product> products;
	
	public BasketDetail() {
	}
	
	
	public BasketDetail(Integer quantity, List<Product> products) {
		this.quantity = quantity;
		this.products = products;
	}



	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
