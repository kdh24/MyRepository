package ch12.exam07;

import java.util.Calendar;

public class EnumExample {
	public static void main(String[] args) {
		// Week week = Week.TUESDAY;
		Week week;

		Calendar now = Calendar.getInstance();
		switch (now.get(Calendar.DAY_OF_WEEK)) {
			case 1:	week = Week.SUNDAY; break;
			case 2:	week = Week.MONDAY; break;
			case 3:	week = Week.TUESDAY; break;
			case 4:	week = Week.WEDNEDAY; break;
			case 5:	week = Week.THURSDAY; break;
			case 6:	week = Week.FRIDAY; break;
			default: week = Week.SATURDAY;
		}
		
		System.err.println(week);
		
		if(week == Week.FRIDAY){
			
		}
	}
}
