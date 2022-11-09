package ajc.sopra.eshop.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;




@Entity
public class Product {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(length=35,nullable = false)
	@JsonView(JsonViews.Common.class)
	private  String label;
	
	@JsonView(JsonViews.Common.class)
	@Column(length=35,nullable = false)
	private Double price;
	
	@JsonView(JsonViews.Common.class)
	@Column(length=15,nullable = false)
	private String reference;
	
	@JsonView(JsonViews.Common.class)
	@Column(length=300,nullable = false)
	private String description;
	
	@JsonView(JsonViews.Common.class)
	@Column(nullable = false)
	private String measure;
	
	@OneToMany(mappedBy ="product")
	private List<OrderDetail> orderDetail;
	
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	private Supplier supplier;
	
	@JsonView(JsonViews.Common.class)
	private   Integer  stock;
	
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	private Category category ;
	
	/*
	 * @OneToMany(mappedBy ="product")
	private List<BasketDetail> basketDetails = new ArrayList<>();
	*/
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('New','Reconditioned','Repaired')")
	private Status status;
	
	
	public Product( String label, Double price, Integer stock) {
		this.label = label;
		this.price = price;
		this.stock = stock;
	}
	public Product() {
	}

	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getDescription() {
		return description;
		
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", price=" + price + ", reference=" + reference
				+ ", description=" + description + ", measure=" + measure + ", orderDetail=" + orderDetail
				+ ", supplier=" + supplier + ", stock=" + stock + ", status=" + status + ", category=" + category + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	


}
