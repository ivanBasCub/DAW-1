package dates;

import java.time.format.DateTimeFormatter;

public class Dates {
	public DateTimeFormatter formatterDate() {
		return DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy");
	}
	
}
