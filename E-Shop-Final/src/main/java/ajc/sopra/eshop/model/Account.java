package ajc.sopra.eshop.model;


import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//DTYPE => DiscriminatorType
//@DiscriminatorColumn(name = "type_account",columnDefinition = "ENUM('admin','user', 'supplier')")
@Table(name="account")
public class Account implements UserDetails{

	@JsonView(JsonViews.Common.class)
	@Id //OBLIGATOIRE
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SEMI-OBLIGATOIRE pour de l'auto-increment
	protected Integer id;
	@Email
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	//@JsonView(JsonViews.CompteWithClient.class)
	public String getRole() {
		return getAuthorities().stream().findFirst().get().toString();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String role=null;
		if(this.getClass().getName().equals("Admin"))  {
			role="ROLE_ADMIN";
		}else if (this.getClass().getName().equals("User")){
			role="ROLE_USER";
		}
		else {
			role="ROLE_SUPPLIER";}
	
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	
	
	
	
}