/**
 * R&D - http://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
package org.herb.sandbox.patterns.command;

/**
 * Use the Broker class to take and execute commands
 *
 */
public class CommandPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stock stock = new Stock();
		
		BuyStock buyStockOrder = new BuyStock(stock);
		SellStock sellStockOrder = new SellStock(stock);
		
		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);
		
		broker.placeOrders();

	}

}
