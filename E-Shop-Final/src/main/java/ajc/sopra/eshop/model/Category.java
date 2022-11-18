package ajc.sopra.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(/*columnDefinition = "VARCHAR(35) default 'pas de category'"*/length=35,nullable = false)
	@JsonView(JsonViews.Common.class)
	private  String labelCat;
	

	@JsonView(JsonViews.CategoryWithProduct.class)
	@OneToMany(mappedBy="category")
	private List<Product> products=new ArrayList(); 
	
	//probleme return null
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

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
