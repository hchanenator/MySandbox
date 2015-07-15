/**
 * 
 */
package org.herb.ui.example.bluewalrus;

import javax.swing.SwingUtilities;

/**
 * @author herb
 *
 */
public class MyMediator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				daDoRunRun();
				
			}
		});

	}
	
	private static void daDoRunRun() {
		Mediator mediator = new Mediator();
	}

}
