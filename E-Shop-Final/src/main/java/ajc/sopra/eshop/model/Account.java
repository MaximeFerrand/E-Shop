package ajc.sopra.eshop.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//DTYPE => DiscriminatorType
//@DiscriminatorColumn(name = "type_account",columnDefinition = "ENUM('admin','user', 'supplier')")
@Table(name="account")
public abstract class Account {

	@JsonView(JsonViews.Common.class)
	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	protected Integer id;
	@JsonView(JsonViews.Common.class)
	@Column(length = 30, nullable = false,unique = true)
	protected String login;
	@JsonView(JsonViews.Common.class)
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