package com.francisco.springmvcboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Entities.ItemDescription;
import com.francisco.springmvcboot.Entities.Location;
import com.francisco.springmvcboot.Entities.User;
import com.francisco.springmvcboot.Services.CategoryService;
import com.francisco.springmvcboot.Services.ItemDescriptionService;
import com.francisco.springmvcboot.Services.ItemService;
import com.francisco.springmvcboot.Services.LocationService;
import com.francisco.springmvcboot.Services.UserService;

@Controller
public class MainController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ItemDescriptionService itemDescriptionService;

	@Autowired
	ItemService itemService;

	@Autowired
	LocationService locationService;

	@Autowired
	UserService userService;

	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(path = "/{entity}/list")
	public String list(Model m, @PathVariable(name = "entity") String entity) {
		switch (entity) {
		case "category":
			m.addAttribute("list", categoryService.getAll());
			m.addAttribute("title", "Categories");
			break;
		case "itemDescription":
			m.addAttribute("list", itemDescriptionService.getAll());
			m.addAttribute("title", "Item Descriptions");
			break;
		case "item":
			m.addAttribute("list", itemService.getAll());
			m.addAttribute("title", "Items");
			break;
		case "location":
			m.addAttribute("list", locationService.getAll());
			m.addAttribute("title", "Locations");
			break;
		case "user":
			m.addAttribute("list", userService.getAll());
			m.addAttribute("title", "Users");
			break;
		}

		return entity + "/" + "list";
	}

	@RequestMapping(path = "/{entity}/view/{id}")
	public String view(Model m, @PathVariable(name = "entity") String entity, @PathVariable(name = "id") Integer id) {
		switch (entity) {
		case "category":
			m.addAttribute("category", categoryService.read(id));
			m.addAttribute("itemdescriptions", categoryService.read(id).getItemDescriptions());
			break;
		case "itemDescription":
			m.addAttribute("itemDescription", itemDescriptionService.read(id));
			m.addAttribute("items", itemDescriptionService.read(id).getItems());
		case "item":
			m.addAttribute("item", itemService.read(id));
		case "location":
			m.addAttribute("location", locationService.read(id));
			break;
		case "user":
			m.addAttribute("user", userService.read(id));
		}

		return entity + "/view";
	}

	@RequestMapping(path = "/{entity}/edit/{id}")
	public String edit(Model m, @PathVariable(name = "entity") String entity, @PathVariable(name = "id") Integer id) {
		switch (entity) {
		case "category":
			m.addAttribute("category", categoryService.read(id));
			break;
		case "itemDescription":
			m.addAttribute("itemDescription", itemDescriptionService.read(id));
			m.addAttribute("categoryList", categoryService.getAll());
			break;
		case "item":
			m.addAttribute("item", itemService.read(id));
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			break;
		case "location":
			m.addAttribute("location", locationService.read(id));
			break;
		case "user":
			m.addAttribute("user", userService.read(id));
			break;
		}
		return entity + "/edit";
	}

	@RequestMapping(path = "/{entity}/create")
	public String create(Model m, @PathVariable(name = "entity") String entity) {
		// m.addAttribute("category", new Category());
		switch (entity) {
		case "itemDescription":
			m.addAttribute("categoryList", categoryService.getAll());
			break;
		case "item":
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			break;
		}
		/// agregar todas las dependencias aqui
		return entity + "/create";
	}

	@RequestMapping(path = "/{entity}/view/{id}/create/{entity2}")
	public String createRelated(Model m, @PathVariable(name = "entity") String entity,
			@PathVariable(name = "id") int id, @PathVariable(name = "entity2") String entity2) {
		switch (entity2) {
		case "itemDescription":
			m.addAttribute("categoryList", categoryService.getAll());
			break;
		case "item":
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			System.out.println("por aqui");
			break;
		}

		switch (entity) {
		case "category":
			m.addAttribute("category", categoryService.read(id));
			break;
		case "itemdescription":
			m.addAttribute("itemdescription", itemDescriptionService.read(id));
			break;
		case "location":
			m.addAttribute("location", locationService.read(id));
			System.out.println("por aqui tmb");
			break;
		}

		return entity2 + "/create";
	}

	@RequestMapping(path = "/{entity}/delete/{id}")
	public String delete(@PathVariable(name = "entity") String entity, @PathVariable(name = "id") Integer id) {
		switch (entity) {
		case "category":
			categoryService.delete(id);
			break;
		case "itemDescription":
			itemDescriptionService.delete(id);
			break;
		case "item":
			itemService.delete(id);
			break;
		case "location":
			locationService.delete(id);
			break;
		case "user":
			userService.delete(id);
			break;
		}

		return "redirect:/" + entity + "/list";
	}

	@RequestMapping(path = "/category/createAction")
	public String createCategoryAction(@ModelAttribute(name = "entity") Category category) {
		categoryService.create(category);
		return "redirect:/category/view/" + category.getId();
	}

	@RequestMapping(path = "/category/editAction")
	public String editCategoryAction(@ModelAttribute(name = "entity") Category category) {
		categoryService.update(category);
		return "redirect:/category/view/" + category.getId();
	}

	@RequestMapping(path = "/itemDescription/createAction")
	public String createItemDescriptionAction(@ModelAttribute ItemDescription id) {
		itemDescriptionService.create(id);
		return "redirect:/itemDescription/view/" + id.getId();
	}

	@RequestMapping(path = "/itemDescription/editAction")
	public String editItemDescriptionAction(@ModelAttribute ItemDescription id) {
		itemDescriptionService.update(id);
		return "redirect:/itemDescription/view/" + id.getId();
	}
	
	@RequestMapping(path = "/item/createAction")
	public String createItemAction(@ModelAttribute Item i) {
		itemService.create(i);
		return "redirect:/item/view/" + i.getId();
	}

	@RequestMapping(path = "/item/editAction")
	public String editItemAction(@ModelAttribute Item i) {
		itemService.update(i);
		return "redirect:/item/view/" + i.getId();
	}

	
	@RequestMapping(path = "/location/createAction")
	public String createLocationAction(@ModelAttribute Location i) {
		locationService.create(i);
		return "redirect:/location/view/" + i.getId();
	}

	@RequestMapping(path = "/location/editAction")
	public String editLocationAction(@ModelAttribute Location i) {
		locationService.update(i);
		return "redirect:/location/view/" + i.getId();
	}
	
	@RequestMapping(path = "/user/createAction")
	public String createUserAction(@ModelAttribute User i) {
		userService.create(i);
		return "redirect:/user/view/" + i.getId();
	}

	@RequestMapping(path = "/user/editAction")
	public String editLocationAction(@ModelAttribute User i) {
		userService.update(i);
		return "redirect:/user/view/" + i.getId();
	}

	@RequestMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(path = "/loginerror")
	public String loginerror(Model m) {
		m.addAttribute("error", true);
		return "login";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(Model m) {
		m.addAttribute("logout", true);
		return "login";
	}
	
}
