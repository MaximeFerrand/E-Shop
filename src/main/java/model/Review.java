package model;

public class Review {
	
	private Integer notation;
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
