package ajc.sopra.eshop.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="order_detail")

public class OrderDetail {
	



	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@Column(nullable= false)
	private Integer quantity;
	//@JsonView(JsonViews.OrderDetailWithProduct.class)
	@JsonView(JsonViews.OrderDetailWithProductAndReview.class )
	@ManyToOne 
	//@Column(nullable= false)
	private Product product;
	//@JsonView(JsonViews.OrderDetailWithReview.class)
	@JsonView(JsonViews.OrderDetailWithProductAndReview.class )
	@Embedded
	private Review review;
	
	@ManyToOne
	private Order order;
	
	public OrderDetail() {
		
	}
	
	
	
	public OrderDetail( Integer quantity, Product product) {
		
		this.product=product;
		this.quantity = quantity;
	
	}
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
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
