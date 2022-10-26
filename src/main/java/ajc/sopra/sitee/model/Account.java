package ajc.sopra.sitee.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//DTYPE => DiscriminatorType
//@DiscriminatorColumn(name = "type_account",columnDefinition = "ENUM('admin','user', 'supplier')")
@Table(name="account")
public abstract class Account {

	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	protected Integer id;
	@Column(length = 30, nullable = false,unique = true)
	protected String login;
	@Column(length = 30, nullable = false)
	protected String password;
	
	public Account() {
		
	}
	
	public Account(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}