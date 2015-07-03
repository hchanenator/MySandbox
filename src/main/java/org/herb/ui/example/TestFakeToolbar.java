/**
 * 
 */
package org.herb.ui.example;

import org.herb.ui.framework.ToolbarState;

/**
 * @author herb
 *
 */
public class TestFakeToolbar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FakeToolBar toolbar = new FakeToolBar();
		SomeScreen someScreen = new SomeScreen("Fake Screen");
		System.out.println(someScreen.toString());
		
		toolbar.addObserver(someScreen);
		toolbar.setState(ToolbarState.EDIT.name());		
		toolbar.setState(ToolbarState.VIEW.name());
		toolbar.setState(ToolbarState.ADD.name());

	}

}
