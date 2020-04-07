package work.demotask.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import work.demotask.model.Store;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private Store store;
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String addItemToStore(@RequestBody Map<String, String> request)
	{
		String name = request.get("name");
		int price = Integer.parseInt(request.get("price"));
		store.addItemToStore(name, price);
		//TODO, Ideally should use string builder, but leaving as it is since this is a trivial response
		return "Added "+name+" for price "+price+" to store";
	}

}
