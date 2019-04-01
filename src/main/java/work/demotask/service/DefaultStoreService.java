package work.demotask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import work.demotask.repo.StoreRepository;

@Component
public class DefaultStoreService implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public void addItemToStore(String name, double price) {
		storeRepository.addItemToStore(name, price);
	}

}
