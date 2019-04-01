package work.demotask.service;

/**
 * Interface to actions on a store like adding items.
 * @author shazinahmed
 *
 */
public interface StoreService {
	
	/**
	 * Adds an item to store, if called on an existing items, updates the price and quantity
	 * @param name
	 * @param price
	 */
	void addItemToStore(String name, double price);

}
