/**
 * 
 */
package org.herb.ui.example.bluewalrus;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @author herb
 *
 */
class MyDialog extends JDialog{
	 
    private final YetAnotherPanel yetAnotherPanel;

    public MyDialog(JFrame parent) {
        yetAnotherPanel = new YetAnotherPanel(parent);
    }

    public YetAnotherPanel getAnotherPanel() {
        return yetAnotherPanel;
    }
}
