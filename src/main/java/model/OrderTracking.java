package model;

import javax.persistence.Embeddable;


public enum OrderTracking {
	commandé, enPreparation, expedie, livre, cloture;
	
	private OrderTracking() {
		// TODO Auto-generated constructor stub
	}

}
