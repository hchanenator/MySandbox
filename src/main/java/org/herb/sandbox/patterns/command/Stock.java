/**
 * R&D - http://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
package org.herb.sandbox.patterns.command;

/**
 * a request class
 *
 */
public class Stock {

	private String name = "AVENGERS INC.";
	private int quantity = 10;
	
	public void buy() {
		System.out.println(String.format("Stock [ Name: %s, Quantity: %d ] bought.", name, quantity));
	}
	
	public void sell() {
		System.out.println(String.format("Stock [ Name: %s, Quantity: %d ] sold.", name, quantity));
	}
}
