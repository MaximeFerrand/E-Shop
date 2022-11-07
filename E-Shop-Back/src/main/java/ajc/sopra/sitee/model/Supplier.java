package ajc.sopra.sitee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="Type_Supplier", columnDefinition = "ENUM('merchant', 'artisan')")
//@DiscriminatorColumn(name = "espece",columnDefinition = "ENUM('felin','ours','elephant')")

@Table(name="supplier")
public abstract class Supplier extends Account {

    /*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 protected Integer id;*/
	@Column(length=50,nullable = false)
	protected String company;
	
	protected String typeOfSupplier;
	
	@OneToMany(mappedBy ="supplier")
	protected List<Product> products;

	
		
	public Supplier(String company, List<Product> products, String typeOfSupplier) {
		super();
		this.company = company;
		this.products = products;
		this.typeOfSupplier = typeOfSupplier;
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