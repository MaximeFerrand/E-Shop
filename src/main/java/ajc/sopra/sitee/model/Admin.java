package ajc.sopra.sitee.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Admin extends Account{
	
	
	
	public Admin(String login, String password) {
		super(login, password);
	}

	public Admin() {
		}
	
	
}