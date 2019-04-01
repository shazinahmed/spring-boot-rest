package work.demotask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
	
	@RequestMapping("/")
	public String index()
	{
		return "Greetings from store";
	}
	
	@RequestMapping("/add")
	public String add()
	{
		return "added";
	}

}
