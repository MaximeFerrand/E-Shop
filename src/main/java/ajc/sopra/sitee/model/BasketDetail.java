package ajc.sopra.sitee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class BasketDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private Integer quantity;
	
	
	@Column(nullable=false)
	@ManyToOne
	private User user;
	
	@ManyToOne
	@Column(nullable=false)
	private Product product;
	
	private static double TotalPrix;
	
	/*
	totalPrix(product ,quantity): double
	TotalPrix:static*/
	public double totalPrix(Product product ,double quantity) {
		TotalPrix= product.getprice()*quantity;
		return TotalPrix;
	}
	
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
