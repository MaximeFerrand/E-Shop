package ajc.sopra.sitee.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order detail")

public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable= false)
	private int quantity;
	
	@OneToOne
	private Product product;
	
	@Embedded
	private Review review;
	
	public OrderDetail() {
		
	}
	
	
	public OrderDetail( Integer quantity, Product product) {
		
		this.product=product;
		this.quantity = quantity;
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantité) {
		quantity = quantité;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	
	
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", Quantity=" + quantity + ", review=" + review
				+ "]";
	}

	

}
