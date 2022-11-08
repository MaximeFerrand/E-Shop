package ajc.sopra.sitee.model;



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
	private String Reference;
	//@JsonView(JsonViews.Common.class)
	@Column(length=300,nullable = false)
	private String Description;
	@JsonView(JsonViews.Common.class)
	@Column(nullable = false)
	private String Measure;
	
	
	@OneToMany(mappedBy ="product")
	private List<OrderDetail> orderDetail;
	//@JsonView(JsonViews.ProductWithSupplier.class)
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	private Supplier supplier;
	
	
	@JsonView(JsonViews.Common.class)
	private   Integer  stock;
	
	/*
	 * @OneToMany(mappedBy ="product")
	private List<BasketDetail> basketDetails = new ArrayList<>();
	*/
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('New','Reconditioned','Repaired')")
	private Status status;

	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	public String getMeasure() {
		return Measure;
	}
	public void setMeasure(String measure) {
		Measure = measure;
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
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	
	private Category category ;
	/*
	public List<BasketDetail> getBasketDetails() {
		return basketDetails;
	}
	public void setBasketDetails(List<BasketDetail> basketDetails) {
		this.basketDetails = basketDetails;
	}*/
	
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
	
	
	public Product( String label, Double price, int stock) {
		this.label = label;
		this.price = price;
		this.stock = stock;
	}
	public Product() {
		
	}
	
	public String getlabel() {
		return label;
	}
	public void setlabel(String label) {
		this.label = label;
	}
	public Double getprice() {
		return price;
	}
	public void setprice(Double price) {
		this.price = price;
	}
	public Category getCategorie() {
		return category;
	}
	public void setCategorie(Category categorie) {
		this.category = categorie;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", price=" + price + ", Reference=" + Reference
				+ ", Description=" + Description + ", Measure=" + Measure + ", stock=" + stock + ", status=" + status + ", category=" + category + "]";
	}
	public String getDescription() {
		return Description;
		
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
