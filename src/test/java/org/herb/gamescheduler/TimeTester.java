package org.herb.gamescheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeTester {

	public static void main(String[] args) {
		int i = 2;
		int x = 11 + i;
		String t = x + ":00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		System.out.println(LocalTime.parse( t).format(formatter));
//		System.out.println(String.format(time.toString(), sdf));


		
	}

}
