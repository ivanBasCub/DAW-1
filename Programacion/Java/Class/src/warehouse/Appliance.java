package warehouse;

import exceptions.NegativeValueException;

// Create a new type of data can use in the appliance class


public class Appliance {

	private static int idaux = 0;
	private int id;
	private int powerCons;
	private PowerRating ratting;
	
	// Constructor
	
	public Appliance(int power, String qua) throws NegativeValueException {
		setId();
		setPowerCons(power);
		setQualification(qua);
	}

	
	public Appliance(String data) throws NumberFormatException, NegativeValueException {
		setId();
		introduceData(data);
	}
	
	// Method to introduce the data
	
	public void introduceData(String data) throws NumberFormatException, NegativeValueException {
		// PARA PODER METER DOS VALORES SEPARADOS EN EL SPLIT ES "[]"
		String[] result = data.split("-");
		setPowerCons(Integer.parseInt(result[0]));
		setQualification(result[1]);
	}
	
	// Getters and Setters	
	public int getId() {
		return id;
	}
	
	public void setId() {
		this.id = this.idaux+1;
		this.idaux++;
	}
	
	public int getPowerCons() {
		return powerCons;
	}
	
	public void setPowerCons(int powerCons) throws  NegativeValueException{
		if(powerCons > 0) {
			this.powerCons = powerCons;
		}else {
			this.powerCons = 0;
			throw new NegativeValueException("1.-Negative value in Power Consuption");
		}
	}
	
	public PowerRating getQualification() {
		return ratting;
	}
	
	public void setQualification(String ratting) {

		try {
			this.ratting = PowerRating.valueOf(ratting.toUpperCase());
		}catch(IllegalArgumentException e) {
			this.ratting=PowerRating.E;
			e.printStackTrace();
		}
	}
	
	// To String
	@Override
	public String toString() {
		return "Appliance [id=" + id + ", powerCons=" + powerCons + ", qualification=" + ratting + "]";
	}

	
}
