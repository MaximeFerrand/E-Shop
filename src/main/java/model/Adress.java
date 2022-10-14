package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String number;
	private String way;
	private String pc;
	private String city;
	public Adress(String number, String way, String pc, String city) {
		super();
		this.number = number;
		this.way = way;
		this.pc = pc;
		this.city = city;
	}
	public Adress() {
		super();
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getPc() {
		return pc;
	}
	public void setPc(String pc) {
		this.pc = pc;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Adress [number=" + number + ", way=" + way + ", pc=" + pc + ", city=" + city + "]";
	}
	

}
