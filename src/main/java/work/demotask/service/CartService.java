package work.demotask.service;

import java.util.List;

import work.demotask.model.LineItem;
import work.demotask.response.Response;

public interface CartService {
	
	/**
	 * Add items to cart, if item already exists, updates the quantity
	 * 
	 * @param name
	 * @param quantity
	 * @return
	 */
	Response addItemToCart(String name, int quantity);
	
	/**
	 * Fetches the items in the current cart. The latest price is updated during this call
	 * @return
	 */
	List<LineItem> getCartItems();

}
