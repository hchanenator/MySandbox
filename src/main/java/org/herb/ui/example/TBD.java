package org.herb.ui.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.herb.ui.pubsub.MyInternalFrame;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class TBD extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TBD frame = new TBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TBD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		desktopPane = new JDesktopPane();
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnTest = new JButton("test");
		
		toolBar.add(btnTest);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setOpaque(true);
		toolBar.add(lblNewLabel);
		
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame();
				lblNewLabel.setText(String.format(" %d", desktopPane.getComponentCount()));
			}
		});

		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	private void addFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		frame.setVisible(true);
		desktopPane.add(frame);		
		try {					
			frame.setSelected(true);					
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}	
	}
}
