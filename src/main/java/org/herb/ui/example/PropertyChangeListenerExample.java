/**
 * From http://stackoverflow.com/questions/29064760/java-swing-jbutton-accessing-a-pressed-button-from-another-class
 */
package org.herb.ui.example;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author herb
 *
 */
public class PropertyChangeListenerExample {
	   public static void main(String[] args){
		      final MtNonGui nonGui = new MtNonGui();

		      SwingUtilities.invokeLater(new Runnable() {
		         public void run() {
		            MtGuiPanel guiPanel = new MtGuiPanel();
		            JFrame testFrame = new JFrame("Test");
		            testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            testFrame.add(guiPanel);
		            testFrame.pack();
		            testFrame.setLocationByPlatform(true);
		            testFrame.setVisible(true);

		            guiPanel.addPropertyChangeListener(MtGuiPanel.PRESS_ME_ACTION, new PropertyChangeListener() {

		               public void propertyChange(PropertyChangeEvent evt) {
		                  nonGui.buttonPressed();
		               }
		            });
		         }
		      });
		   }
}

class MtNonGui {

	   public void buttonPressed() {
	      System.out.println("Button Pressed");
	   }

	}

	class MtGuiPanel extends JPanel {
	   public static final String PRESS_ME_ACTION = "press me action";
	   private JButton button = new JButton(new PressMeAction("Press Me"));

	   public MtGuiPanel() {
	      add(button);
	   }

	   private class PressMeAction extends AbstractAction {
	      public PressMeAction(String name) {
	         super(name);
	         int mnemonic = (int) name.charAt(0);
	         putValue(MNEMONIC_KEY, mnemonic);
	      }

	      public void actionPerformed(ActionEvent e) {
	         MtGuiPanel.this.firePropertyChange(PRESS_ME_ACTION, false, true);
	      }
	   }
	}
