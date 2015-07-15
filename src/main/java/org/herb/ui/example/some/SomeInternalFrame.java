/**
 * 
 */
package org.herb.ui.example.some;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

/**
 * @author herb
 *
 */
public class SomeInternalFrame extends JInternalFrame {
	public SomeInternalFrame() {
		
		SomeToolBar someToolBar = new SomeToolBar();
		getContentPane().add(someToolBar, BorderLayout.NORTH);
	}

}
