package work.demotask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import work.demotask.model.LineItem;
import work.demotask.model.Store;
import work.demotask.response.Response;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private Store store;
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String addItemToCart(@RequestBody Map<String, String> request)
	{
		StringBuilder errorMessage = new StringBuilder("No error");
		try {
			store.addItemToCart(request.get("name"), request.get("quantity"));
			//TODO Ideally this logic shouldn't be here. But for that we have to redesign the Store interface
		} catch (IllegalArgumentException e) {
			errorMessage = new StringBuilder("Error: ").append(e.getMessage());
		}
		return errorMessage.toString();
	}
	
	@RequestMapping(path="/items", method=RequestMethod.GET)
	public LineItem[] getCartItems() {
		return store.getCartItems();
	}
	
	@RequestMapping(path="/total", method=RequestMethod.GET)
	public double getCartTotal() {
		return store.getCartTotal();
	}

}
