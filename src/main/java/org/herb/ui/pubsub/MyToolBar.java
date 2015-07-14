/**
 * 
 */
package org.herb.ui.pubsub;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.Box;

/**
 * @author herb
 *
 */
public class MyToolBar extends JToolBar {
	
	
	private JDesktopPane desktop;
	private JInternalFrame internalFrame;
	private JComponent component;
	
	public MyToolBar() {
		super();
		setFloatable(false);
		setBackground(new Color(19, 172, 214));
		
		JButton btnAdd = new JButton("Add");
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);
		add(btnEdit);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);
		
		JButton btnDelete = new JButton("Delete");
		add(btnDelete);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2);
		
		JButton btnSave = new JButton("Save");
		add(btnSave);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		add(horizontalStrut_3);
		
		JButton btnCancel = new JButton("Cancel");
		add(btnCancel);
		
	}
	

	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
		component = desktop;
	}
	
	public void setInternalFrame(JInternalFrame internalFrame) {
		this.internalFrame = internalFrame;
		component = internalFrame;
	}
}
