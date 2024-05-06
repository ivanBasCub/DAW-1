package exer1Class;

import java.util.Comparator;

/**
 * Compares objects from  {@link LineOrder} using the total
 */
public class LineOrderComparator implements Comparator<LineOrder> {

	@Override
	public int compare(LineOrder o1, LineOrder o2) {
		double total1 = o1.getTotal();
		double total2 = o2.getTotal();
		
		if(total1 < total2) {
			return -1;
		}else if(total1 > total2) {
			return 1;
		}else {
			return 0;
		}
	}

}
