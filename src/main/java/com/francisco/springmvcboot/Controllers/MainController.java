package com.francisco.springmvcboot.Controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.francisco.springmvcboot.BarCodeGenerator;
import com.francisco.springmvcboot.Entities.Category;
import com.francisco.springmvcboot.Entities.Item;
import com.francisco.springmvcboot.Entities.ItemDescription;
import com.francisco.springmvcboot.Entities.Location;
import com.francisco.springmvcboot.Entities.User;
import com.francisco.springmvcboot.Services.CategoryService;
import com.francisco.springmvcboot.Services.ItemDescriptionService;
import com.francisco.springmvcboot.Services.ItemService;
import com.francisco.springmvcboot.Services.LocationService;
import com.francisco.springmvcboot.Services.LogService;
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

	@Autowired
	BarCodeGenerator barCodeGenerator;

	@Autowired
	LogService logService;

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
			m.addAttribute("barcode", barCodeGenerator.generate(String.valueOf(id)));
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
		return entity + "/create";
	}

	@RequestMapping(path = "/{entity}/create")
	public String create(Model m, @PathVariable(name = "entity") String entity) {
		// m.addAttribute("category", new Category());
		switch (entity) {
		case "category":
			m.addAttribute("category", new Category());
			break;
		case "itemDescription":
			m.addAttribute("itemDescription", new ItemDescription());
			m.addAttribute("categoryList", categoryService.getAll());
			break;
		case "item":
			m.addAttribute("item", new Item());
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			break;
		case "location":
			m.addAttribute("location", new Location());
			break;
		case "user":
			m.addAttribute("user", new User());
			break;
		}
		/// agregar todas las dependencias aqui
		return entity + "/create";
	}

	@RequestMapping(path = "/{entity}/view/{id}/create/{entity2}")
	public String createRelated(Model m, @PathVariable(name = "entity") String entity,
			@PathVariable(name = "id") int id, @PathVariable(name = "entity2") String entity2) {
		switch (entity2) {
		case "category":
			m.addAttribute("category", new Category());
			break;
		case "itemDescription":
			ItemDescription itde = new ItemDescription();
			itde.setCategory(categoryService.read(id));
			m.addAttribute("itemDescription", itde);
			m.addAttribute("categoryList", categoryService.getAll());
			break;
		case "item":
			Item i = new Item();
			switch (entity) {
			case "itemDescription":
				i.setItemDescription(itemDescriptionService.read(id));
				break;
			case "location":
				i.setLocation(locationService.read(id));
				break;
			}

			m.addAttribute("item", i);
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			break;
		case "location":
			m.addAttribute("location", new Location());
			break;
		case "user":
			m.addAttribute("user", new User());
			break;
		}

		/*
		 * switch (entity) { case "category": m.addAttribute("category",
		 * categoryService.read(id)); break; case "itemdescription":
		 * m.addAttribute("itemdescription", itemDescriptionService.read(id)); break;
		 * case "location": m.addAttribute("location", locationService.read(id));
		 * System.out.println("por aqui tmb"); break; }
		 */

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
	public String createCategoryAction(Model m, @Valid @ModelAttribute(name = "category") Category category,
			BindingResult br) {
		if (br.hasErrors()) {
			m.addAttribute("category", category);
			return "/category/create";
		} else {
			categoryService.create(category);
			return "redirect:/category/view/" + category.getId();
		}
	}

	@RequestMapping(path = "/category/editAction")
	public String editCategoryAction(@ModelAttribute(name = "entity") Category category) {
		categoryService.update(category);
		return "redirect:/category/view/" + category.getId();
	}

	@RequestMapping(path = "/itemDescription/createAction")
	public String createItemDescriptionAction(@Valid @ModelAttribute ItemDescription id, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("itemDescription", id);
			m.addAttribute("categoryList", categoryService.getAll());
			return "/itemDescription/create";
		} else {
			itemDescriptionService.create(id);
			return "redirect:/itemDescription/view/" + id.getId();
		}

	}

	@RequestMapping(path = "/itemDescription/editAction")
	public String editItemDescriptionAction(@ModelAttribute ItemDescription id) {
		itemDescriptionService.update(id);
		return "redirect:/itemDescription/view/" + id.getId();
	}

	@RequestMapping(path = "/item/createAction")
	public String createItemAction(@Valid @ModelAttribute Item i, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("item", i);
			m.addAttribute("itemDescriptionList", itemDescriptionService.getAll());
			m.addAttribute("locationList", locationService.getAll());
			return "/item/create";
		} else {
			itemService.create(i);
			return "redirect:/item/view/" + i.getId();
		}
	}

	@RequestMapping(path = "/item/editAction")
	public String editItemAction(@ModelAttribute Item i) {
		itemService.update(i);
		return "redirect:/item/view/" + i.getId();
	}

	@RequestMapping(path = "/location/createAction")
	public String createLocationAction(@Valid @ModelAttribute Location i, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("location", i);
			return "/location/create";
		} else {
			locationService.create(i);
			return "redirect:/location/view/" + i.getId();
		}

	}

	@RequestMapping(path = "/location/editAction")
	public String editLocationAction(@ModelAttribute Location i) {
		locationService.update(i);
		return "redirect:/location/view/" + i.getId();
	}

	@RequestMapping(path = "/user/createAction")
	public String createUserAction(@Valid @ModelAttribute User i, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("user", i);
			return "/user/create";
		} else {
			userService.create(i);
			return "redirect:/user/view/" + i.getId();
		}

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

	@RequestMapping(path = "/barcode/{id}")
	public String barcode(Model m, @PathVariable(name = "id") Integer id) {
		m.addAttribute("barcode", barCodeGenerator.generate(String.valueOf(id)));
		return "printBarCode";
	}

	@Autowired
	JdbcTemplate jt;

	@RequestMapping(path = "/logs")
	public String log(Model m, @RequestParam(name = "start", required = false) String start,
			@RequestParam(name = "end", required = false) String end,
			@RequestParam(name = "operation", required = false) String operation,
			@RequestParam(name = "entity", required = false) String entity,
			@RequestParam(name = "user", required = false) String user,
			@RequestParam(name = "limit", required = false) Integer limit) {

		Timestamp tstart, tend;
		if (start == null) {
			tstart = Timestamp.valueOf(LocalDateTime.now().minusDays(1));
		} else {
			System.out.println("start = " + start.replace('T', ' '));
			tstart = Timestamp.valueOf(start.replace('T', ' ') + ":00");
		}

		if (end == null)
			tend = Timestamp.valueOf(LocalDateTime.now());
		else
			tend = Timestamp.valueOf(end.replace('T', ' ') + ":00");

		if (operation == null)
			operation = "all";

		if (entity == null)
			entity = "all";

		if (user == null)
			user = "all";

		if (limit == null)
			limit = 100;

		m.addAttribute("loglist", logService.getLogs(tstart, tend, user, operation, entity, limit));
		m.addAttribute("start", tstart.toString().replace(' ', 'T').substring(0, 16));
		m.addAttribute("end", tend.toString().replace(' ', 'T').substring(0, 16));
		m.addAttribute("operation", operation);
		m.addAttribute("entity", entity);
		m.addAttribute("user", user);
		m.addAttribute("limit", limit);

		ArrayList<String> listUsers = new ArrayList<>();
		SqlRowSet rs = jt.queryForRowSet("SELECT username FROM user");
		while (rs.next()) {
			listUsers.add(rs.getString(1).toUpperCase().charAt(0) + rs.getString(1).substring(1));
		}
		m.addAttribute("users", listUsers);
		return "/logs/index";
	}
}
