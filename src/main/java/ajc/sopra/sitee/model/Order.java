package ajc.sopra.sitee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order")
//@DiscriminatorColumn(name="order tracking",columnDefinition = "ENUM('commandé', 'enPreparation', 'expedie', 'livre', 'cloture';)")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('ordered','in_Preparation', 'shipped', 'delivered', 'closed')",nullable = false)
	private OrderTracking orderTracking;
	///@Embedded
	@OneToMany
	private List<OrderDetail> ordreDetail= new ArrayList();
	//private OrderDetail ordreDetail;
	
	



	public List<OrderDetail> getOrdreDetail() {
		return ordreDetail;
	}





	public void setOrdreDetail(List<OrderDetail> ordreDetail) {
		this.ordreDetail = ordreDetail;
	}



	public Integer getId() {
		return id;
	}

	

	public OrderTracking getOrderTracking() {
		return orderTracking;
	}

	public void setOrderTracking(OrderTracking orderTracking) {
		this.orderTracking = orderTracking;
	}

	public Order( OrderTracking orderTracking) {
		
		
		this.orderTracking = orderTracking;
	}
	public Order() {
		
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTracking=" + orderTracking + "]";
	}

}
