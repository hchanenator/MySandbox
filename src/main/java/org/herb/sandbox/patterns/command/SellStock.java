/**
 * R&D - http://www.tutorialspoint.com/design_pattern/command_pattern.htm
 */
package org.herb.sandbox.patterns.command;

/**
 * concrete class implementing the command
 *
 */
public class SellStock implements Order {

	private Stock stock;
	
	public SellStock(Stock stock) {
		this.stock = stock;
	}

	/* (non-Javadoc)
	 * @see org.herb.sandbox.patterns.command.Order#execute()
	 */
	@Override
	public void execute() {
		stock.sell();		
	}
	
}
