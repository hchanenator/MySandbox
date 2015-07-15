/**
 * R&D - http://www.journaldev.com/1730/mediator-design-pattern-in-java-example-tutorial
 */
package org.herb.ui.example.journaldev;

/**
 * simple testing program simulating the chat room
 *
 */
public class ChatClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChatMediator med = new ChatMediatorImpl();
		ChatUser hulk = new ChatUserImpl(med, "Hulk");
		ChatUser ironman = new ChatUserImpl(med, "Iron Man");
		ChatUser thor = new ChatUserImpl(med, "Thor");
		ChatUser cap = new ChatUserImpl(med, "Captain America");
		
		med.addUser(hulk);
		med.addUser(ironman);
		med.addUser(thor);
		med.addUser(cap);
		
		hulk.send("Hulk sma-a-sh!");
		thor.send("You want me to put the hammer down?!?");
		ironman.send("...and you didn't invite me...");
		cap.send("Put on the suit, let's go a few rounds...");
	}

}
