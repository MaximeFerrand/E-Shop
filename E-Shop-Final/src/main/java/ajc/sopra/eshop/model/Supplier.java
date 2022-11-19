package ajc.sopra.eshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(lastname="supplier")
public class Supplier extends Account {

	@JsonView(JsonViews.Common.class)
	@Column(length=50,nullable = false)
	protected String company;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="typeOfSupplier", length=50)
	protected String typeOfSupplier;
	
	@OneToMany(mappedBy ="supplier")
	protected List<Product> products;

	
	public Supplier(String login, String password, String company ,String typeOfSupplier) {
		super(login, password);
		this.company = company;
		this.typeOfSupplier = typeOfSupplier;
	}
	
	public Supplier(String login, String password, String company) {
		super(login, password);
		this.company = company;
	}
		
	public Supplier(String company, List<Product> products, String typeOfSupplier) {
		super();
		this.company = company;
		this.products = products;
		this.typeOfSupplier = typeOfSupplier;
	}

	public Supplier() {
		
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	public String getTypeOfSupplier() {
		return typeOfSupplier;
	}

	public void setTypeOfSupplier(String typeOfSupplier) {
		this.typeOfSupplier = typeOfSupplier;
	}

	public double discountProduct(double priceProduct) {
		double d=0;
		return d;
	}

	
	
}