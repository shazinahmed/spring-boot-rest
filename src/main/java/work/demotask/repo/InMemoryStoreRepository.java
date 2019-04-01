package work.demotask.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import work.demotask.model.StoreItem;

/**
 * A temporary class to make the demo working.
 * 
 * @author shazinahmed
 *
 */
@Component
public class InMemoryStoreRepository implements StoreRepository {
	
	private Map<String, StoreItem> storeItems = new HashMap<String, StoreItem>();

	@Override
	public void addItemToStore(String name, double price) {
		if (hasItemInMap(name)) {
			updatePriceOfExistingItem(name, price);
		}
		else {
			addNewItemToStore(name, price);
		}
	}

	@Override
	public StoreItem findItemByName(String name) {
		return storeItems.get(name);
	}
	
	private boolean hasItemInMap(String name) {
		return storeItems.get(name) != null;
	}
	
	private void updatePriceOfExistingItem(String name, double price) {
		StoreItem item = storeItems.get(name);
		item.setPrice(price);
		storeItems.put(name, item);
	}
	
	private void addNewItemToStore(String name, double price) {
		StoreItem item = new StoreItem(name, price);
		storeItems.put(name, item);
	}

}
