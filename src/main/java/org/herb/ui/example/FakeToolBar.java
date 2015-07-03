/**
 * 
 */
package org.herb.ui.example;

import java.util.Observable;

/**
 * @author herb
 * 
 */
public class FakeToolBar extends Observable {
	private String state;

	public FakeToolBar() {
		state = "View";
	}

	public void setState(String state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}

	public String getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FakeToolBar [state=" + state + "]";
	}

	
}
