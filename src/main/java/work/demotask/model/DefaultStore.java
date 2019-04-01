package work.demotask.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import work.demotask.response.Response;
import work.demotask.service.CartService;
import work.demotask.service.StoreService;

@Component
public class DefaultStore implements Store {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private CartService cartService;

	@Override
	public void addItemToCart(String name, int quantity) throws IllegalArgumentException {
		if (quantity > 0)
		{
			Response response = cartService.addItemToCart(name, quantity);
			if (Response.ITEM_NOT_FOUND.equals(response)) {
				throw new IllegalArgumentException(response.getMessage());
			}
		}
	}

	@Override
	public void addItemToStore(String name, double price) {
		storeService.addItemToStore(name, price);
	}

	@Override
	public LineItem[] getCartItems() {
		List<LineItem> lineItems = cartService.getCartItems();
		//TODO decide on whether to use a comparator or a lambda expression
		lineItems.sort((LineItem l1, LineItem l2) -> l1.getName().compareTo(l2.getName()));
		return Arrays.copyOf(lineItems.toArray(), lineItems.size(), LineItem[].class);
	}

	@Override
	public double getCartTotal() {
		return Arrays.stream(getCartItems()).collect(Collectors.summingDouble(lineItem -> lineItem.getTotal()));
	}
	
	public DefaultStore(StoreService storeService, CartService cartService) {
		this.storeService = storeService;
		this.cartService = cartService;
	}

}
