package model;

import javax.persistence.Column;
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
	@OneToOne
	private Order commande;
	
	@Embedded
	private Review review;
	
	public OrderDetail() {
		
	}
	
	
	public OrderDetail(Integer id, Order commande, Integer quantité, Review review) {
		super();
		this.id = id;
		this.commande = commande;
		Quantité = quantité;
		this.review = review;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getCommande() {
		return commande;
	}
	public void setCommande(Order commande) {
		this.commande = commande;
	}
	public Integer getQuantité() {
		return Quantité;
	}
	public void setQuantité(Integer quantité) {
		Quantité = quantité;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	
	
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", commande=" + commande + ", Quantité=" + Quantité + ", review=" + review
				+ "]";
	}
	private Integer Quantité;
	

}
