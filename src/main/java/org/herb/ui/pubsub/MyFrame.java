/**
 * 
 */
package org.herb.ui.pubsub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

/**
 * @author herb
 *
 */
public class MyFrame extends JFrame {
	
	private static final long serialVersionUID = 3375109743680468722L;
	
	private int width = 640;
	private int height = 480;

	private JPanel panel;
	private JDesktopPane desktop;
//	private MyToolBar toolbar;
	private MyMenuBar menubar;
	
	public MyFrame() {
		super("Test It");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setLocation(findCenter());
		
		menubar = createMenu();
		setJMenuBar(menubar);
		
		panel = createPanel();
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
		
//		toolbar = createToolBar();
		
//		panel.add(toolbar, BorderLayout.NORTH);
		desktop = createDesktopPane();
//		toolbar.setDesktop(desktop);
		menubar.setDesktop(desktop);
		
		panel.add(desktop, BorderLayout.CENTER);		
		setVisible(true);
	}
	
	private Point findCenter() {
		int x = (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (width / 2);
		int y = (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (height / 2);		
		return new Point(x, y);
	}
	
	private MyMenuBar createMenu() {
		return new MyMenuBar();
	}
	
	private JPanel createPanel() {
		return new JPanel();
	}
	
	private JDesktopPane createDesktopPane() {
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);		
		desktopPane.setVisible(true);
		return desktopPane;
	}
	
	private MyToolBar createToolBar() {
		return new MyToolBar();
	}

}
