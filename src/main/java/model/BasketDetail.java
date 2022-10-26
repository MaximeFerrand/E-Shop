package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
public class BasketDetail {

	@Column(nullable=false)
	private Integer quantity;
	
	
	@Column(nullable=false)
	@OneToOne
	private User user;
	
	@OneToOne
	@Column(nullable=false)
	private Product product;
	
	public BasketDetail() {
	}
	
	
	public BasketDetail(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}



	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
