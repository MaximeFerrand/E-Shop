package model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Artisan extends Supplier{

	public Artisan() {
	}
	
	public Artisan(String company, List<Product> products) {
		super(company, products);
	}


	
	
}
