/**
 * 
 */
package org.herb.ui.pubsub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author herb
 *
 */
public class MyMenuBar extends JMenuBar {

	private static final long serialVersionUID = -5445117686659070066L;
	private JDesktopPane desktop;
	private JMenu fileMenu;
	private JMenuItem newFrame;
	
	public MyMenuBar() {
		super();
		
		add(createFileMenu());
		
	}

	private void addFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		frame.setVisible(true);
		desktop.add(frame);		
		try {					
			frame.setSelected(true);					
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}	
	}
	
	private JMenu createFileMenu() {
		fileMenu = new JMenu("File");
		newFrame = new JMenuItem("New");
		newFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFrame();
			}
		});
		fileMenu.add(newFrame);
		return fileMenu;		
	}
	
	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}
	
}
