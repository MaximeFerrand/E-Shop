package ajc.sopra.eshop.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Account{
	
	
	
	public Admin(String login, String password) {
		super(login, password);
	}

	public Admin() {
		}
	
	
}