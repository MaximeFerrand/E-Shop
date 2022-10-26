package ajc.sopra.sitee.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity


@Table(name="user")
public abstract class User extends Account {

	@Column(length=30,nullable = false)
	protected String name;
	@Column(length=30,nullable = false)
	protected String firstname;
	@OneToMany(mappedBy = "user")
	private List<BasketDetail> basketDetails= new ArrayList();
	
	public List<BasketDetail> getBasketDetails() {
		return basketDetails;
	}

	public void setBasketDetails(List<BasketDetail> basketDetails) {
		this.basketDetails = basketDetails;
	}

	protected int discount;

	@ElementCollection
	protected Set<Adress> adresses= new HashSet();

	public User(String name, String firstname, int discount, Set<Adress> adresses) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.discount = discount;
		this.adresses= adresses;
	}

	public User() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Set<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adress> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", firstname=" + firstname + ", discount=" + discount + ", id=" + id + ", login="
				+ login + ", password=" + password + "]";
	}
	
	public double discountBasket(double priceBasket) {
		
		double d=0;
		return d;
	}
	
public double discountSubscription(String subName, double x ) {
		return x;
	}
	
	
}
