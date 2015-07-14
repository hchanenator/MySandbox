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

/**
 * @author herb
 *
 */
public class MyToolBar extends JToolBar {
	
	private JButton addButton;
	private JLabel label;
	private JDesktopPane desktop;
	private JInternalFrame internalFrame;
	private JComponent component;
	
	public MyToolBar() {
		super();
		setFloatable(false);
		setBackground(new Color(19, 172, 214));
		
		addButton = createButton("Change Mode");
		add(addButton);
		label = createLabel();
		add(label);		
		
	}
	
	private JButton createButton(String text) {
		JButton button = new JButton(text);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(String.format("%d", component.getComponentCount()));
			}
		});
		return button;
	}
	
	private JLabel createLabel() {		
		JLabel label = new JLabel();
		label.setBackground(Color.YELLOW);
		label.setSize(25, 10);
		return label;
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
