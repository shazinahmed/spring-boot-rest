package work.demotask.repo;

import work.demotask.model.StoreItem;

/**
 * Interface to access store related data from DB
 * 
 * @author shazinahmed
 *
 */
public interface StoreRepository {
	
	/**
	 * Add a new item to cart, for existing items price will be updated
	 * @param name
	 * @param price
	 */
	void addItemToStore(String name, double price);
	
	/**
	 * Find an item from name, if no item found, returns null
	 * @param name
	 * @return
	 */
	StoreItem findItemByName(String name);
}
