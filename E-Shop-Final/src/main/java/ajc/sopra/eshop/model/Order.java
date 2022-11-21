package ajc.sopra.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;





@Entity
@Table(name="basket")
//@DiscriminatorColumn(lastname="order tracking",columnDefinition = "ENUM('commandé', 'enPreparation', 'expedie', 'livre', 'cloture';)")

public class Order {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('ordered','inPreparation', 'shipped', 'delivered', 'closed')",nullable = false)
	private OrderTracking orderTracking;
	///@Embedded
	
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> ordreDetails= new ArrayList();
	//private OrderDetail ordreDetail;
	@JsonView(JsonViews.OrderWithOrderDetailAndUser.class)
	@ManyToOne
	private User user;
	
	//private OrderDetail orderDetail;
	
	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('houseShipping', 'pickUp', 'withdrawal')")
	private Shipping shipping;

	

	public List<OrderDetail> getOrdreDetail() {
		return ordreDetails;
	}

  



	public Order(User user) {
		super();
		this.user = user;
		
	}





	public void setOrdreDetail(List<OrderDetail> ordreDetail) {
		this.ordreDetails = ordreDetail;
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
    public void payement() {
    	//à completer appel au API simulatrice
    }
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTracking=" + orderTracking + "]";
	}

}
