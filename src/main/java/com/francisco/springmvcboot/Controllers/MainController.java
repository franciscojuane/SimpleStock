package com.francisco.springmvcboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Services.CategoryService;

@Controller
public class MainController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/{entity}/list")
	public String list(Model m, @PathVariable(name = "entity") String entity) {
		m.addAttribute("list", categoryService.getAll());
		m.addAttribute("title", "Categories");
		return entity + "/" + "list";
	}

	@RequestMapping(path = "/{entity}/view/{id}")
	public String read(Model m, @PathVariable(name = "entity") String entity, @PathVariable(name = "id") Integer id) {
		switch (entity) {
		case "category":
			m.addAttribute("category", categoryService.read(id));
			m.addAttribute("itemdescriptions", categoryService.read(id).getItemDescriptions());
			break;
		}

		return entity + "/view";
	}
	
	@RequestMapping(path = "/{entity}/edit/{id}")
	public String edit(Model m, @PathVariable(name = "entity") String entity, @PathVariable(name = "id") Integer id) {
		m.addAttribute("category", categoryService.read(id));
		return entity + "/edit";
	}

	@RequestMapping(path = "/{entity}/create")
	public String create(Model m, @PathVariable(name = "entity") String entity) {
		//m.addAttribute("category", new Category());
		return entity + "/create";
	}
	
	@RequestMapping(path = "/{entity}/delete/{id}")
	public String delete(@PathVariable(name="entity") String entity, @PathVariable(name="id") Integer id) {
		categoryService.delete(id);
		return "redirect:/" + entity + "/list";
	}
	
	
	
	@RequestMapping(path = "/category/createAction")
	public String createAction(@ModelAttribute(name = "entity") Category category) {
		categoryService.create(category);
		return "redirect:/category/view/" + category.getId();
	}
	
	@RequestMapping(path = "/category/editAction")
	public String editAction(@ModelAttribute(name = "entity") Category category) {
		categoryService.update(category);
		return "redirect:/category/view/" + category.getId();
	}
	
	


}
