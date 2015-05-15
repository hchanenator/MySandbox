/**
 * 
 */
package org.herb.ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @author herb
 * 
 */
public class SimpleSwingSandbox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame frame = new JFrame("Test it");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				frame.getContentPane().setLayout(null);
				
				JButton btnUpdateThis = new JButton("Update this!");
				btnUpdateThis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Process process = Runtime.getRuntime().exec("");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnUpdateThis.setBounds(144, 112, 111, 23);
				frame.getContentPane().add(btnUpdateThis);
				frame.setVisible(true);

			}
		});

	}

}
