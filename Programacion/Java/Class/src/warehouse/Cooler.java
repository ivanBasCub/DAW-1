package warehouse;

import exceptions.NegativeValueException;

public class Cooler extends Appliance {
	
	private int capacity;
	
	// Constructor
	
	public Cooler(int power, int cap, String qua) throws NegativeValueException {
		super(power, qua);
		setCapacity(cap);
	}
	
	// Getters and Setters
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) throws NegativeValueException {
		if (capacity >0) {
			this.capacity = capacity;
		}else {
			this.capacity = 0;
			throw new NegativeValueException("5.- Negative value in Capacity");
		}
	}

	@Override
	public String toString() {
		return "Cooler [capacity=" + capacity + "]";
	}

}
