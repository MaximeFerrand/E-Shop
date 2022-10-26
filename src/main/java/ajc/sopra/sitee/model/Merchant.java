package ajc.sopra.sitee.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("merchant")
public class Merchant extends Supplier{

	public Merchant() {
	}
	
	public Merchant(String company, List<Product> products) {
		super(company, products);
	}

}
