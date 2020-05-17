package com.francisco.springmvcboot.Controllers.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.springmvcboot.Entities.ItemDescription;
import com.francisco.springmvcboot.Services.GenericService;

@RestController
@RequestMapping("/api/itemDescription")
public class ItemDescriptionRestController extends GenericRestController<ItemDescription> {

	
	@Autowired
	public ItemDescriptionRestController(GenericService<ItemDescription> gs) {
		super(gs);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
