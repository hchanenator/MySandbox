package org.herb.gamescheduler;

import java.time.LocalTime;

public class TimeTester {

	public static void main(String[] args) {
		int i = 2;
		int x = 5 + i;
		String t = "0" + x + ":00";
		LocalTime time = LocalTime.parse("0" + x + ":00");
		System.out.println(time.toString());
	}

}
