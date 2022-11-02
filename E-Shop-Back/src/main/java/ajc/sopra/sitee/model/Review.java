package ajc.sopra.sitee.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Review {
	
	
	//@Column(nullable=false)
	private Integer notation;
	//@Column(nullable=false)
	@Column(length=200, columnDefinition ="TEXT")
	private String comment;
	

	public Review() {
		
	}
	
	
	public Review(Integer notation, String comment) {
		this.notation = notation;
		this.comment = comment;
	}


	public Integer getNotation() {
		return notation;
	}


	public void setNotation(Integer notation) {
		this.notation = notation;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
