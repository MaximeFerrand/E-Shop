package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  String libelleCat;
	public Category(Integer id, String libelleCat) {
		super();
		this.id = id;
		this.libelleCat = libelleCat;
	}
	public Category() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelleCat() {
		return libelleCat;
	}
	public void setLibelleCat(String libelleCat) {
		this.libelleCat = libelleCat;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", libelleCat=" + libelleCat + "]";
	}

}
