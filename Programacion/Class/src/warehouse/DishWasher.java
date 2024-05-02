package warehouse;

import exceptions.NegativeValueException;

public class DishWasher extends Washer{

	private int services;

	public DishWasher(int power, int water,int services, String qua) throws NegativeValueException {
		super(power, water, qua);
		setServices(services);
		
	}

	public void setServices(int services) throws NegativeValueException {
		if(services > 0) {
			this.services = services;
		}else {
			this.services = 0;
			throw new NegativeValueException("4.- Negative value in Services");
		}
		
		
	}

	@Override
	public String toString() {
		return "DishWasher [services=" + services + "]";
	}
	
	
	
	
}
