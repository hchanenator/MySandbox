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
public class SimpleGame {

	private String name;
	private List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
	
	public SimpleGame(String name) {
		this.name= name;
		gameMaker();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleGame [name=" + name + "]";
	}
	
	private void gameMaker() {
		for(int i = 0; i < 5; i++) {
			int hr = 7 + i;
			timeSlots.add(new TimeSlot(60, hr + ":00", false));
		}
	}
	
	public List<TimeSlot> getTimes() { return timeSlots; }
	
}
