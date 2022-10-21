package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=35,nullable = false)
	private  String libelle;
	@Column(length=35,nullable = false)
	private Double prix;
	
	
	@ManyToOne
	private  Category category ;
	private   int  stock;
	public Product( String libelle, Double prix, int stock) {
		
		
		this.libelle = libelle;
		this.prix = prix;
		this.stock = stock;
	}
	public Product() {
		
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Category getCategorie() {
		return category;
	}
	public void setCategorie(Category categorie) {
		this.category = categorie;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [ libelle=" + libelle + ", prix=" + prix + ", stock=" + stock + "]";
	}
	


}
