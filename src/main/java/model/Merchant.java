package model;

import java.util.List;

public class Merchant extends Supplier{

	public Merchant() {
	}
	
	public Merchant(String company, List<Product> products) {
		super(company, products);
	}

}
