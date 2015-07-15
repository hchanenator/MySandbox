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
	
	private JInternalFrame internalFrame;
	
	public MyToolBar() {
		super();
		setRollover(true);
		setBackground(new Color(51, 153, 255));
		setFloatable(false);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component[] components = internalFrame.getComponents();
				for(Component c : components) {
					System.out.println(c.toString());
				}
			}
		});
		add(btnAdd);
		
		JLabel label = new JLabel(" ");
		add(label);
		
		JButton btnEdit = new JButton("Edit");
		add(btnEdit);
		
		JLabel label_1 = new JLabel(" ");
		add(label_1);
		
		JButton btnDelete = new JButton("Delete");
		add(btnDelete);
		
	}
	
	public void setInternalFrame(JInternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}
}
