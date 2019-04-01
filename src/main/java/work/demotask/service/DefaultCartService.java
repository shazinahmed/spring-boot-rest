package work.demotask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import work.demotask.model.LineItem;
import work.demotask.repo.CartRepository;
import work.demotask.response.Response;

@Component
public class DefaultCartService implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Response addItemToCart(String name, int quantity) {
		return cartRepository.addItemToCart(name, quantity);
	}

	@Override
	public List<LineItem> getCartItems() {
		return cartRepository.getCartItems();
	}

}
