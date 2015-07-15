/**
 * R&D - http://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 * 
 */
package org.herb.ui.example.tutorialspoint;

import java.util.Date;

/**
 * This is the mediator class
 *
 */
public class ChatRoom {
	
	public static void showMessage(User user, String message) {
		System.out.println(new Date().toString() + " [" + user.getName() + "]: " + message);
	}

}
