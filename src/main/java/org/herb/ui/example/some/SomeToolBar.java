/**
 * 
 */
package org.herb.ui.example.some;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

/**
 * @author herb
 *
 */
public class SomeToolBar extends JToolBar {
	public SomeToolBar() {
		
		JButton btnAdd = new JButton("Add");
		add(btnAdd);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);
		
		JButton btnEdit = new JButton("Edit");
		add(btnEdit);
	}

}
