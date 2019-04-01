package work.demotask.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import work.demotask.model.DefaultLineItem;
import work.demotask.model.LineItem;
import work.demotask.model.StoreItem;
import work.demotask.response.Response;

/**
 * Temporary class to make the demo working
 * 
 * @author shazinahmed
 *
 */
@Component
public class InMemoryCartRepo implements CartRepository{
	
	private Map<String, LineItem> cartItems = new HashMap<String, LineItem>();
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Response addItemToCart(String name, int quantity) {
		if (hasItemInCart(name))
		{
			return updateQuantityForExistingItem(name, quantity);
		}
		return addNewItemToCart(name, quantity);
	}

	@Override
	public List<LineItem> getCartItems() {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		cartItems.forEach((key, value) -> {
			//Fetch store item to get the latest price
			StoreItem storeItem = storeRepository.findItemByName(key);
			if (storeItem != null)
			{
				lineItems.add(new DefaultLineItem(storeItem, value.getQuantity()));
			}
		});
		return lineItems;
	}
	
	private boolean hasItemInCart(String name)
	{
		return cartItems.get(name) != null;
	}
	
	private Response updateQuantityForExistingItem(String name, int quantity)
	{
		LineItem item = cartItems.get(name);
		item.incrementQuantity(quantity);
		cartItems.put(name, item);
		return Response.SUCCESS_ADD;
	}
	
	private Response addNewItemToCart(String name, int quantity) {
		StoreItem storeItem = storeRepository.findItemByName(name);
		if (storeItem != null)
		{
			LineItem lineItem = new DefaultLineItem(storeItem, quantity);
			cartItems.put(name, lineItem);
			return Response.SUCCESS_ADD;
		}
		return Response.ITEM_NOT_FOUND;
	}

}
