/**
 * R&D - http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
 */
package org.herb.ui.example.journaldev;

/**
 * The Mediator interface defining the contract for all concrete mediators * 
 *
 */
public interface ChatMediator {

	/**
	 * Sends a message to all users
	 * @param msg
	 * @param user
	 */
	public void sendMessage(String msg, ChatUser user);
	
	/**
	 * Register a user with the Mediator
	 * @param user
	 */
	void addUser(ChatUser user);
}
