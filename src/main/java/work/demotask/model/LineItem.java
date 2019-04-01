package work.demotask.model;

/**
 * LineItem represents an item in the cart.
 * 
 * @author shazinahmed
 *
 */
public interface LineItem {
	
	/**
	 * Get unique item name (ID).
	 * @return
	 */
	String getName(); 
	
	/**
	 * Get item quantity. 
	 * @return
	 */
	int getQuantity();
	
	/**
	 * Get the total for the line item
	 * @return
	 */
	double getTotal();
	
	/**
	 * increments quantity
	 */
	void incrementQuantity(int quantity);
}
