package warehouse;

import exceptions.NegativeValueException;

public class Washer extends Appliance{

	private int waterConp;
	
	// Constructor
	
	public Washer(int power, int water, String qua) throws NegativeValueException {
		super(power,qua);
		setWaterConp(water);
	}
	
	
	// Getters and Setters
	public int getWaterConp() {
		return waterConp;
	}

	public void setWaterConp(int waterConp) throws NegativeValueException {
		
		if (waterConp >0) {
			this.waterConp = waterConp;
		}else {
			this.waterConp = 0;
			throw new NegativeValueException("2.-Negative value in Water Consuption");
		}
		
		
	}


	@Override
	public String toString() {
		return "Washer [waterConp=" + waterConp + "]";
	}
	
}
