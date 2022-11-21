package ajc.sopra.eshop.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.eshop.model.JsonViews.UserWithOrderAndAdress;

@Entity

@Table(name = "user")
public class User extends Account {
	@JsonView(JsonViews.Common.class)
	@Column(length = 30, nullable = false)
	protected String lastname;
	@JsonView(JsonViews.Common.class)
	@Column(length = 30, nullable = false)
	protected String firstname;
	
	/*
	@OneToMany(mappedBy = "user")
	private List<BasketDetail> basketDetails = new ArrayList();*/
	//@JsonView(JsonViews.Common.class)
	//private Boolean isValidated;

	//private static double TotalPrixValidated;
	@JsonView(JsonViews.UserWithOrderAndAdress.class)
	@OneToMany(mappedBy = "user")
	private List<Order> orders = new ArrayList();

	/*
	public double PrixTotalBasketDetails(Boolean isValidated, double doublebasketDetails) {

		if (isValidated) {

			for (BasketDetail b : basketDetails) {
				TotalPrixValidated += b.getQuantity() * b.getProduct().getPrice();

			}
		} else {
			TotalPrixValidated = 0;
		}
		return (TotalPrixValidated);
	}

	public List<BasketDetail> getBasketDetails() {
		return basketDetails;
	}

	public void setBasketDetails(List<BasketDetail> basketDetails) {
		this.basketDetails = basketDetails;
	}*/
	@JsonView(JsonViews.Common.class)
	protected int discount;
	@JsonView(JsonViews.UserWithOrderAndAdress.class)
	@ElementCollection()
	protected Set<Adress> adresses = new HashSet();
	
	public User(String login, String Password) {
		super(login, Password);
	}

	public User(String name, String firstname, int discount, Set<Adress> adresses) {
		super();
		this.lastname = name;
		this.firstname = firstname;
		this.discount = discount;
		this.adresses = adresses;
	}

	


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User() {

	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String name) {
		this.lastname = name;
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
		return "User [lastname=" + lastname + ", firstname=" + firstname + ", discount=" + discount + ", id=" + id + ", login="
				+ login + ", password=" + password + "]";
	}

	public double discountBasket(double priceBasket) {

		double d = 0;
		return d;
	}

	public double discountSubscription(String subName, double x) {
		return x;
	}

}
