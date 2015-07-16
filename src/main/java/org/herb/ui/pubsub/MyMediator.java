/**
 * 
 */
package org.herb.ui.pubsub;

import javax.swing.JComponent;

import org.herb.ui.framework.ToolbarState;

/**
 * @author herb
 *
 */
public interface MyMediator {
	
	void addComponent(JComponent component);
	
	void updateMode(ToolbarState state);

}
