/**
 * R&D - http://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 * 
 */
package org.herb.ui.example.tutorialspoint;


public class User {

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public void sendMessage(String message) {
		ChatRoom.showMessage(this, message);
	}
}
