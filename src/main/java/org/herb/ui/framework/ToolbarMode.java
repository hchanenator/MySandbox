/**
 * 
 */
package org.herb.ui.framework;

import java.util.Observable;

/**
 * Represents the mode of the Toolbar and drives the
 * behaviour of the active window.  
 * 
 * In PICS, this is only 1 window at a time so the 
 * pub-sub is only 1.  Subscribers change when the toolbar
 * is in VIEW mode only.  If in any other mode, the 
 * subscriber cannot change until set back to VIEW mode
 * 
 * @author herb
 *
 */
public class ToolbarMode extends Observable {

	private static ToolbarState currentState;
	
	public ToolbarMode() {
		currentState = ToolbarState.VIEW;
	}
	
	public String getCurrentState() {
		return currentState.toString();
	}
	
	public void setCurrentState(ToolbarState state) {
		currentState = state;
		setChanged();
		notifyObservers();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToolbarMode [ToolbarState = " + currentState.toString() + "]";
	}
	
	
}
