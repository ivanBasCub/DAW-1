package warehouse;

import exceptions.NegativeValueException;

public class WashingMachine extends Washer{

	private int maxKg;
	
	public WashingMachine(int power, int water, int loadKg, String qua) throws NegativeValueException {
		super(power, water, qua);
		setMaxKg(loadKg);
	}

	public int getMaxKg() {
		return maxKg;
	}

	public void setMaxKg(int maxKg) throws NegativeValueException {
		if(maxKg > 0) {
			this.maxKg = maxKg;
		}else {
			this.maxKg = 0;
			throw new NegativeValueException("3.- Negative value in Max Loading");
		}
		
		
	}

	@Override
	public String toString() {
		return "WashingMachine [maxKg=" + maxKg + "]";
	}
	
	/*
	 * LoadKg
	 */
	
}
