/**
 * 
 */
package org.herb.ui.example.bluewalrus;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author herb
 *
 */

class YetAnotherPanel extends JPanel {
 
        private final MyDialog dialog;
 
        public YetAnotherPanel(JFrame parent) {
 
           dialog = new MyDialog(parent);
           dialog.setVisible(true);
        }
 
        public MyDialog getMyDialog(){
            return dialog;
        }
    }
