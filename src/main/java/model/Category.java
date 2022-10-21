package model;

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
	@Column(columnDefinition = "VARCHAR(35)",nullable = false)
	
	private  String libelleCat;
	@OneToMany
	private List<Product> product; ;
	public Category( String libelleCat) {
		
		
		this.libelleCat = libelleCat;
	}
	public Category() {
		
	}
	
	public String getLibelleCat() {
		return libelleCat;
	}
	public void setLibelleCat(String libelleCat) {
		this.libelleCat = libelleCat;
	}
	@Override
	public String toString() {
		return "Category [ libelleCat=" + libelleCat + "]";
	}

}
