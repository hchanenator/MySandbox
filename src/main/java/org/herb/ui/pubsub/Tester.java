/**
 * 
 */
package org.herb.ui.pubsub;

import javax.swing.SwingUtilities;

/**
 * @author herb
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				doRun();
			}
		});

	}
	
	private static void doRun() {
		MyFrame frame = new MyFrame();
	}

}
