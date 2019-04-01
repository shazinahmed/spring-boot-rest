package work.demotask.model;

/**
 * Store represents an online store which has many items and carts
 * @author shazinahmed
 *
 */
public interface Store {

	/**
	 * Add item with given unique name (ID) and quantity into cart.
	 * @param name
	 * @param quantity
	 * @throws IllegalArgumentException TODO
	 */
	void addItemToCart(String name, int quantity) throws IllegalArgumentException;
	
	/**
	 * Add item with given unique name (ID) and price into store inventory
	 * @param name
	 * @param price
	 */
	void addItemToStore(String name, double price);
	
	/**
	 * Get items in cart, consolidating all duplicate items order by item name
	 * @return
	 */
	LineItem[] getCartItems();
	
	/**
	 * Get total cost of items currently in cart.
	 * @return
	 */
	double getCartTotal();
}
