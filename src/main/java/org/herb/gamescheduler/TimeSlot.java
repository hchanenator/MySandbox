/**
 * 
 */
package org.herb.gamescheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hchan
 *
 */
public class TimeSlot {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
	
	int duration;
	String timeString;
	boolean badTime = false;
	
	
	public TimeSlot(int duration, String time, boolean badTime) {
		this.duration = duration;
		this.timeString = LocalTime.parse(time).format(formatter);
		this.badTime = badTime;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return timeString;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.timeString = time;
	}

	/**
	 * @return the badTime
	 */
	public boolean isBadTime() {
		return badTime;
	}

	/**
	 * @param badTime the badTime to set
	 */
	public void setBadTime(boolean badTime) {
		this.badTime = badTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimeSlot [duration=" + duration + ", time=" + timeString + ", badTime=" + badTime + "]";
	}
	
	
}
