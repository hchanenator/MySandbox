package org.herb.ui.example;

import java.util.Observable;
import java.util.Observer;

import org.herb.ui.framework.ToolbarMode;

public class SomeScreen implements Observer {

	private String screenTitle;
	private String screenState;
	
	public SomeScreen(String screenTitle) {
		this.screenTitle = screenTitle;
		screenState = "";
	}
	
	@Override
	public void update(Observable o, Object arg) {
		FakeToolBar toolBar = (FakeToolBar)o;
		screenState = toolBar.getState();
		System.out.println(this.toString());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SomeScreen [screenTitle=" + screenTitle + ", screenState="
				+ screenState + "]";
	}
	
	
}
