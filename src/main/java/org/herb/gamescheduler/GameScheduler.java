/**
 * 
 */
package org.herb.gamescheduler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hchan
 *
 */
public class GameScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String BASENAME = "Game #:";

		List<SimpleGame> games = new ArrayList<SimpleGame>();
		for(int i=0; i<10; i++) {
			games.add(new SimpleGame(BASENAME + i));
		}
		
		for (SimpleGame simpleGame : games) {
			System.out.println(simpleGame);
			List<TimeSlot> timeSlots = simpleGame.getTimes();
			for (TimeSlot timeSlot : timeSlots) {
				System.out.println(timeSlot.timeString.toString());
			}
		}
	}

}
