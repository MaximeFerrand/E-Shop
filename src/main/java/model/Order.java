package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
//@DiscriminatorColumn(name="order tracking",columnDefinition = "ENUM('commandé', 'enPreparation', 'expedie', 'livre', 'cloture';)")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 35,nullable = false)
	private OrderTracking orderTracking;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderTracking getOrderTracking() {
		return orderTracking;
	}

	public void setOrderTracking(OrderTracking orderTracking) {
		this.orderTracking = orderTracking;
	}

	public Order(Integer id, OrderTracking orderTracking) {
		super();
		this.id = id;
		this.orderTracking = orderTracking;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTracking=" + orderTracking + "]";
	}

}
