package work.demotask.repo;

import java.util.List;

import work.demotask.model.LineItem;
import work.demotask.response.Response;

/**
 * Interface to access cart related data from DB
 * 
 * @author shazinahmed
 *
 */
public interface CartRepository {
	
	/**
	 * Add an item to cart, for existing items quantity will be updated.
	 * 
	 * @param name
	 * @param quantity
	 * @return
	 */
	Response addItemToCart(String name, int quantity);
	
	/**
	 * Get list of items from the current cart, if no item found, returns an empty list
	 * 
	 * @return
	 */
	List<LineItem> getCartItems();

}
