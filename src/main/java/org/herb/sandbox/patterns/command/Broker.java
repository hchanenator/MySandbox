/**
 * R&D - http://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
package org.herb.sandbox.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * command invoker class
 *
 */
public class Broker {

	private List<Order> orderList = new ArrayList<Order>();
	
	public void takeOrder(Order order) {
		orderList.add(order);
	}
	
	public void placeOrders() {
		for (Order order : orderList) {
			order.execute();
		}
		orderList.clear();
	}
}
