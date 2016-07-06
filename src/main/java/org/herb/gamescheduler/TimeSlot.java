/**
 * 
 */
package org.herb.gamescheduler;

import java.time.LocalTime;

/**
 * @author hchan
 *
 */
public class TimeSlot {

	int duration;
	LocalTime time;
	boolean badTime = false;
	
	public TimeSlot(int duration, String time, boolean badTime) {
		this.duration = duration;
		this.time = LocalTime.parse(time);
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
	public LocalTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
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
		return "TimeSlot [duration=" + duration + ", time=" + time + ", badTime=" + badTime + "]";
	}
	
	
}
