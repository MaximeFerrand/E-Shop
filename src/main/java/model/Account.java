package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//DTYPE => DiscriminatorType
//@DiscriminatorColumn(name = "type_personne",columnDefinition = "ENUM('customer','supplier')")
@Table(name="account")
public abstract class Account {

	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	protected Integer id;
	@Column(length = 30, nullable = false)
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

	public void setId(Integer id) {
		this.id = id;
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

	public Account(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	
	
	
}