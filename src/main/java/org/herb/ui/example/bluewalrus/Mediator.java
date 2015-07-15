/**
 * R & D into Mediator pattern from Blue Walrus site
 * http://blue-walrus.com/2013/06/mediator-pattern-in-swing/ 
 */
package org.herb.ui.example.bluewalrus;

import javax.swing.JFrame;

/**
 * @author herb
 *
 */
public class Mediator extends JFrame {
	
	public Mediator() {
		MyPanel panel = new MyPanel(this);
		this.getContentPane().add(panel);
		this.setVisible(true);
		this.setBounds(0, 0, 1024, 708);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
