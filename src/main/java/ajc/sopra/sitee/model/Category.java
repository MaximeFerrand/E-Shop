package ajc.sopra.sitee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@Column(columnDefinition = "VARCHAR(35)",nullable = false)
	
	private  String labelCat;
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@OneToMany(mappedBy="category")
	private List<Product> product; 
	public Category( String labelCat) {
		
		
		this.labelCat = labelCat;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Category() {
		
	}
	
	public String getLabelCat() {
		return labelCat;
	}
	public void setLabelCat(String labelCat) {
		this.labelCat = labelCat;
	}
	@Override
	public String toString() {
		return "Category [ labelCat=" + labelCat + "]";
	}
	public Integer getId() {
		
		return id;
	}

}
