package com.francisco.springmvcboot.Controllers.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController extends GenericRestController<Category> {

	@Autowired
	public CategoryRestController(CategoryService cs) {
		super(cs);
		// TODO Auto-generated constructor stub
	}

}
