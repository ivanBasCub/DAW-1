package enumTypes;

public enum WoodType {
	OAK("Greenish Brown",800),
	CHERRY("Cherryish Brown",790),
	WALNUT("Reddis Brown",820);
	
	
	
	private final int DENSITY;
	private final String COLOR;
	
	//OAK,CHERRY,PINE,WALNUT,HAZELNUT
	
	private WoodType(String c,int d) {
		COLOR = c;
		DENSITY = d;
	}

	public int getDENSITY() {
		return DENSITY;
	}

	public String getCOLOR() {
		return COLOR;
	}
	
}
