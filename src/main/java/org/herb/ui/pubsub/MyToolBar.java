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

import org.herb.ui.framework.ToolbarState;

import java.awt.Component;
import javax.swing.Box;

/**
 * @author herb
 *
 */
public class MyToolBar extends JToolBar {
	
	private MyMediator med;
	
	public MyToolBar(final MyMediator med) {
		super();
		this.med = med;
		setRollover(true);
		setBackground(new Color(51, 153, 255));
		setFloatable(false);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				med.updateMode(ToolbarState.ADD);
			}
		});
		add(btnAdd);
		
		JLabel label = new JLabel(" ");
		add(label);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				med.updateMode(ToolbarState.EDIT);
			}
		});
		add(btnEdit);
		
		JLabel label_1 = new JLabel(" ");
		add(label_1);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				med.updateMode(ToolbarState.VIEW);
			}
		});
		add(btnView);
		
	}
	
}
