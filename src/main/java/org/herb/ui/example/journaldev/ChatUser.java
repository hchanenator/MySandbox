/**
 * R&D - http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
 */
package org.herb.ui.example.journaldev;

/**
 * the Colleague interface.  Can be interface or abstract class 
 * Has a reference to the mediator object required for communication
 * between different users
 *
 */
public abstract class ChatUser {

	protected ChatMediator mediator;
	protected String name;
	
	public ChatUser(ChatMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	
	/**
	 * Send a message
	 * @param msg
	 */
	public abstract void send(String msg);
	
	/**
	 * Receive a message
	 * @param msg
	 */
	public abstract void receive(String msg);
}
