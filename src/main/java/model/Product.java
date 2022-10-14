package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private  String libelle;
	private Double prix;
	private  Category category;
	private   int  stock;
	public Product(Integer id, String libelle, Double prix, Category categorie, int stock) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.category = categorie;
		this.stock = stock;
	}
	public Product() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "Product [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", stock=" + stock + "]";
	}
	


}
