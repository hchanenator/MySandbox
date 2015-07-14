package org.herb.ui.eclipseeditor;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class PlayerViewer extends JInternalFrame {
	private JTable playerTable;

	/**
	 * Create the frame.
	 */
	public PlayerViewer() {
		setClosable(true);
		setPreferredSize(new Dimension(480, 320));
		setBounds(100, 100, 488, 344);
		getContentPane().setLayout(null);
		
		playerTable = new JTable();
		playerTable.setBounds(38, 53, 398, 235);
		getContentPane().add(playerTable);
		
		JButton btnRetrieveButton = new JButton("<html><b>Retrieve</b></html>");
		btnRetrieveButton.setBounds(181, 11, 89, 23);
		getContentPane().add(btnRetrieveButton);

	}
}
