/**
 * R & D into Mediator pattern from Blue Walrus site
 * http://blue-walrus.com/2013/06/mediator-pattern-in-swing/ 
 */
package org.herb.ui.example.bluewalrus;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author herb
 *
 */
class MyPanel extends JPanel {
	 
    private final JFrame parent;

    private final AnotherPanel anotherPanel;

    public MyPanel(JFrame parent) {

        this.parent = parent;

        anotherPanel = new AnotherPanel(this.parent);

        this.add(anotherPanel);
    }

    public AnotherPanel getAnotherPanel(){
        return anotherPanel;
    }
}