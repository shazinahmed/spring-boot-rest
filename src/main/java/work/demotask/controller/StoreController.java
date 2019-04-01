package work.demotask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import work.demotask.model.Store;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private Store store;
	
	@RequestMapping(path="/add/{name}/{price}", method=RequestMethod.GET)
	public String addItemToStore(@PathVariable String name, @PathVariable double price)
	{
		store.addItemToStore(name, price);
		//TODO, Ideally should use string builder, but leaving as it is since this is a trivial response
		return "Added "+name+" for price "+price+" to store";
	}

}
