/**
 * 
 */
package org.herb.ui.pubsub;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 * @author herb
 *
 */
public class MyFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7422609613902765500L;

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 394);
		

		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

}
