package ajc.sopra.eshop.model;

public enum Shipping {
	houseShipping(39), pickUp(29), withdrawal(5);
	
	private int price;
	private Shipping(int price) {
		this.price=price;
		
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	

}
