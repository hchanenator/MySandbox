/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package org.herb.ui.pubsub;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

/* Used by InternalFrameDemo.java. */
public class MyInternalFrame extends JInternalFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1586901270730200390L;
	
	static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    private MyMediator myMediator;

    public MyInternalFrame() {
        super("Document #" + (++openFrameCount), 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable

        //...Create the GUI and put it in the window...
        myMediator = new MyMediatorImpl();

        //...Then set the window size or call pack...
        setSize(405,300);

        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        getContentPane().setLayout(null);
        
        MyToolBar myToolBar = new MyToolBar(myMediator);
        myToolBar.setBounds(0, 0, 239, 23);
        getContentPane().add(myToolBar);
        
        final JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(10, 34, 367, 233);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        final JTextField textField = new JTextField();
        textField.setBounds(83, 20, 127, 20);
        panel.add(textField);
        textField.setColumns(10);
        textField.setName("WCFIELD");
        textField.setEditable(false);
        myMediator.addComponent(textField);
        
        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(16, 23, 64, 14);
        panel.add(lblFirstName);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 81, 341, 141);
        panel.add(scrollPane);

        
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        myMediator.addComponent(textArea);
        scrollPane.setViewportView(textArea);
        
        
        JButton btnComponents = new JButton("Components");
        btnComponents.setEnabled(false);
        btnComponents.setBounds(108, 47, 133, 23);
        panel.add(btnComponents);
        btnComponents.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder sb = new StringBuilder();
        		Component[] components = panel.getComponents();
        		for (Component c : components) {
        			sb.append(c.getClass().getSimpleName()).append("\n");
        		}
        		textArea.setText(sb.toString());
        	}
        });
        myMediator.addComponent(btnComponents);
        
        
    }
}