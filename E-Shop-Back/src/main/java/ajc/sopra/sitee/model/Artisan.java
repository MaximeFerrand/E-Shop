package ajc.sopra.sitee.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("artisan")
public class Artisan extends Supplier{

	public Artisan() {
	}
	
	public Artisan(String company, List<Product> products) {
		super(company, products, "Artisan");
	}


	
	
}
