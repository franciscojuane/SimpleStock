package com.francisco.springmvcboot.Controllers.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Services.GenericService;

@RestController
@RequestMapping("/api/item")
public class ItemRestController extends GenericRestController<Item> {

	@Autowired
	public ItemRestController(GenericService<Item> gs) {
		super(gs);
		// TODO Auto-generated constructor stub
	}

	
	
}
