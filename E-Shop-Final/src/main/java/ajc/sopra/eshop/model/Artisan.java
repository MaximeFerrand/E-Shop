package ajc.sopra.eshop.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("artisan")
public class Artisan extends Supplier{
		
	public Artisan() {
	}
	
	public Artisan(String login, String password, String company) {
		super(login, password, company, "Artisan"); //"Artisan" ne fonctionne pas =null
	}


	
	
}
