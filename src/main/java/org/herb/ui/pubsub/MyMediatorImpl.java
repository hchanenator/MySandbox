/**
 * 
 */
package org.herb.ui.pubsub;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.herb.ui.framework.ToolbarState;

/**
 * @author herb
 *
 */
public class MyMediatorImpl implements MyMediator {

	List<JComponent> components;
	
	public MyMediatorImpl() {
		components = new ArrayList<JComponent>();
	}

	/* (non-Javadoc)
	 * @see org.herb.ui.pubsub.MyMediator#addComponent(javax.swing.JComponent)
	 */
	@Override
	public void addComponent(JComponent component) {
		components.add(component);
		
	}

	/* (non-Javadoc)
	 * @see org.herb.ui.pubsub.MyMediator#updateMode(org.herb.ui.framework.ToolbarMode)
	 */
	@Override
	public void updateMode(ToolbarState state) {
		if (state.equals(ToolbarState.ADD)) {
			JOptionPane.showMessageDialog(null, "Sorry, not implemented yet.", "Not Implemented Yet", JOptionPane.INFORMATION_MESSAGE);
		} else if (state.equals(ToolbarState.EDIT)) {
			for (JComponent c : components) {
				if (c instanceof JTextField) {
					((JTextField) c).setEditable(true);
				} else if (c instanceof JButton) {
					c.setEnabled(true);
				} else if (c instanceof JTextArea) {
					((JTextArea) c).setEditable(true);
				}
			}
		} else if (state.equals(ToolbarState.VIEW)) {
			for (JComponent c : components) {
				if (c instanceof JTextField) {
					((JTextField) c).setEditable(false);
				} else if (c instanceof JButton) {
					c.setEnabled(false);
				} else if (c instanceof JTextArea) {
					((JTextArea) c).setEditable(false);
				}
			}
		}
		
	}
	
	
}
	