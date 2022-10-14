package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//DTYPE => DiscriminatorType
//@DiscriminatorColumn(name = "type_personne",columnDefinition = "ENUM('customer','supplier')")
@Table(name="supplier")
public abstract class Supplier extends Account {

	@Column(length=50,nullable = false)
	protected String company;
	
	@OneToMany
	protected List<Product> products;

	
		
	public Supplier(String company, List<Product> products) {
		super();
		this.company = company;
		this.products = products;
	}

	public Supplier() {
		super();
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
	

	public double discountProduct(double priceProduct) {
		
	}

	
	
}