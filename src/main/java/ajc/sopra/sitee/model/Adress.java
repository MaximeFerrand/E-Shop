package ajc.sopra.sitee.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {

	
	@Column(length=35,nullable = false)
	private String number;
	@Column(length=35,nullable = false)
	private String way;
	@Column(length=35,nullable = false)
	private String pc;
	@Column(length=35,nullable = false)
	private String city;
	
	
	
	public Adress(String number, String way, String pc, String city) {
		
		this.number = number;
		this.way = way;
		this.pc = pc;
		this.city = city;
	}
	
	public Adress() {
		
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
