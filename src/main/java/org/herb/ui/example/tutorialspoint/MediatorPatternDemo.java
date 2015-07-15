/**
 * R&D - http://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 * 
 */
package org.herb.ui.example.tutorialspoint;

/**
 * Use the User object to show communications between them
 *
 */
public class MediatorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User hulk = new User("Hulk");
		User ironman = new User("Iron Man");
		User loki = new User("Loki");
		
		ironman.sendMessage("We have a Hulk!");
		loki.sendMessage("I am a god!");
		hulk.sendMessage("Puny god...");
	}

}
